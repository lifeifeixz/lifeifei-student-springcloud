package org.flys.cg;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feifei.li
 */
public class MetaTable {
    protected String tableName;
    protected List<Column> columns;

    public MetaTable() {
    }

    public MetaTable(String tableName) {
        this.tableName = tableName;
        columns = new ArrayList<>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}
