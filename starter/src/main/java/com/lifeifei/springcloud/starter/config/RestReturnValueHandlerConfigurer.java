package com.lifeifei.springcloud.starter.config;

import com.lifeifei.springcloud.starter.components.ReturnValueHandler;
import com.lifeifei.springcloud.starter.components.SpringBeanContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class RestReturnValueHandlerConfigurer implements InitializingBean {

    @Override
    public void afterPropertiesSet() {
        RequestMappingHandlerAdapter requestMappingHandlerAdapter = SpringBeanContext.getBean(RequestMappingHandlerAdapter.class);
        List<HandlerMethodReturnValueHandler> valueHandlers = requestMappingHandlerAdapter.getReturnValueHandlers();
        List<HandlerMethodReturnValueHandler> newList = new ArrayList<>();
        for (HandlerMethodReturnValueHandler handler : valueHandlers) {
            if (handler instanceof RequestResponseBodyMethodProcessor) {
                newList.add(new ReturnValueHandler(handler));
            } else {
                newList.add(handler);
            }
        }
        requestMappingHandlerAdapter.setReturnValueHandlers(newList);
    }
}
