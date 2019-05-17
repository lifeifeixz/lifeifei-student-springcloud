package com.lifeifei.springcloud.starter.config;

import com.lifeifei.springcloud.starter.components.SpringBeanContext;
import com.lifeifei.springcloud.starter.interceptor.CustomOneInterceptor;
import com.lifeifei.springcloud.starter.interceptor.CustomTwoInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Deprecated
public class InterceptorConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(SpringBeanContext.getBean(CustomOneInterceptor.class));
        registry.addInterceptor(SpringBeanContext.getBean(CustomTwoInterceptor.class));
    }
}
