package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.exptions.BizException;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handler(Exception e) {
        Result<Object> result = new Result<>();
        e.printStackTrace();
        if (e instanceof BizException) {
            BizException bizE = (BizException) e;
            result.setCode(bizE.getCode());
            result.setMsg(bizE.getMsg());
            result.setStatus(ResultType.FAIL.name());
            result.setContent(bizE.getContent());
            return result;
        }
        result.setStatus(ResultType.FAIL.name());
        result.setMsg("系统异常");
        result.setCode(-1);
        result.setContent(e.toString());
        return result;
    }
}
