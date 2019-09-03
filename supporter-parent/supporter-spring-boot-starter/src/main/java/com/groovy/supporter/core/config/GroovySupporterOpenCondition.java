package com.groovy.supporter.core.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class GroovySupporterOpenCondition implements Condition {

    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String appKey = conditionContext.getEnvironment().getProperty("groovy.supporter.appKey");
        return !StringUtils.isEmpty(appKey);
    }
}