package com.lifeifei.springcloud.starter.mode;

public class Result<T> {
    private int code;
    private String status;
    private String msg;
    private T content;

    public Result() {
    }

    public Result(String status) {
        this.status = status;
    }

    public Result(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Result(String msg, T content) {
        this.msg = msg;
        this.content = content;
    }

    public Result(String status, String msg, T content) {
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public Result(int code, String msg, T content) {
        this.code = code;
        this.msg = msg;
        this.content = content;
    }

    public Result(int code, String status, String msg, T content) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
