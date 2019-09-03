package com.groovy.supporter.core;

import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;

public class MiddleUtil {
    public static String getOriginalClassName(Class rootClass) {
        if (ClassUtils.isCglibProxyClass(rootClass)) {
            Class<?> proxySuperClass = rootClass.getSuperclass();
            return proxySuperClass.getName();
        } else {
            return rootClass.getName();
        }
    }

    public static String getMethodSignatureMd5(String appKey, Class rootClass, Method method) {
        return MD5Util.crypt(appKey + getOriginalClassName(rootClass) + method.toString());
    }

    public static String getMethodSignatureMd5(String appKey, Class rootClass, String methodSignature) {
        return MD5Util.crypt(appKey + getOriginalClassName(rootClass) + methodSignature);
    }

    public static String getClassSignatureMd5(Class<?> rootClass, String appKey) {
        return MD5Util.crypt(appKey + getOriginalClassName(rootClass));
    }
}
