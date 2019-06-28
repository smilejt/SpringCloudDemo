package com.jt.abandon.spring.cloud.web.admin.feign.service;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix.AuthServiceHystrix;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@FeignClient(value = "SpringCloudAuthServer", fallback = AuthServiceHystrix.class)
public interface AuthService {

    @RequestMapping(value = "/api/login")
    String showLogin(String redirect, Model model);

    @RequestMapping(value = "/api/user/login", method = RequestMethod.POST)
    @ResponseBody
    CustomizeResult userLogin(@Param("username") String username, @Param("password") String password, HttpServletRequest request, HttpServletResponse response);

    @RequestMapping(value = "/api/user/logout/{token}")
    @ResponseBody
    CustomizeResult logout(@PathVariable String token);

    @RequestMapping("/api/user/token/{token}")
    @ResponseBody
    Object getUserByToken(@PathVariable String token);
}
