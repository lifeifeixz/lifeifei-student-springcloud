package org.flys.cg.builder;

import org.flys.cg.meta.Column;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.ColumnSplicing;

/**
 * 属性建造者
 *
 * @author feifei.li
 */
public class JavaFieldCodeBuilder implements JavaCodeBuilder {
    @Override
    public String build(Column column) {
        String notes = column.getNotes();
        if (notes == null || notes.trim().length() == 0) {
            notes = column.getName();
        }
        return "/** " + notes + " */\n"
                + build(ColumnSplicing.convertColumnToField(column.getName()), TypeConverter.exchange(column.getType()));
    }

    @Override
    public String build(String name, String type) {
        String code = "private " + TypeConverter.exchange(type) + " " + ColumnSplicing.convertColumnToField(name) + ";\n";
        return code;
    }
}
