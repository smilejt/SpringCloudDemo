package com.jt.abandon.spring.cloud.service.test.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 10834
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "message") String message) {
        logger.info("服务提供端接受到请求:{}", message);
        logger.info("服务提供端请求adminService.sayHi返回:{}", restTemplate.getForObject("SpringCloudServiceAdmin:8763/hi?message=HelloZuul",String.class));
        return String.format("test,your message is : %s , port : %s", message, port);
    }
}
