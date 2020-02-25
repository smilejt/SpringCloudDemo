package com.jt.abandon.spring.cloud.service.test.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 10834
 */
@Service
@FeignClient(value = "SpringCloudServiceAdmin")
public interface AdminService {
    /**
     * 测试方法
     * @param message
     * @return
     */
    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "message")String message);
}
