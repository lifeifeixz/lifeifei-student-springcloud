package com.lifeifei.springcloud.starter.components.exception.convert;

import com.lifeifei.springcloud.starter.components.exception.AbstractExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ExceptionConvertStrategy;
import com.lifeifei.springcloud.starter.components.exception.ParamError;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

@Component
public class MethodArgumentNotValidExceptionConvert
        extends AbstractExceptionConvertStrategy
        implements ExceptionConvertStrategy {
    @Override
    public Result convert(Exception e) {
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            return handlerMethodArgumentNotValidException(me);
        } else {
            return this.getExceptionConvertStrategy().convert(e);
        }
    }

    public Result handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();
        ArrayList<ParamError> var1 = new ArrayList<>();
        for (ObjectError error : errors) {
            var1.add(new ParamError(((FieldError) error).getField(), error.getDefaultMessage()));
        }
        return new Result(-2, ResultType.FAIL.name(), "参数异常", var1);
    }
}
