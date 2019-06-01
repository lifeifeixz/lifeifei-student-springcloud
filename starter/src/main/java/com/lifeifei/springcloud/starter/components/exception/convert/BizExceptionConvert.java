package com.lifeifei.springcloud.starter.components.exception.convert;

import com.lifeifei.springcloud.starter.components.exception.AbstractExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.exptions.BizException;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.stereotype.Component;

@Component
public class BizExceptionConvert extends AbstractExceptionConvertStrategy implements ExceptionConvertStrategy {

    @Override
    public Result convert(Exception e) {
        if (e instanceof BizException) {
            BizException bizE = (BizException) e;
            Result result = new Result();
            result.setCode(bizE.getCode());
            result.setMsg(bizE.getMsg());
            result.setStatus(ResultType.FAIL.name());
            result.setContent(bizE.getContent());
            return result;
        } else {
            return this.getExceptionConvertStrategy().convert(e);
        }
    }
}
