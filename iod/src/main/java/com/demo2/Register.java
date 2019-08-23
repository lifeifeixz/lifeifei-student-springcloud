package com.demo2;

import org.apache.catalina.User;

import java.util.List;

/**
 * 线上上工记录
 *
 * @author feifei.li
 */
public interface Register {

    /**
     * 判断是否登记过。
     *
     * @param jobNo
     * @return
     */
    boolean has(String jobNo);

    /**
     * 登记信息：
     * 姓名、岗位、班次、生产日期
     *
     * @param registerObject
     */
    void record(Object registerObject);

    /**
     * 上工登记列表
     *
     * @param findObject
     * @return
     */
    List<Object> registers(Object findObject);

    /**
     * 获取正在上工人员
     *
     * @param workNo
     * @param operationCode
     * @param batchId
     * @return
     */
    List<User> getWorkUsers(String workNo, String operationCode, Long batchId);
}
