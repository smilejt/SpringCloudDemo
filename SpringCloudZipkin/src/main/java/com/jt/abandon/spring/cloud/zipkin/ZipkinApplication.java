/**
 * @FileName: ZipkinServiceApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.zipkin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @createDate: 2019/4/18 16:25
 * @author: LY
 * @Description:
 */
@EnableEurekaClient//注册Eureka服务
@SpringBootApplication//SpringBoot启动类
@EnableZipkinServer//开启Zipkin服务
public class ZipkinApplication {

    private static final Logger logger = LoggerFactory.getLogger(ZipkinApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ZipkinApplication.class, args);
        logger.info("---------------------Zipkin启动成功---------------------");
    }
}
