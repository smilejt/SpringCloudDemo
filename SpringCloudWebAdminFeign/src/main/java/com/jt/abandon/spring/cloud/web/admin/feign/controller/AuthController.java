package com.jt.abandon.spring.cloud.web.admin.feign.controller;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.AuthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @createData: 2019-06-28 14:55
 * @author: LongJunTao
 * @Description:
 */
@EnableSwagger2
@Api(value = "用户登陆Controller", tags = {"用户登陆退出操作"})
@RestController
public class AuthController {

    @Autowired
    AuthService authService;

    @ApiOperation(value = "请求登陆页面", tags = {"请求登陆页面"})
    @RequestMapping(value = "/demo/login")
    String showLogin() {
        return authService.showLogin();
    }

    @ApiOperation(value = "用户登陆接口", tags = {"用户登陆接口"})
    @RequestMapping(value = "/demo/auth/login", method = RequestMethod.POST)
    CustomizeResult userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        return authService.userLogin(username, password);
    }

    @ApiOperation(value = "token有效性验证", tags = {"token有效性验证"})
    @RequestMapping(value = "/demo/auth/logout/{token}")
    CustomizeResult logout(@PathVariable String token) {
        return authService.logout(token);
    }

    @ApiOperation(value = "用户注销token", tags = {"用户注销token"})
    @RequestMapping("/demo/auth/token/{token}")
    Object getUserByToken(@PathVariable String token) {
        return authService.getUserByToken(token);
    }
}
