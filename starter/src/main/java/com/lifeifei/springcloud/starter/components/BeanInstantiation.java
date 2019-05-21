package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.service.TestService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * 初始化bean前后会执行BeanPostProcessor的方法
 */
@Component
public class BeanInstantiation implements BeanPostProcessor, Ordered, DisposableBean {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        //为bean添加属性
        if (bean instanceof TestService) {
            try {
                Field field = bean.getClass().getDeclaredField("name");
                field.setAccessible(true);
                field.set(bean, "BeanPostProcessor.postProcessBeforeInitialization()测试");
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean容器被销毁");
    }
}
