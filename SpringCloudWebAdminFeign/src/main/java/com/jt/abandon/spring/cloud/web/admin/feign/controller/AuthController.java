package com.jt.abandon.spring.cloud.web.admin.feign.controller;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.AuthService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @createData: 2019-06-28 14:55
 * @author: LongJunTao
 * @Description:
 */
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @RequestMapping(value = "/api/login")
    String showLogin(String redirect, Model model) {
        return authService.showLogin(redirect, model);
    }

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    @ResponseBody
    CustomizeResult userLogin(@Param("username") String username, @Param("password") String password, HttpServletRequest request, HttpServletResponse response){
        return authService.userLogin(username,password,request,response);
    }

    @RequestMapping(value = "/api/user/logout/{token}")
    @ResponseBody
    CustomizeResult logout(@PathVariable String token){
        return authService.logout(token);
    }

    @RequestMapping("/api/user/token/{token}")
    @ResponseBody
    Object getUserByToken(@PathVariable String token){
        return authService.getUserByToken(token);
    }
}
