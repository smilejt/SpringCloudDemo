/**
 * @FileName: ServiceAdminApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @createDate: 2019/4/17 17:27
 * @author: LY
 * @Description: EurekaClient服务客户端启动类(具体处理类,等同于普通项目的Controller层)
 */
@SpringBootApplication//SpringBoot启动注解
@EnableEurekaClient//注册Eureka服务注解
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class, args);
        System.out.println("---------------------EurekaClient服务客户端启动成功---------------------");
    }
}
