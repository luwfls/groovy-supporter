package com.groovy.supporter.supporter.demo.service.impl;

import com.groovy.supporter.supporter.demo.service.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greet(String name) {
        return "this is greet from HelloService, hai ~ " + name;
    }
}
