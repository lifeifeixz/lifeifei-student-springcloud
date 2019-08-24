package org.flys.cg.builder.sql;

import org.flys.cg.Column;
import org.flys.cg.builder.SqlBuilder;
import org.flys.cg.util.UtilClassSplicing;

import java.util.List;

public class SqlSelectByIdBuilder implements SqlBuilder {

    private List<Column> columns;
    private String tableName;
    private String returnType;
    private String paramType;

    public SqlSelectByIdBuilder(List<Column> columns, String tableName, String returnType, String paramType) {
        this.columns = columns;
        this.tableName = tableName;
        this.returnType = returnType;
        this.paramType = paramType;
    }

    @Override
    public String build() {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ");
        sql.append(tableName);
        sql.append(" where 1=1 ");
        for (Column column : columns) {
            sql.append("<if test=\"param." + column.getName() + "!=null and param." + column.getName() + "!=''\">\n" +
                    "    " + column.getName() + "=#{param." + UtilClassSplicing.convertColumnToField(column.getName()) + "}\n" +
                    "</if>");
        }
        return sql.toString();
    }
}
