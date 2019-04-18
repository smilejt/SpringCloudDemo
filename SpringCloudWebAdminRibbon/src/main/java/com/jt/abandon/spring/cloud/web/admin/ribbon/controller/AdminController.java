/**
 * @FileName: AdminController.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.ribbon.controller;

import com.jt.abandon.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @createDate: 2019/4/17 18:14
 * @author: LY
 * @Description: Ribbon负载均衡访问接口类
 */
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(String message) {
        return adminService.sayHi(message + " in Ribbon");
    }
}
