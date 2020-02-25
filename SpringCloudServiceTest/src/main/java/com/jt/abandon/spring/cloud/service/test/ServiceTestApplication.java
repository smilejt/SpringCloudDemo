package com.jt.abandon.spring.cloud.service.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author 10834
 */
@SpringBootApplication
@EnableEurekaClient
public class ServiceTestApplication {

    private static final Logger logger = LoggerFactory.getLogger(ServiceTestApplication.class);

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


    public static void main(String[] args) {
        SpringApplication.run(ServiceTestApplication.class, args);
        logger.info("---------------------ServiceTest服务提供端启动成功---------------------");
    }
}
