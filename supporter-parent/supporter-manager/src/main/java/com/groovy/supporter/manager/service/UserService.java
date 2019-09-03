package com.groovy.supporter.manager.service;


import com.groovy.supporter.common.vo.CommonResult;

public interface UserService {
    CommonResult auth(String username, String password);
}
