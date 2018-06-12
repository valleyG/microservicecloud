package com.mysit.springclond.ConfigBeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类，相当于在xml里面的bean注入
 */
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced      //要求consumer在通过restTemplate访问服务的时候自带负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
