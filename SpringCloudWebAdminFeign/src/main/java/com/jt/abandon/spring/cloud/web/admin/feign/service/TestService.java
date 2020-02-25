package com.jt.abandon.spring.cloud.web.admin.feign.service;

import com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix.TestServiceHystrixImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10834
 */
@Service
@FeignClient(value = "SpringCloudServiceTest", fallback = TestServiceHystrixImpl.class)
public interface TestService {

    /**
     * 测试方法
     *
     * @param message
     * @return
     */
    @RequestMapping(value = "test", method = RequestMethod.GET)
    String test(@RequestParam(value = "message") String message);
}
