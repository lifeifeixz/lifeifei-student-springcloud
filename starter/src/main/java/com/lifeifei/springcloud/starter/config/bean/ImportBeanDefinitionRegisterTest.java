package com.lifeifei.springcloud.starter.config.bean;

import com.lifeifei.springcloud.starter.components.demo.DateUtil;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBeanDefinitionRegisterTest implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(DateUtil.class);
        beanDefinitionRegistry.registerBeanDefinition("时间处理类", rootBeanDefinition);
    }
}
