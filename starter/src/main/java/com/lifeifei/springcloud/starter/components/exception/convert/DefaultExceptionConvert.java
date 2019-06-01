package com.lifeifei.springcloud.starter.components.exception.convert;

import com.lifeifei.springcloud.starter.components.exception.AbstractExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;

public class DefaultExceptionConvert extends AbstractExceptionConvertStrategy implements ExceptionConvertStrategy {
    @Override
    public Result convert(Exception e) {
        Result result = new Result();
        result.setStatus(ResultType.FAIL.name());
        result.setMsg("系统异常");
        result.setCode(-1);
        result.setContent(e.toString());
        return result;
    }
}
