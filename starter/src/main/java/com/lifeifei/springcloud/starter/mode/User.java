package com.lifeifei.springcloud.starter.mode;

import com.lifeifei.springcloud.starter.util.excel.Title;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class User {

    @Title(name = "姓名")
    @NotNull(message = "姓名不可为空")
    private String name;

    @Title(name = "年龄")
    @Min(18)
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
