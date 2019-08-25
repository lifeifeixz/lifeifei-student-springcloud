package org.flys.cg.meta;

import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.UtilClassSplicing;

import java.util.ArrayList;
import java.util.List;

public class Variable extends MetaTable {
    public Variable() {

    }

    protected MetaTable metaTable;

    public Variable(MetaTable metaTable) {
        this.metaTable = metaTable;
    }

    @Override
    public String getTableName() {
        return StringUtil.acronymUpperCase(UtilClassSplicing.convertColumnToField(this.metaTable.getTableName()));
    }

    @Override
    public List<Column> getColumns() {
        ArrayList<Column> arrayList = new ArrayList<>();
        this.metaTable.getColumns().stream().forEach(e -> {
            e.setName(UtilClassSplicing.convertColumnToField(e.getName()));
            e.setType(TypeConverter.exchange(e.getType()));
            arrayList.add(e);
        });

        return arrayList;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "tableName='" + tableName + '\'' +
                ", columns=" + columns +
                '}';
    }
}
