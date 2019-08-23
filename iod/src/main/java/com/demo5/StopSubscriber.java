package com.demo5;

/**
 * @author feifei.li
 */
public interface StopSubscriber {
    /**
     * 通知其他对象执行
     *
     * @param object
     */
    void notify(Object object);
}
