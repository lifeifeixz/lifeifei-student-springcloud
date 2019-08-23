package org.flys.cg.builder;

import org.flys.cg.Column;
import org.flys.cg.StringUtil;
import org.flys.cg.TypeConverter;
import org.flys.cg.UtilClassSplicing;

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
        return "public int get" + StringUtil.acronymUpperCase(name) + "(){return " + name + ";}";
    }

    @Override
    public String buildSet(Column column) {
        return buildSet(UtilClassSplicing.convertColumnToField(column.getName()), TypeConverter.exchange(column.getType()));
    }

    @Override
    public String buildSet(String name, String type) {
        return "public int set" + StringUtil.acronymUpperCase(name) + "(){return " + name + ";}";
    }
}
