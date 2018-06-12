package com.mysit.springclond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableEurekaClient //标识本工程是eureka的客户端
@EnableDiscoveryClient
public class DeptProvider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class, args);
    }
}
