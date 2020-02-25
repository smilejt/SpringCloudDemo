/**
 * @FileName: AuthServerApplication.java
 * @author: LY
 * @Description: https://github.com/smilejt/SpringCloudDemo
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.auth.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @createDate: 2019/5/21 21:36
 * @author: LY
 * @Description: SSO单点登录
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = "com.jt.abandon.spring.cloud.auth.server.mapper")
public class AuthServerApplication {

    private static Logger logger = LoggerFactory.getLogger(AuthServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
        logger.info("---------------------Auth权限认证启动成功---------------------");
    }
}
