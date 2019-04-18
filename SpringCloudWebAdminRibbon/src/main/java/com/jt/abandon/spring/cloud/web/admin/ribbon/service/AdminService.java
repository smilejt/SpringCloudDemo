/**
 * @FileName: AdminService.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @createDate: 2019/4/17 18:08
 * @author: LY
 * @Description:
 */
@Service
public class AdminService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 调用实际处理方法
     * @param message
     * @return
     */
    @HystrixCommand(fallbackMethod = "error")
    public String sayHi(String message) {
        return restTemplate.getForObject("http://SpringCloudServiceAdmin/hi?message=" + message, String.class);
    }

    /**
     * 熔断处理方法
     * @param message
     * @return
     */
    public String error(String message){
        return String.format("Hi your message is : %s , but request bad !",message);
    }
}
