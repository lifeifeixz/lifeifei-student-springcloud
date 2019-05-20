package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class ReturnValueHandler implements HandlerMethodReturnValueHandler {
    private HandlerMethodReturnValueHandler proxyObject;

    public ReturnValueHandler(HandlerMethodReturnValueHandler proxyObject) {
        this.proxyObject = proxyObject;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return true;
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        Result result = new Result(0, ResultType.SUCCESS.name(), "请求成功", o);
        proxyObject.handleReturnValue(result, methodParameter, modelAndViewContainer, nativeWebRequest);
    }
}
