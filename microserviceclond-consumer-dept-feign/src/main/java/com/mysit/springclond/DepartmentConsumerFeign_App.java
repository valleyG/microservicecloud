package com.mysit.springclond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient         //
@EnableFeignClients(basePackages = "com.mysit.springclond")         //开启我们自定义的Feign Service接口
@ComponentScan("com.mysit.springclond")
public class DepartmentConsumerFeign_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumerFeign_App.class, args);
    }
}
