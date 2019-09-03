package com.groovy.supporter.manager.service.impl;

import com.groovy.supporter.common.domain.UserDOExample;
import com.groovy.supporter.common.vo.CommonResult;
import com.groovy.supporter.manager.dao.UserDOMapper;
import com.groovy.supporter.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDOMapper userDOMapper;

    @Override
    public CommonResult auth(String username, String password) {
        long count = userDOMapper.countByExample(UserDOExample
                .newAndCreateCriteria()
                .andUserNameEqualTo(username)
                .andPasswordEqualTo(password)
                .example()
        );
        if (count > 0) {
            return CommonResult.forSuccess(username);
        } else {
            return CommonResult.forFail(username, "用户名密码错误");
        }
    }
}
