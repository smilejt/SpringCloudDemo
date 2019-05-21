/**
 * @FileName: AuthServerApplication.java
 * @author: LY
 * @Description: https://github.com/smilejt/SpringCloudDemo
 * @version V1.0
 */
package com.jt.abandon.spring.cloud.auth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @createDate: 2019/5/21 21:36
 * @author: LY
 * @Description: SSO单点登录
 */
@SpringBootApplication
@EnableEurekaClient
public class AuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthServerApplication.class, args);
        System.out.println("---------------------SSO单点登录启动成功---------------------");
    }
}
