package com.mysit.springclond;

import com.mysit.rule.MyRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableEurekaClient         //
@RibbonClient(value = "MICROSERVICECLOUD-DEPT",configuration = MyRule.class)//针对MICROSERVICECLOND-DEPT这个微服务，我们使用我们自己的配置，使用我们自定义的策略算法
public class DepartmentConsumer80_App {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentConsumer80_App.class, args);
    }
}
