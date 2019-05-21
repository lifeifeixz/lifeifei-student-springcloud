package com.lifeifei.springcloud.starter;

import com.lifeifei.springcloud.starter.components.demo.Compute;
import com.lifeifei.springcloud.starter.config.bean.ImportBeanDefinitionRegisterTest;
import com.lifeifei.springcloud.starter.config.bean.ImportSelectorTest;
import com.lifeifei.springcloud.starter.property.KnifeProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

@Import({
        Compute.class,
        ImportSelectorTest.class,
        ImportBeanDefinitionRegisterTest.class
})
@EnableConfigurationProperties({KnifeProperty.class})
@SpringBootApplication
public class StarterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(StarterApplication.class, args);
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
//            System.out.println(name);
        }
    }

}
