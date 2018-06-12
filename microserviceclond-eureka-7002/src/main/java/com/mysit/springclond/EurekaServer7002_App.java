package com.mysit.springclond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 添加@EnableEurekaServer
 * 标识改module为eureka的服务端
 */
@SpringBootApplication
@EnableEurekaServer   //Eureka服务启动类，接受其他微服务的注册
public class EurekaServer7002_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7002_App.class, args);
    }
}


