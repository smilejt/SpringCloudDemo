/**
 * @FileName: AdminServerApplication.java
 * @author: LY
 * @Description:
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.admin.server;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @createDate: 2019/4/18 17:25
 * @author: LY
 * @Description:
 */
@SpringBootApplication//SpringBoot启动注解
@EnableEurekaClient//注册Eureka服务
@EnableAdminServer//开启AdminServer服务
public class AdminServerApplication {

    private static Logger logger = LoggerFactory.getLogger(AdminServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApplication.class,args);
        logger.info("---------------------AdminServer启动成功---------------------");
    }
}
