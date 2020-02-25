/**
 * @FileName: SpringCloudEurekaApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.eureka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @createDate: 2019/4/17 17:12
 * @author: LY
 * @Description: EurekaServer启动类
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {

    private static final Logger logger = LoggerFactory.getLogger(EurekaApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
        logger.info("---------------------Eureka服务注册于发现启动成功---------------------");
    }
}
