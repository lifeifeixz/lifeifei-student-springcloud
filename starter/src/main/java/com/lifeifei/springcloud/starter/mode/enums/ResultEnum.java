package com.lifeifei.springcloud.starter.mode.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "年龄小于14岁，可能正在上中学"),
    ADDRESS_ERROR(101, "address error"),
    UNIVERSITY(102, "年龄大于20岁，可能正在上大学"),

    /*在该句注释上面定义您想要的异常*/
    OTHER_ERROR(999999999, "不知道发生了什么该死的问题");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }
}
