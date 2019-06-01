package com.lifeifei.springcloud.starter.components;

import com.lifeifei.springcloud.starter.exptions.BizException;
import com.lifeifei.springcloud.starter.mode.Result;
import com.lifeifei.springcloud.starter.mode.enums.ResultType;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            return handlerMethodArgumentNotValidException(me);
        }
        result.setStatus(ResultType.FAIL.name());
        result.setMsg("系统异常");
        result.setCode(-1);
        result.setContent(e.toString());
        return result;
    }

    public Result handlerMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        List<ObjectError> errors = result.getAllErrors();
        ArrayList<Error> var1 = new ArrayList<>();
        for (ObjectError error : errors) {
            var1.add(new Error(((FieldError) error).getField(),error.getDefaultMessage()));
        }

        return new Result(-2,ResultType.FAIL.name(), "参数异常",var1);
    }

    class Error{
        private String field;
        private String defaultMessage;

        public Error(String field, String defaultMessage) {
            this.field = field;
            this.defaultMessage = defaultMessage;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }

        public void setDefaultMessage(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }
    }
}
