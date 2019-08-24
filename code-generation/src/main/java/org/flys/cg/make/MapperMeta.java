package org.flys.cg.make;

import org.flys.cg.Column;
import org.flys.cg.Context;
import org.flys.cg.MetaTable;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.UtilClassSplicing;

import java.util.List;

public class MapperMeta {
    String packageText;
    String className;
    String modelName;
    String importText;
    String primaryKey;
    String primaryKeyType;

    public MapperMeta() {
    }

    public MapperMeta(MetaTable table) {
        Context context = Context.getInstance();
        String modelClassName = StringUtil.acronymUpperCase(UtilClassSplicing.convertColumnToField(table.getTableName()));
        this.className = modelClassName + "Mapper";
        this.modelName = modelClassName;
        this.packageText = context.getPackageRoot() + ".mapper;";
        this.importText = "import " + context.getPackageRoot() + ".model." + modelClassName + ";\n";
        List<Column> columns = table.getColumns();
        for (Column column : columns) {
            if (column.isPrimaryKey()) {
                this.primaryKey = UtilClassSplicing.convertColumnToField(column.getName());
                this.primaryKeyType = TypeConverter.exchange(column.getType());
            }
        }
    }


    public String getPackageText() {
        return packageText;
    }

    public void setPackageText(String packageText) {
        this.packageText = packageText;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getImportText() {
        return importText;
    }

    public void setImportText(String importText) {
        this.importText = importText;
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
