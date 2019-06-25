package com.jt.abandon.spring.cloud.auth.server.controller;

import com.jt.abandon.spring.cloud.auth.server.service.UserService;
import com.jt.abandon.spring.cloud.auth.server.utils.CustomizeResult;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CustomizeResult userLogin(@Param("username") String username, @Param("password") String password,
                                     HttpServletRequest request, HttpServletResponse response) {
        try {
            if (null == username || "".equals(username) || null == password || "".equals(password)) {
                logger.info("[UserController].[userLogin]用户名或密码为空,username >>> {}, password >>> {}", username, password);
                return CustomizeResult.build(400, "用户名或密码不能为空!");
            }
            CustomizeResult result = userService.userLogin(username, password, request, response);
            logger.info("[UserController].[userLogin]登录成功,userName:{}", username);
            return result;
        } catch (Exception e) {
            logger.error("[UserController].[userLogin]系统异常:{}", e.getMessage());
            return CustomizeResult.build(500, "系统异常");
        }
    }

    @RequestMapping(value = "/logout/{token}")
    @ResponseBody
    public CustomizeResult logout(@PathVariable String token) {
        try {
            userService.logout(token);
            return CustomizeResult.build(200, "退出登录成功");
        } catch (Exception e) {
            logger.error("[UserController].[logout]系统异常:{}", e.getMessage());
            return CustomizeResult.build(500, "系统异常");
        }
    }

    @RequestMapping("/token/{token}")
    @ResponseBody
    public Object getUserByToken(@PathVariable String token) {
        CustomizeResult result = null;
        try {
            result = userService.queryUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("[UserController].[getUserByToken]系统异常:{}", e.getMessage());
            result = CustomizeResult.build(500, "系统异常");
        }
        return result;
    }
}
