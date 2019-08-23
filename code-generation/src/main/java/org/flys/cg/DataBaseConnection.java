package org.flys.cg;

import java.util.List;

/**
 * @author feifei.li
 */
public interface DataBaseConnection {


    /**
     * 获取所有表名
     *
     * @return
     */
    List<String> getTables();

    /**
     * 根据表名获取表信息
     *
     * @param tableName
     * @return
     */
    MetaTable getTable(String tableName);
}
