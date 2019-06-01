package com.lifeifei.springcloud.starter.components.exception;

import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;

public interface ExceptionConvertStrategy<T extends Exception> {

    /**
     * 异常转换策略
     *
     * @param e 异常对象
     * @return
     */
    default Result convert(T e){
        Result result = new Result();
        result.setStatus(ResultType.FAIL.name());
        result.setMsg("系统异常");
        result.setCode(-1);
        result.setContent(e.toString());
        return result;
    };

    /**
     * 设置策略的下一位执行者
     *
     * @param exceptionConvertStrategy
     */
    ExceptionConvertStrategy setNextExceptionConvertStrategy(ExceptionConvertStrategy exceptionConvertStrategy);
}
