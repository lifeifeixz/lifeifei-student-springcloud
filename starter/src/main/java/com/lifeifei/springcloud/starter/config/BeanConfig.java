package com.lifeifei.springcloud.starter.config;

import com.lifeifei.springcloud.starter.components.Compute;
import com.lifeifei.springcloud.starter.components.StringUtils;
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
