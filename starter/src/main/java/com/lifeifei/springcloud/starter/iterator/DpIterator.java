package com.lifeifei.springcloud.starter.iterator;

/**
 * @author feifei.li
 */
public interface DpIterator<T> {
    void first();

    void isLast();

    T next();

    boolean hasNext();
}
