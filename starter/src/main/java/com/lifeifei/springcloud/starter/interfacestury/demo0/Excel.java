package com.lifeifei.springcloud.starter.interfacestury.demo0;

/**
 * @author feifei.li
 */
public class Excel implements Office {
    String version = "1.0";

    @Override
    public void article(Object article) {
        writer("xls:" + article.toString());
    }

    @Override
    public void writer(String txt) {
        System.out.println(txt);
    }

    @Override
    public String version() {
        return version;
    }
}
