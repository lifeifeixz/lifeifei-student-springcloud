package com.lifeifei.springcloud.starter.components.exception;

public abstract class AbstractExceptionConvertStrategy implements ExceptionConvertStrategy {
    protected ExceptionConvertStrategy exceptionConvertStrategy;

    public ExceptionConvertStrategy setNextExceptionConvertStrategy(ExceptionConvertStrategy exceptionConvertStrategy) {
        return this.exceptionConvertStrategy = exceptionConvertStrategy;
    }

    public ExceptionConvertStrategy getExceptionConvertStrategy() {
        return exceptionConvertStrategy;
    }

    @Override
    public ExceptionConvertStrategy nextExceptionConvertStrategy() {
        return exceptionConvertStrategy;
    }
}
