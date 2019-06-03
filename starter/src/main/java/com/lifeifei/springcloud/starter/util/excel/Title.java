package com.lifeifei.springcloud.starter.util.excel;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Title {
    String name();
}
