package com.demo1;

/**
 * @author feifei.li
 */
public interface Browser {
    /*firefox*/

    /**
     * 跳转到某个链接地址
     *
     * @param link
     * @return
     */
    Object jumpTo(String link);

    /**
     * 关闭浏览器
     */
    void close();

    /**
     * 打开浏览器
     */
    void open();
}
