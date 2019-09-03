package com.groovy.supporter.supporter.demo.controller;

import com.groovy.supporter.core.annoation.GroovySupporter;
import com.groovy.supporter.core.annoation.GroovySupporterIgnore;
import com.groovy.supporter.supporter.demo.service.HelloService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * [@GroovySupporter]
 * - 扫描所有 public 方法、及其参数列表
 * - 忽略 getter/setter 方法
 * - 扫描当前类所有的public 成员变量
 * [@GroovySupporterIgnore]
 * - 忽略被修饰的方法、参数、成员变量
 */
@RestController
@GroovySupporter
@Data
public class HelloController {

    @Autowired
    public HelloService helloService;

    /**
     * public 变量会被自动扫描为脚本可使用的成员变量
     */
    public final String appName = "supporter-demo";

    /**
     * 忽略 [@GroovySupporterIgnore] 修饰的成员变量
     */
    @GroovySupporterIgnore
    public final String ignoreProperty = "ignoreProperty";

    /**
     * 私有成员变量会被忽略
     */
    private final String privateProperty = "privateProperty";

    @RequestMapping("hello")
    public String hello() {
        return "hello world";
    }

    @RequestMapping("ignore")
    @GroovySupporterIgnore
    public String ignoreMethod() {
        return "this is ignore method" + ignoreProperty;
    }

    /**
     * 脚本也可以直接使用 appName 成员变量
     *
     * @return appName
     */
    @RequestMapping("getAppName")
    public String getAppName() {
        return appName;
    }

    /**
     * 带参数列表的方法
     *
     * @param name 自动扫描改参数
     * @param age  被[@GroovySupporterIgnore] 修饰的参数不被扫描
     * @return Object
     */
    public Object greet(String name, @GroovySupporterIgnore Integer age) {
        return helloService.greet(name);
    }
}
