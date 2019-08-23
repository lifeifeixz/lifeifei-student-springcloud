package org.flys.cg.builder;

import org.flys.cg.Column;
import org.flys.cg.TypeConverter;
import org.flys.cg.UtilClassSplicing;

/**
 * 属性建造者
 *
 * @author feifei.li
 */
public class JavaFieldCodeBuilder implements JavaCodeBuilder {
    @Override
    public String build(Column column) {
        return build(UtilClassSplicing.convertColumnToField(column.getName()), TypeConverter.exchange(column.getType()));
    }

    @Override
    public String build(String name, String type) {
        String code = "private " + TypeConverter.exchange(type) + " " + UtilClassSplicing.convertColumnToField(name) + ";\n";
        return code;
    }
}
