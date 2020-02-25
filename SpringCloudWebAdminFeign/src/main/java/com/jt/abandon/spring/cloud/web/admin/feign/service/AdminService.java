/**
 * @FileName: AdminService.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.feign.service;

import com.jt.abandon.spring.cloud.web.admin.feign.service.hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @createDate: 2019/4/17 18:37
 * @author: LY
 * @Description: 实际处理调用接口
 */
@Service
@FeignClient(value = "SpringCloudServiceAdmin",fallback = AdminServiceHystrix.class)
public interface AdminService {

    /**
     * 测试方法
     * @param message
     * @return
     */
    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHi(@RequestParam(value = "message")String message);
}
