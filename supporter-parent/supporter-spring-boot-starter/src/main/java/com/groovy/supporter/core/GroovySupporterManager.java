package com.groovy.supporter.core;

import com.groovy.supporter.common.GroovyScriptTypeEnum;
import com.groovy.supporter.common.domain.MethodDO;
import com.groovy.supporter.common.domain.ParameterDO;
import com.groovy.supporter.common.domain.PropertyDO;
import com.groovy.supporter.common.domain.ScriptDO;
import com.groovy.supporter.core.annoation.GroovySupporter;
import com.groovy.supporter.core.annoation.GroovySupporterIgnore;
import com.groovy.supporter.core.config.GroovySupporterConfig;
import groovy.lang.GroovyClassLoader;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.StringUtils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Log4j2
@Component
public class GroovySupporterManager implements BeanPostProcessor {

    private static final String BLANKSPACE = " ";
    private static final String TAP = "    ";

    @Autowired
    GroovySupporterConfig groovySupporterConfig;

    @Autowired
    GroovyManagerClient groovyManagerClient;
    //所有扩展方法
    protected static final Map<String, MethodDO> METHOD_DO_MAP = new HashMap<>();
    //脚本实例
    protected static final Map<String, GroovyScript> SCRIPT_INSTANCE_MAP = new HashMap<>();
    //脚本DO
    protected static final Map<String, ScriptDO> SCRIPT_DO_MAP = new HashMap<>();
    //groovy 脚本可使用的参数列表
    protected static final Map<String, List<ParameterDO>> PARAMETER_DO_MAP = new LinkedHashMap<>();
    //groovy 脚本可使用的 spring bean 列表
    protected static final Map<String, List<PropertyDO>> PROPERTY_DO_MAP = new HashMap<>();
    //运行时property引用列表
    protected static final Map<String, Map<String, Object>> RUNTIME_PROPERTY_MAP = new HashMap<>();

