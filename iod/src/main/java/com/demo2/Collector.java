package com.demo2;

/**
 * @author feifei.li
 */
public interface Collector {


    /**
     * 上工登记
     *
     * @param jobNo
     * @param workInfoId
     */
    void register(String jobNo, Long workInfoId);
}
