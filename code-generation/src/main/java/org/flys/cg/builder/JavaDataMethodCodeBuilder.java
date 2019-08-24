package org.flys.cg.builder;

import org.flys.cg.Column;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.UtilClassSplicing;

/**
 * @author feifei.li
 */
public class JavaDataMethodCodeBuilder implements JavaDataMethodBuilderInterface {

    @Override
    public String buildGet(Column column) {
        return buildGet(UtilClassSplicing.convertColumnToField(column.getName()), TypeConverter.exchange(column.getType()));
    }

    @Override
    public String buildGet(String name, String type) {
        return "public " + type + " get" + StringUtil.acronymUpperCase(name) + "(){return " + name + ";}";
    }

    @Override
    public String buildSet(Column column) {
        return buildSet(UtilClassSplicing.convertColumnToField(column.getName()), TypeConverter.exchange(column.getType()));
    }

    @Override
    public String buildSet(String name, String type) {
        return "public " + type + " set" + StringUtil.acronymUpperCase(name) + "(){return " + name + ";}";
    }
}