    private static final ScheduledExecutorService REFRESH_SCRIPT_WORKER = Executors.newSingleThreadScheduledExecutor();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (!groovyManagerClient.checkAppKey(groovySupporterConfig.getAppKey())) {
            log.error("middle appKey not exist ", new RuntimeException("middle appKey not exist " + groovySupporterConfig.getAppKey()));
            System.exit(0);
        }
        Class<?> rootClass = bean.getClass();
        GroovySupporter groovySupporter = rootClass.getDeclaredAnnotation(GroovySupporter.class);
        if (groovySupporter == null) {
            return bean;
        }
        registerMethod(bean);
        registerProperty(bean, rootClass);
        registerParameter(rootClass);
        createGroovyScriptTemplate(rootClass);
        REFRESH_SCRIPT_WORKER.scheduleAtFixedRate(this::refreshScript, 0, 2, TimeUnit.SECONDS);
        return bean;
    }

    private void registerMethod(Object bean) {
        Class<?> rootClass = bean.getClass();
        Method[] methods = rootClass.getDeclaredMethods();
        String classSignatureMd5 = MiddleUtil.getClassSignatureMd5(rootClass, groovySupporterConfig.getAppKey());
        List<MethodDO> methodDOList = new ArrayList<>();
        if (ArrayUtils.isNotEmpty(methods)) {
            PropertyDescriptor[] propertyDescriptors;
            Set<String> getterAndSetter = null;
            try {
                BeanInfo beanInfo = Introspector.getBeanInfo(rootClass);
                propertyDescriptors = beanInfo.getPropertyDescriptors();
                getterAndSetter = new HashSet<>();
                for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
                    Method readMethod = propertyDescriptor.getReadMethod();
                    Method writeMethod = propertyDescriptor.getWriteMethod();
                    if (readMethod != null) {
                        getterAndSetter.add(readMethod.getName());
                    }
                    if (writeMethod != null) {
                        getterAndSetter.add(writeMethod.getName());
                    }
                }
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
            String className = MiddleUtil.getOriginalClassName(rootClass);
            for (Method method : methods) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    continue;
                }
                if (getterAndSetter != null && getterAndSetter.contains(method.getName())) {
                    continue;
                }
                GroovySupporterIgnore groovySupporterMethod = AnnotationUtils.findAnnotation(method, GroovySupporterIgnore.class);
                if (groovySupporterMethod != null) {
                    continue;
                }

                String methodSignatureMd5 = MiddleUtil.getMethodSignatureMd5(groovySupporterConfig.getAppKey(), rootClass, method);
                MethodDO methodDO = MethodDO.builder()
                        .appKey(groovySupporterConfig.getAppKey())
                        .methodSignature(method.toString())
                        .belongToClassName(className)
                        .belongToClassNameMd5(classSignatureMd5)
                        .methodShortName(method.getName())
                        .methodSignatureMd5(methodSignatureMd5)
                        .build();
                METHOD_DO_MAP.put(methodSignatureMd5, methodDO);
                methodDOList.add(methodDO);
            }
        }
        groovyManagerClient.registerMethod(classSignatureMd5, methodDOList);
    }

    private void registerParameter(Class<?> rootClass) {
        Method[] methods = rootClass.getDeclaredMethods();
        String classSignatureMd5 = MiddleUtil.getClassSignatureMd5(rootClass, groovySupporterConfig.getAppKey());
        if (ArrayUtils.isEmpty(methods)) {
            return;
        }
        for (Method method : methods) {
            List<ParameterDO> parameterDOList = new ArrayList<>();
            if (!Modifier.isPublic(method.getModifiers())) {
                continue;
            }
            GroovySupporterIgnore groovySupporterMethod = AnnotationUtils.findAnnotation(method, GroovySupporterIgnore.class);
            if (groovySupporterMethod != null) {
                continue;
            }
            String methodSignatureMd5 = MiddleUtil.getMethodSignatureMd5(groovySupporterConfig.getAppKey(), rootClass, method);
            Parameter[] parameters = method.getParameters();
            if (ArrayUtils.isNotEmpty(parameters)) {
                for (Parameter parameter : parameters) {
                    GroovySupporterIgnore bindIgnore = parameter.getAnnotation(GroovySupporterIgnore.class);
                    if (bindIgnore == null) {
                        ParameterDO parameterDO = ParameterDO.builder()
                                .beloneToClassNameMd5(classSignatureMd5)
                                .methodSignature(method.toString())
                                .methodSignatureMd5(methodSignatureMd5)
                                .parameterName(parameter.getName())
                                .parameterClassName(MiddleUtil.getOriginalClassName(parameter.getType()))
                                .build();
                        parameterDOList.add(parameterDO);
                    }
                }
            }
            ParameterDO targetMethodResult = ParameterDO.builder()
                    .beloneToClassNameMd5(classSignatureMd5)
                    .methodSignature(method.toString())
                    .methodSignatureMd5(methodSignatureMd5)
                    .parameterName("targetMethodResult")
                    .parameterClassName(MiddleUtil.getOriginalClassName(Object.class))
                    .build();
            ParameterDO beforeMethodResult = ParameterDO.builder()
                    .beloneToClassNameMd5(classSignatureMd5)
                    .methodSignature(method.toString())
                    .methodSignatureMd5(methodSignatureMd5)
                    .parameterName("beforeMethodResult")
                    .parameterClassName(MiddleUtil.getOriginalClassName(Object.class))
                    .build();
            parameterDOList.add(targetMethodResult);
            parameterDOList.add(beforeMethodResult);
            groovyManagerClient.registerParameter(methodSignatureMd5, parameterDOList);
            if (!CollectionUtils.isEmpty(parameterDOList)) {
                PARAMETER_DO_MAP.put(methodSignatureMd5, parameterDOList);
                log.info("registerParameter {} parameterDOList {}", method.getName(), parameterDOList.stream().map(ParameterDO::getParameterName).collect(Collectors.toList()));
            }
        }
    }

    private void registerProperty(Object bean, Class<?> rootClass) {
        try {
            Field[] fields = rootClass.getDeclaredFields();
            String beanClassName = MiddleUtil.getOriginalClassName(rootClass);
            String classSignatureMd5 = MiddleUtil.getClassSignatureMd5(rootClass, groovySupporterConfig.getAppKey());
            if (ArrayUtils.isEmpty(fields)) {
                return;
            }
            List<PropertyDO> propertyDOList = new ArrayList<>();
            Map<String, Object> propertyMap = new HashMap<>();
            for (Field field : fields) {
                if (!Modifier.isPublic(field.getModifiers())) {
                    continue;
                }
                if (field.getAnnotation(GroovySupporterIgnore.class) != null) {
                    continue;
                }
                Object property = ReflectionUtils.getField(field, bean);
                if (property == null) {
                    continue;
                }
                String propertyClassName = field.getGenericType().getTypeName();
                PropertyDO propertyDO = PropertyDO.builder()
                        .beloneToClassName(beanClassName)
                        .beloneToClassSignatureMd5(classSignatureMd5)
                        .propertyClassName(propertyClassName)
                        .propertyName(field.getName())
                        .build();
                propertyDOList.add(propertyDO);
                propertyMap.put(field.getName(), property);
            }

            groovyManagerClient.registerProperty(classSignatureMd5, propertyDOList);
            if (!CollectionUtils.isEmpty(propertyDOList)) {
                PROPERTY_DO_MAP.put(beanClassName, propertyDOList);
                RUNTIME_PROPERTY_MAP.put(beanClassName, propertyMap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void createGroovyScriptTemplate(Class rootClass) {
        String classSignatureMd5 = MiddleUtil.getClassSignatureMd5(rootClass, groovySupporterConfig.getAppKey());

        if (METHOD_DO_MAP.isEmpty()) {
            return;
        }
        List<ScriptDO> scriptDOList = new ArrayList<>();
        for (MethodDO methodDO : METHOD_DO_MAP.values()) {
            ScriptDO scriptDO = ScriptDO.builder()
                    .appKey(groovySupporterConfig.getAppKey())
                    .beloneToClassSignatureMd5(classSignatureMd5)
                    .methodSignatureMd5(methodDO.getMethodSignatureMd5())
                    .type(GroovyScriptTypeEnum.TEMPLATE.type)
                    .script(buildScriptTemplate(methodDO))
                    .build();
            scriptDOList.add(scriptDO);
        }
        groovyManagerClient.createGroovyScriptTemplate(classSignatureMd5, scriptDOList);
    }

    private String buildScriptTemplate(MethodDO methodDO) {
        List<PropertyDO> propertyDOList = PROPERTY_DO_MAP.get(methodDO.getBelongToClassName());
        StringBuilder headBuilder = new StringBuilder();
        headBuilder.append("class AspectFor").append("_").append(methodDO.getMethodShortName()).append("_").append(methodDO.getMethodSignatureMd5()).append(" implements GroovyScript {")
                .append(System.lineSeparator())
                .append(System.lineSeparator());
        if (!CollectionUtils.isEmpty(propertyDOList)) {
            propertyDOList.forEach(propertyDO -> headBuilder
                    .append(TAP)
                    .append(propertyDO.getPropertyClassName())
                    .append(BLANKSPACE)
                    .append(propertyDO.getPropertyName())
                    .append(System.lineSeparator()));
        }

        StringBuilder beforeMethodBuilder = new StringBuilder()
                .append(TAP)
                .append("@Override")
                .append(System.lineSeparator())
                .append(TAP)
                .append("Object before")
                .append("(Map<String,Object> parameter)")
                .append("{")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(TAP)
                .append("}")
                .append(System.lineSeparator());
        String beforeMethod = beforeMethodBuilder.toString();

        StringBuilder afterMethodBuilder = new StringBuilder()
                .append(TAP)
                .append("@Override")
                .append(System.lineSeparator())
                .append(TAP)
                .append("Object after")
                .append("(Map<String,Object> parameter)")
                .append("{")
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(TAP)
                .append("}");
        String afterMethod = afterMethodBuilder.toString();

        headBuilder.append(beforeMethod)
                .append(afterMethod)
                .append(System.lineSeparator())
                .append("}");
        return headBuilder.toString();
    }

    private <T extends GroovyScript> GroovyScript getGroovyScriptInstance(String groovyScript) {
        if (StringUtils.isEmpty(groovyScript)) {
            return null;
        }
        try {
            Class<T> clazz = new GroovyClassLoader().parseClass(groovyScript);
            return clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void refreshScript() {
        try {
            List<ScriptDO> scriptDOList = groovyManagerClient.listScript(groovySupporterConfig.getAppKey());
            if (CollectionUtils.isEmpty(scriptDOList)) {
                SCRIPT_DO_MAP.clear();
                SCRIPT_INSTANCE_MAP.clear();
                return;
            }
            for (ScriptDO scriptDO : scriptDOList) {
                if (ScriptDO.IS_DELETED.equals(scriptDO.getStatus())) {
                    //卸载脚本
                    SCRIPT_DO_MAP.remove(scriptDO.getMethodSignatureMd5());
                    SCRIPT_INSTANCE_MAP.remove(scriptDO.getMethodSignatureMd5());
                    continue;
                }
                try {
                    ScriptDO loadScript = SCRIPT_DO_MAP.get(scriptDO.getMethodSignatureMd5());
                    if (loadScript != null) {
                        if (loadScript.getUpdateTs().before(scriptDO.getUpdateTs())) {
                            log.info("refresh script for {} ", scriptDO.getMethodSignatureMd5());
                            SCRIPT_DO_MAP.put(scriptDO.getMethodSignatureMd5(), scriptDO);
                            GroovyScript scriptInstance = getGroovyScriptInstance(scriptDO.getScript());
                            SCRIPT_INSTANCE_MAP.put(scriptDO.getMethodSignatureMd5(), scriptInstance);
                        }
                    } else {
                        GroovyScript scriptInstance = getGroovyScriptInstance(scriptDO.getScript());
                        SCRIPT_DO_MAP.put(scriptDO.getMethodSignatureMd5(), scriptDO);
                        SCRIPT_INSTANCE_MAP.put(scriptDO.getMethodSignatureMd5(), scriptInstance);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
