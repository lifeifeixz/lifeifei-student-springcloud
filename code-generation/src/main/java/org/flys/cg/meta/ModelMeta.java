package org.flys.cg.meta;

import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.UtilClassSplicing;

import java.util.List;

public class ModelMeta {
    protected String tableName;
    protected List<Column> columns;
    protected String primaryKey;
    protected String primaryKeyType;

    public ModelMeta(String tableName, List<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    public ModelMeta(MetaTable table) {
        List<Column> columns = table.getColumns();
        boolean hasPrimary = false;
        for (Column column : columns) {
            if (column.isPrimaryKey()) {
                hasPrimary = true;
                this.primaryKey = UtilClassSplicing.convertColumnToField(column.getName());
                this.primaryKeyType = TypeConverter.exchange(column.getType());
            }
        }
        /*如果没有主键的话，则临时指定一位*/
        if (!hasPrimary) {
            if (columns.size() > 0) {
                Column column = columns.get(0);
                this.primaryKey = UtilClassSplicing.convertColumnToField(column.getName());
                this.primaryKeyType = TypeConverter.exchange(column.getType());
            }
        }
    }

    private void toModel() {

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

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getPrimaryKeyType() {
        return primaryKeyType;
    }

    public void setPrimaryKeyType(String primaryKeyType) {
        this.primaryKeyType = primaryKeyType;
    }
}
