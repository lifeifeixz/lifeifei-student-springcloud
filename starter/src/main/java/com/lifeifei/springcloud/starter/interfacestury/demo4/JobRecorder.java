package com.lifeifei.springcloud.starter.interfacestury.demo4;

/**
 * @author feifei.li
 */
public interface JobRecorder {
    void register(String name);

    void stop(String name);
}
