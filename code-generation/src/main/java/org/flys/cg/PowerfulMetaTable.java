package org.flys.cg;

public class PowerfulMetaTable extends MetaTable {
    protected String primaryKey;
    protected String primaryKeyType;

    public PowerfulMetaTable(String tableName, String primaryKey) {
        super(tableName);
        this.primaryKey = primaryKey;
    }

    public PowerfulMetaTable(MetaTable metaTable) {
        boolean falg = false;
        for (Column column : metaTable.columns) {
            if (column.isPrimaryKey) {
                falg = true;
                this.primaryKey = column.getName();
                this.primaryKeyType = column.getType();
            }
        }
        if (!falg) {
            if (metaTable.columns != null && metaTable.columns.size() > 0) {
                this.primaryKey = metaTable.columns.get(0).getName();
                this.primaryKeyType = metaTable.columns.get(0).getType();
            }
        }

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
