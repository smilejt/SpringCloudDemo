/**
 * @FileName: SpringCloudEurekaApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @createDate: 2019/4/17 17:12
 * @author: LY
 * @Description: EurekaServer启动类
 */
@SpringBootApplication//SpringBoot启动注解
@EnableEurekaServer//启动服务注册中心注解
public class EurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        System.out.println("---------------------Eureka服务注册于发现启动成功---------------------");
    }
}
