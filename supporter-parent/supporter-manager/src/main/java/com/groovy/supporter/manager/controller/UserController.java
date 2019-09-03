package com.groovy.supporter.manager.controller;

import com.groovy.supporter.common.vo.CommonResult;
import com.groovy.supporter.manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("auth")
public class UserController {

    @Autowired
    public UserService authService;

    @RequestMapping("login")
    public CommonResult authentication263(HttpServletRequest request, HttpServletResponse response, String username, String password) {

        CommonResult auth = authService.auth(username, password);
        if (0 == auth.getFlag()) {
            request.getSession().setAttribute("loginUser", username);
            Cookie loginUser = new Cookie("loginUser", username);
            loginUser.setMaxAge(30 * 60);  //设置生存期为半小时
            loginUser.setPath("/");
            response.addCookie(loginUser);
        }
        return auth;
    }

    @RequestMapping("logout")
    public CommonResult logout(HttpServletRequest request, String username) {
        request.getSession().removeAttribute(username);
        return CommonResult.forSuccess(null);
    }
}
