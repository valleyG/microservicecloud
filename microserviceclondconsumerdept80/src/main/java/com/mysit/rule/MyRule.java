package com.mysit.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SuppressWarnings("SpringFacetCodeInspection")
@Configuration
public class MyRule {

    @Bean
    public IRule Rule(){
//        return new RandomRule();
        return  new RoundRobinRule_ZDY(); //使用自定义的轮询策略，每台机器访问五次，然后换下一台机器

    }
}
