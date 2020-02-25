/**
 * @FileName: ZuulApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @createDate: 2019/4/17 21:05
 * @author: LY
 * @Description: Zuul启动类
 */
@SpringBootApplication//SpringBoot启动注解
@EnableEurekaClient//Eureka服务注册注解
@EnableZuulProxy//开启Zuul注解
public class ZuulApplication {

    private static final Logger logger = LoggerFactory.getLogger(ZuulApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
        logger.info("---------------------Zuul启动成功---------------------");
    }
}
