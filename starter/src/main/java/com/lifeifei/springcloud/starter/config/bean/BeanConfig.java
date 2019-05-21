package com.lifeifei.springcloud.starter.config.bean;

import com.lifeifei.springcloud.starter.components.demo.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public StringUtils stringUtils() {
        return new StringUtils();
    }

//    @Bean
//    public Compute compute() {
//        return new Compute();
//    }
}
