/**
 * @FileName: WebAdminRibbonApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.web.admin.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * @createDate: 2019/4/17 17:52
 * @author: LY
 * @Description: Ribbon启动类
 */
@SpringBootApplication//SpringBoot启动注解
@EnableDiscoveryClient//注册服务
@EnableHystrix//开启Hystrix注解
//@EnableHystrixDashboard 熔断器仪表盘配置和Feign中相同
public class WebAdminRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminRibbonApplication.class, args);
        System.out.println("---------------------Ribbon启动成功---------------------");
    }
}
