package com.lifeifei.springcloud.starter.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.stereotype.Service;

@Service
public class BeanLifeCycle implements BeanNameAware, InitializingBean, BeanFactoryAware, DisposableBean {

    private String name;
    private BeanFactory beanFactory;
    private String beanName;

    static {
        System.out.println("BeanLifeCycleLearn01的静态方法块。。。。");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }
}
