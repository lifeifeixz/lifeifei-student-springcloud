package com.lifeifei.springcloud.starter.components;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.ResolvableType;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanContext.applicationContext = applicationContext;
    }


    public static Object getBean(String s) throws BeansException {
        return applicationContext.getBean(s);
    }


    public static <T> T getBean(String s, Class<T> aClass) throws BeansException {
        return applicationContext.getBean(s, aClass);
    }


    public static Object getBean(String s, Object... objects) throws BeansException {
        return applicationContext.getBean(s, objects);
    }


    public static <T> T getBean(Class<T> aClass) throws BeansException {
        return applicationContext.getBean(aClass);
    }


    public static <T> T getBean(Class<T> aClass, Object... objects) throws BeansException {
        return applicationContext.getBean(aClass, objects);
    }


    public static <T> ObjectProvider<T> getBeanProvider(Class<T> aClass) {
        return applicationContext.getBeanProvider(aClass);
    }


    public static <T> ObjectProvider<T> getBeanProvider(ResolvableType resolvableType) {
        return applicationContext.getBeanProvider(resolvableType);
    }


    public static boolean containsBean(String s) {
        return applicationContext.containsBean(s);
    }


    public static boolean isSingleton(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(s);
    }


    public static boolean isPrototype(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.isPrototype(s);
    }


    public static boolean isTypeMatch(String s, ResolvableType resolvableType) throws NoSuchBeanDefinitionException {
        return applicationContext.isTypeMatch(s, resolvableType);
    }


    public static boolean isTypeMatch(String s, Class<?> aClass) throws NoSuchBeanDefinitionException {
        return applicationContext.isTypeMatch(s, aClass);
    }


    public static Class<?> getType(String s) throws NoSuchBeanDefinitionException {
        return applicationContext.getType(s);
    }


    public static String[] getAliases(String s) {
        return applicationContext.getAliases(s);
    }
}
