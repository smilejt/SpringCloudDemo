package com.jt.abandon.spring.cloud.web.admin.feign.controller;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.AuthService;
import feign.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

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

    @RequestMapping(value = "/demo/login")
    String showLogin() {
        return authService.showLogin();
    }

    @RequestMapping(value = "/demo/auth/login", method = RequestMethod.POST)
    CustomizeResult userLogin(@RequestParam("username") String username, @RequestParam("password") String password){
        return authService.userLogin(username,password);
    }

    @RequestMapping(value = "/demo/auth/logout/{token}")
    CustomizeResult logout(@PathVariable String token){
        return authService.logout(token);
    }

    @RequestMapping("/demo/auth/token/{token}")
    Object getUserByToken(@PathVariable String token){
        return authService.getUserByToken(token);
    }
}
