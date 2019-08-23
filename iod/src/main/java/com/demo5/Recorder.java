package com.demo5;

/**
 * @author feifei.li
 */
public interface Recorder extends StartSubscriber, StopSubscriber {

    /**
     * 存储上工记录
     *
     * @param object
     */
    void save(Object object);
}
