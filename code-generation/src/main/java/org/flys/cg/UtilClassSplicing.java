package org.flys.cg;

/**
 * @author feifei.li
 */
public class UtilClassSplicing {
    public static String convertColumnToField(String column) {
        if (column == null || column.length() == 0) {
            throw new RuntimeException("字符串为空，不可转换");
        }
        String[] slot = column.split("_");
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < slot.length; i++) {
            String s = slot[i];
            if (i == 0) {
                result.append(s);
            } else {
                result.append(StringUtil.acronymUpperCase(s));
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(UtilClassSplicing.convertColumnToField("mes_v2_demo"));
    }
}
