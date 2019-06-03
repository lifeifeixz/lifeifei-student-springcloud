package com.lifeifei.springcloud.starter.components.exception;

import com.lifeifei.springcloud.starter.components.SpringBeanContext;
import com.lifeifei.springcloud.starter.components.exception.convert.DefaultExceptionConvert;
import com.lifeifei.springcloud.starter.mode.Result;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ControllerAdvice
public class ExceptionHandler implements InitializingBean {

    private ExceptionConvertStrategy exceptionConvertStrategy;

    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        e.printStackTrace();
        return exceptionConvertStrategy.convert(e);
    }

    @Override
    public void afterPropertiesSet() {
        this.exceptionConvertStrategy = exceptionConvertStrategy();
    }

    public ExceptionConvertStrategy exceptionConvertStrategy() {
        List<ExceptionConvertStrategy> strategies = SpringBeanContext.getBeansByType(ExceptionConvertStrategy.class);
        ExceptionConvertStrategy strategy = strategies.get(0);
        for (int i = 0; i < strategies.size(); i++) {
            if (i != (strategies.size() - 1)) {
                strategies.get(i).setNextExceptionConvertStrategy(strategies.get(i + 1));
            } else {
                strategies.get(i).setNextExceptionConvertStrategy(new DefaultExceptionConvert());
            }
        }
        return strategy;
    }
}
