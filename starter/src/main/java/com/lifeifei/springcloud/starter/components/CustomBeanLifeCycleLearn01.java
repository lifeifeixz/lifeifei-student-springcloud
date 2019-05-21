package com.lifeifei.springcloud.starter.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanLifeCycleLearn01 implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean, ApplicationContextAware {
    /**
     * 姓名
     */
    private String name;
    /**
     * BeanFactory
     */
    private BeanFactory beanFactory;

    private String beanName;

    static {
        System.out.println("BeanLifeCycleLearn01的静态方法块。。。。");
    }

    private ApplicationContext applicationContext;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        this.name = s;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("bean 被销毁");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("bean最后的配置");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext 配置");
        this.applicationContext = applicationContext;
    }
}
