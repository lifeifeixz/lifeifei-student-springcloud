package com.demo5;

import java.util.Set;

/**
 * @author feifei.li
 */
public interface OnlineCollector extends StartSubscriber, StopSubscriber {

    /**
     * @param userName
     * @param workNo
     * @param operationNo
     * @param batchId
     */
    void start(String userName, String workNo, String operationNo, Long batchId);

    /**
     * 批量操作多人
     *
     * @param userNames
     * @param workNo
     * @param operationNo
     * @param batchId
     */
    void start(Set<String> userNames, String workNo, String operationNo, Long batchId);

    /**
     * 下工
     *
     * @param userName
     * @param stopReason
     */
    void stop(String userName, String stopReason);

    /**
     * 批量下工
     *
     * @param userNames
     * @param stopReason
     */
    void stop(Set<String> userNames, String stopReason);
}
