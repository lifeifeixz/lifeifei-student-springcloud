package com.lifeifei.springcloud.starter.event;

import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Spliterator;

/**
 * @author feifei.li
 */
@Component
public class MyApplicationEvent implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        AnnotationConfigServletWebServerApplicationContext context = (AnnotationConfigServletWebServerApplicationContext) contextRefreshedEvent.getSource();
        ConfigurableEnvironment environment = context.getEnvironment();
        Spliterator<PropertySource<?>> spectator = environment.getPropertySources().spliterator();
        spectator.tryAdvance(e->{

        });
    }
}
