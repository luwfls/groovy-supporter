package com.groovy.supporter.core.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "groovy.supporter")
@Data
public class GroovySupporterConfig {
    private String appKey;
    private String managerServer;
}
