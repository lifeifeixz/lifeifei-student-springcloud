package com.demo1;

/**
 * @author feifei.li
 */
public class TestUser {
    public static void main(String[] args) {
        Browser browser = new Chrome();
        browser.open();
        browser.jumpTo("http://www.baidu.com");
        browser.close();
    }
}
