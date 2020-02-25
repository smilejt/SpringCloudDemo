package com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix;

import com.jt.abandon.spring.cloud.web.admin.feign.service.TestService;
import org.springframework.stereotype.Component;

/**
 * @author 10834
 */
@Component
public class TestServiceHystrixImpl implements TestService {

    @Override
    public String test(String message) {
        return String.format("Hi your message is : %s , but request bad !",message);
    }
}
