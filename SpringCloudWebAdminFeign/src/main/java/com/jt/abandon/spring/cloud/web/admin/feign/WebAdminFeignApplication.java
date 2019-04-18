/**
 * @FileName: WebAdminFeignApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @createDate: 2019/4/17 18:28
 * @author: LY
 * @Description: Feign启动类(实际开发中常用)
 */
@SpringBootApplication//SpringBoot启动注解
@EnableDiscoveryClient//服务注册注解
@EnableFeignClients//开启Feign
@EnableHystrixDashboard//开启Hystrix仪表盘
public class WebAdminFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebAdminFeignApplication.class, args);
        System.out.println("---------------------Feign启动成功---------------------");
    }
}
