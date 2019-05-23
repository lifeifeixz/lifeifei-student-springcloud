package com.lifeifei.springcloud.starter.config.bean.condit;

import com.lifeifei.springcloud.starter.components.condit.RandDataComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class ConditionalAutoConfig {

    @Bean
    @Conditional(RandIntCondition.class)
    public RandDataComponent<Integer> randIntComponent() {
        return new RandDataComponent<>(() -> new Random().nextInt(1024));
    }

    @Bean
    @Conditional(RandBooleanCondition.class)
    public RandDataComponent<Boolean> randBooleanComponent() {
        return new RandDataComponent<>(() -> new Random().nextBoolean());
    }

}
