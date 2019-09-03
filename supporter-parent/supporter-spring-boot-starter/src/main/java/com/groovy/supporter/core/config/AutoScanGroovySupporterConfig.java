package com.groovy.supporter.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(GroovySupporterOpenCondition.class)
@ComponentScan("com.groovy.supporter.core")
public class AutoScanGroovySupporterConfig  {
}
