package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.mode.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * controller方法返回结果处理器。
 * 在spring调用controller.method()后执行。
 * 可对controller返回的结果再次增强处理
 */
@ControllerAdvice
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Result> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Result beforeBodyWrite(Result result, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        result.setMsg(result.getMsg() + "[本消息由MyResponseBodyAdvice提供]");
        return result;
    }
}
