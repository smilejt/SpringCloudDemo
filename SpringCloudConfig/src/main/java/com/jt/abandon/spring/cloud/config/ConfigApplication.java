/**
 * @FileName: ConfigApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @createDate: 2019/4/17 23:23
 * @author: LY
 * @Description:
 */
@SpringBootApplication//SpringBoot启动注解
@EnableConfigServer//开启配置服务器注解
@EnableEurekaClient//注册Eureka服务注解
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
        System.out.println("---------------------Config服务启动成功---------------------");
    }
}
