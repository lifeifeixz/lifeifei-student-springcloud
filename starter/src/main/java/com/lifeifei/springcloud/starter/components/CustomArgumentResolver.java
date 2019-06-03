package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.annotation.MethodBefore;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * 参数前置处理器
 * 当spring将数据传递给controller的方法时，可以在这中间做一些处理（慎用）
 */
@Component
public class CustomArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        System.out.println("参数解析器");
        System.out.println(methodParameter);
        if (methodParameter.getMethodAnnotation(MethodBefore.class) != null) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter,
                                  ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest,
                                  WebDataBinderFactory webDataBinderFactory) {
        return nativeWebRequest.getNativeRequest(HttpServletRequest.class).getParameter("name") + " resolve";
    }
}
