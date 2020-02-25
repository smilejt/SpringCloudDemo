package com.jt.abandon.spring.cloud.web.admin.feign.controller;

import com.jt.abandon.spring.cloud.web.admin.feign.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 10834
 */
@RestController
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    TestService testService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public String test(@RequestParam(value = "message") String message) {
        logger.info("-----Feign转发{}请求-----","test");
        return testService.test(message + " in Feign");
    }
}
