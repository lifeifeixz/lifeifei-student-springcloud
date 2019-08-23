package com.demo2;

/**
 * 工时记录器
 *
 * @author feifei.li
 */
public interface WorkRecorder {

    /**
     * <storng>记录工时</storng>
     * <p>
     * 如果用户正在持续的记录，将不做操作。
     * </p>
     *
     * @param jobNo
     */
    void record(String jobNo);
}
