package org.flys.cg.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author feifei.li
 */
public class TypeConverter {
    static Map<String, String> typeDictionaries = new HashMap<>();

    static {
        typeDictionaries.put("VARCHAR", "String");
        typeDictionaries.put("DATETIME", "java.util.Date");
        typeDictionaries.put("int", "int");
        typeDictionaries.put("bigint", "long");
        typeDictionaries.put("boolean", "boolean");
        typeDictionaries.put("double", "double");
        typeDictionaries.put("float", "float");
    }


    /**
     * 类型交换
     *
     * @param columnType
     * @return
     */
    public static String exchange(String columnType) {
        String r = typeDictionaries.get(columnType);
        return r == null ? columnType : r;
    }
}
