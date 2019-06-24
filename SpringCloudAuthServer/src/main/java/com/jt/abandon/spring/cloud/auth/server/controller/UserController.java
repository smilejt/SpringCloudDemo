package com.jt.abandon.spring.cloud.auth.server.controller;

import com.jt.abandon.spring.cloud.auth.server.service.UserService;
import com.jt.abandon.spring.cloud.auth.utils.CustomizeResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @createData: 2019-06-24 15:56
 * @author: LongJunTao
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CustomizeResult userLogin(String username, String password,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            CustomizeResult result = userService.userLogin(username, password, request, response);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return CustomizeResult.build(500, "");
        }
    }

    @RequestMapping(value = "/logout/{token}")
    public String logout(@PathVariable String token) {
        userService.logout(token); // 思路是从Redis中删除key，实际情况请和业务逻辑结合
        return "index";
    }

    @RequestMapping("/token/{token}")
    @ResponseBody
    public Object getUserByToken(@PathVariable String token) {
        CustomizeResult result = null;
        try {
            result = userService.queryUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            result = CustomizeResult.build(500, "");
        }
        return result;
    }
}
