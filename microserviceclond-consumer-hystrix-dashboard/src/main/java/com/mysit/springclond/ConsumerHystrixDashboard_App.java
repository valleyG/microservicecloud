package com.mysit.springclond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerHystrixDashboard_App {
    public static void main(String [] args){
        SpringApplication.run(ConsumerHystrixDashboard_App.class,args );
    }
}
