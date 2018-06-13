package com.mysit.springclond.ConfigBeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 配置类，相当于在xml里面的bean注入
 */
@Configuration
public class ConfigBean {
    /**
     * 达到的目的就是用我们定义的随机策略替代Ribbon默认的轮询策略
     * @return
     */
    @Bean
    public IRule myRule() {
        return new RandomRule();
    }


}
