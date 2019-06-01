package com.lifeifei.springcloud.starter.mode;

import javax.validation.constraints.NotNull;

public class User {

    @NotNull(message = "姓名不可为空")
    private String name;

    @NotNull(message = "年龄不可为空")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
