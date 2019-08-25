package org.flys.cg.resource;

import org.flys.cg.meta.MetaTable;

import java.util.List;

/**
 * 原料来源
 *
 * @author feifei.li
 */
public interface RawMaterial {


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
