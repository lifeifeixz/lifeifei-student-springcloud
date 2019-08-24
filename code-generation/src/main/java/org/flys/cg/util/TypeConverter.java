package org.flys.cg.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feifei.li
 */
public class TypeConverter {
    static Map<String, String> typeDictionaries = new HashMap<>();

    static {
        typeDictionaries.put("varchar", "String");
        typeDictionaries.put("datetime", "java.util.Date");
        typeDictionaries.put("int", "int");
        typeDictionaries.put("bigint", "long");
        typeDictionaries.put("boolean", "boolean");
        typeDictionaries.put("double", "double");
        typeDictionaries.put("float", "float");
        typeDictionaries.put("tinyint", "int");
        typeDictionaries.put("timestamp", "long");
        typeDictionaries.put("date", "java.util.Date");
        typeDictionaries.put("blob", "String");
        typeDictionaries.put("text", "String");
        typeDictionaries.put("varbinary","String");
        typeDictionaries.put("smallint","int");
        typeDictionaries.put("decimal","java.math.BigDecimal");
    }


    /**
     * 类型交换
     *
     * @param columnType
     * @return
     */
    public static String exchange(String columnType) {
        String r = typeDictionaries.get(columnType.toLowerCase());
        return r == null ? columnType : r;
    }
}
