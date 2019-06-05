package com.lifeifei.springcloud.starter.util.excel;

/**
 * 回调
 *
 * @param <T>
 */
public interface Callback<T> {

    /**
     * 当ExcelUtil.invlke每读取一行数据后悔调用该方法
     * 并传入读取的数据作为参数
     *
     * @param t row excel中的一行数据
     */
    void execute(T t);
}
