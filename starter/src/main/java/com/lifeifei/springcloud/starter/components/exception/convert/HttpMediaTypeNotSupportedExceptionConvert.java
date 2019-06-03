package com.lifeifei.springcloud.starter.components.exception.convert;

import com.lifeifei.springcloud.starter.components.exception.AbstractExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;

@Component
public class HttpMediaTypeNotSupportedExceptionConvert extends AbstractExceptionConvertStrategy implements ExceptionConvertStrategy {
    @Override
    public Result convert(Exception e) {
        if (e instanceof HttpMediaTypeNotSupportedException) {
            return new Result(-1, ResultType.FAIL.name(), "该接口不支持您所传入的参数类型", e.toString());
        } else {
            return this.nextExceptionConvertStrategy().convert(e);
        }
    }
}
