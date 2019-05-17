package com.lifeifei.springcloud.starter.mode.enums;

public enum ResultEnum {
    UNKONW_ERROR(-1, "未知错误"),
    SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "年龄小于14岁，可能正在上中学"),
    ADDRESS_ERROR(102, "address error"),
    UNIVERSITY(101, "年龄大于20岁，可能正在上大学");

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
