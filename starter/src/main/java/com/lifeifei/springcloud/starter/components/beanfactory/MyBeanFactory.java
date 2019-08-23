package com.lifeifei.springcloud.starter.components.beanfactory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

/**
 * spring在启动过程中会调用该类，并传入BeanFactory工厂
 * @author feifei.li
 */
@Component
public class MyBeanFactory implements BeanFactoryAware {
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }
}
