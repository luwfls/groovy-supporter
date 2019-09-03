package com.groovy.supporter.core;

import com.groovy.supporter.common.GroovyScriptTypeEnum;
import com.groovy.supporter.common.domain.ParameterDO;
import com.groovy.supporter.common.domain.ScriptDO;
import com.groovy.supporter.core.config.GroovySupporterConfig;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
@Log4j2
public class GroovyAspect {

    @Autowired
    GroovySupporterConfig groovySupporterConfig;

    @Around("@within(com.groovy.supporter.core.annoation.GroovySupporter)")
    public Object executeGroovyScript(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Signature signature = proceedingJoinPoint.getSignature();
        try {
            Class rootClass = proceedingJoinPoint.getTarget().getClass();
            Object[] args = proceedingJoinPoint.getArgs();
            String methodSignature = signature.toLongString();
            //获取groovy脚本实例
            String methodSignatureMd5 = MiddleUtil.getMethodSignatureMd5(groovySupporterConfig.getAppKey(), rootClass, methodSignature);
            ScriptDO scriptDO = GroovySupporterManager.SCRIPT_DO_MAP.get(methodSignatureMd5);
            GroovyScript groovyScript = GroovySupporterManager.SCRIPT_INSTANCE_MAP.get(methodSignatureMd5);
            if (scriptDO == null || groovyScript == null) {
                return proceedingJoinPoint.proceed();
            }
            Object targetMethodResult = null;
            if (scriptDO.getExecuteTargetMethod() == 1) {
                targetMethodResult = proceedingJoinPoint.proceed();
            }
            //装填属性
            buildProperty(rootClass, groovyScript);
            Map<String, Object> parameter = getParameter(methodSignatureMd5, args, targetMethodResult);
            GroovyScriptTypeEnum groovyScriptType = GroovyScriptTypeEnum.of(scriptDO.getType());
            if (groovyScriptType == null) {
                return proceedingJoinPoint.proceed();
            }

            switch (groovyScriptType) {
                case BEFORE:
                    return groovyScript.before(parameter);
                case AFTER:
                    return groovyScript.after(parameter);
                case AROUND:
                    Object before = groovyScript.before(parameter);
                    parameter.put("beforeMethodResult", before);
                    return groovyScript.after(parameter);
                default:
                    return targetMethodResult;
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("groovy script error for " + signature.toLongString() + " return target result", e);
            return proceedingJoinPoint.proceed();
        }
    }

    private void buildProperty(Class rootClass, GroovyScript groovyScript) {
        Map<String, Object> propertyMap = GroovySupporterManager.RUNTIME_PROPERTY_MAP.get(MiddleUtil.getOriginalClassName(rootClass));
        if (propertyMap == null || propertyMap.isEmpty()) {
            return;
        }
        propertyMap.forEach((name, value) -> {
            Field field = ReflectionUtils.findField(groovyScript.getClass(), name);
            if (field != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, groovyScript, value);
            }
        });
    }

    private Map<String, Object> getParameter(String methodSignatureMd5, Object[] args, Object targetMethodResult) {
        Map<String, Object> parameter = new HashMap<>();
        List<ParameterDO> parameterDOList = GroovySupporterManager.PARAMETER_DO_MAP.get(methodSignatureMd5);
        if (ArrayUtils.isNotEmpty(args)) {
            for (int i = 0; i < args.length; i++) {
                ParameterDO parameterDO = parameterDOList.get(i);
                parameter.put(parameterDO.getParameterName(), args[i]);
            }
        }
        //内置参数
        parameter.put("targetMethodResult", targetMethodResult);
        parameter.put("beforeMethodResult", null);
        return parameter;
    }

}
