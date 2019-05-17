package com.lifeifei.springcloud.starter.config;

import com.lifeifei.springcloud.starter.components.CustomArgumentResolver;
import com.lifeifei.springcloud.starter.components.SpringBeanContext;
import com.lifeifei.springcloud.starter.interceptor.CustomOneInterceptor;
import com.lifeifei.springcloud.starter.interceptor.CustomTwoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Resource
    private CustomArgumentResolver customArgumentResolver;

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(customArgumentResolver);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(SpringBeanContext.getBean(CustomOneInterceptor.class));
        registry.addInterceptor(SpringBeanContext.getBean(CustomTwoInterceptor.class));
    }
}
