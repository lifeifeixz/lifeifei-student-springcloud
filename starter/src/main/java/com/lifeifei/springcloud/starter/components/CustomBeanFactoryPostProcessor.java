package com.lifeifei.springcloud.starter.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * bean定义操作
 */
@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    public CustomBeanFactoryPostProcessor() {
        System.out.println("BeanFactoryPostProcessor实现类构造器");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        Map<String, Object> map = configurableListableBeanFactory.getBeansWithAnnotation(Autowired.class);
        map.keySet().stream().forEach(e -> System.out.println("bean定义数据:"+map.get(e)));
    }
}
