package com.jt.abandon.spring.cloud.web.admin.feign.service;

import com.jt.abandon.spring.cloud.common.utils.CustomizeResult;
import com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@Service
@FeignClient(value = "SpringCloudAuthServer", fallback = AuthServiceHystrix.class)
public interface AuthService {

    @RequestMapping(value = "/demo/login")
    String showLogin();

    @RequestMapping(value = "/demo/auth/login", method = RequestMethod.POST)
    CustomizeResult userLogin(@RequestParam("username") String username, @RequestParam("password") String password);

    @RequestMapping(value = "/demo/auth/logout/{token}")
    CustomizeResult logout(@PathVariable(value = "token") String token);

    @RequestMapping("/demo/auth/token/{token}")
    Object getUserByToken(@PathVariable(value = "token") String token);
}
