package com.lifeifei.springcloud.starter.components.exception.convert;

import com.lifeifei.springcloud.starter.components.exception.AbstractExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Component;

@Component
public class HttpMessageNotReadableExceptionConvert
        extends AbstractExceptionConvertStrategy
        implements ExceptionConvertStrategy {
    @Override
    public Result convert(Exception e) {
        if (e instanceof HttpMessageNotReadableException) {
            Result result = new Result();
            result.setCode(-2);
            result.setMsg("参数异常");
            result.setStatus(ResultType.FAIL.name());
            result.setContent(null);
            return result;
        } else {
            return getExceptionConvertStrategy().convert(e);
        }
    }
}
