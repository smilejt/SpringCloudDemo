/**
 * @FileName: AdminServiceHystrix.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix;

import com.jt.abandon.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * @createDate: 2019/4/17 20:29
 * @author: LY
 * @Description: 熔断处理类
 */
@Component
public class AdminServiceHystrix implements AdminService {

    /**
     * 熔断处理方法
     * @param message
     * @return
     */
    @Override
    public String sayHi(String message) {
        return String.format("Hi your message is : %s , but request bad !",message);
    }
}
