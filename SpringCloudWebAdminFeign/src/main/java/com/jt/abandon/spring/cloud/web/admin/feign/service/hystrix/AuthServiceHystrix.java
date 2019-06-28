package com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @createData: 2019-06-28 14:37
 * @author: LongJunTao
 * @Description:
 */
@Component
public class AuthServiceHystrix implements AuthService {
    @Override
    public String showLogin(String redirect, Model model) {
        return "[AuthService].[showLogin]返回异常!";
    }

    @Override
    public CustomizeResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        return new CustomizeResult(500, "[AuthService].[userLogin]系统异常", null);
    }

    @Override
    public CustomizeResult logout(String token) {
        return new CustomizeResult(500, "[AuthService].[showLogin]系统异常", null);
    }

    @Override
    public Object getUserByToken(String token) {
        return new CustomizeResult(500, "[AuthService].[showLogin]系统异常", null);
    }
}
