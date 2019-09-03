package com.groovy.supporter.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.groovy.supporter.manager.dao")
public class GroovySupporterManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GroovySupporterManagerApplication.class, args);
    }
}
