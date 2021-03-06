package org.flys.cg.builder.sql;

import org.flys.cg.meta.Column;
import org.flys.cg.builder.SqlBuilder;
import org.flys.cg.util.ColumnSplicing;

import java.util.List;

/**
 * @author feifei.li
 */
public class SqlSelectByIdBuilder implements SqlBuilder {

    private List<Column> columns;
    private String tableName;
    private String returnType;
    private String paramType;
    private String primaryKey;
    private String primaryKeyType;

    public SqlSelectByIdBuilder(List<Column> columns, String tableName,
                                String returnType, String paramType,
                                String primaryKey, String primaryKeyType) {
        this.columns = columns;
        this.tableName = tableName;
        this.returnType = returnType;
        this.paramType = paramType;
        this.primaryKey = primaryKey;
        this.primaryKeyType = primaryKeyType;
    }

    @Override
    public String buildFindAll() {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ");
        sql.append(tableName);
        sql.append(" where 1=1 ");
        for (Column column : columns) {
            String modelField = ColumnSplicing.convertColumnToField(column.getName());
            sql.append("<if test=\"" + modelField + "!=null and " + modelField + "!=''\">\n" +
                    "    and " + column.getName() + "=#{" + modelField + "}\n" +
                    "</if>");
        }
        return sql.toString();
    }

    @Override
    public String buildFindOne() {
        StringBuffer sql = new StringBuffer();
        sql.append("select * from ");
        sql.append(this.tableName);
        sql.append(" where ");
        sql.append(this.primaryKey + "=#{" + ColumnSplicing.convertColumnToField(this.primaryKey) + "}");
        return sql.toString();
    }

    @Override
    public String buildDelete() {
        StringBuffer sql = new StringBuffer();
        sql.append("DELETE FROM `" + this.tableName + "` WHERE " + this.primaryKey + "=#{" + ColumnSplicing.convertColumnToField(this.primaryKey) + "}");
        return sql.toString();
    }

    @Override
    public String buildUpdate() {

        return "";
    }

    @Override
    public String buildSave() {
        StringBuffer sql = new StringBuffer("insert into `" + this.tableName + "` ");
        String c = "(&c&)", temp_c = "";
        String v = "(&v&)", temp_v = "";
        for (int i = 0; i < this.columns.size(); i++) {
            Column column = this.columns.get(i);
            if (i == 0) {
                temp_c += "`" + column.getName() + "`";
                temp_v += "#{" + ColumnSplicing.convertColumnToField(column.getName()) + "}";
            } else {
                temp_c += ",`" + column.getName() + "`";
                temp_v += ",#{" + ColumnSplicing.convertColumnToField(column.getName()) + "}";
            }
        }
        c = c.replace("&c&", temp_c);
        v = v.replace("&v&", temp_v);
        sql.append(c);
        sql.append("values");
        sql.append(v);
        return sql.toString();
    }
}
