package org.flys.cg.util;

public class StringUtil {


    /**
     * 首字母大写
     * 版权声明：本文为CSDN博主「瘦子没有夏天」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/weixin_39723544/article/details/79861111
     *
     * @param str
     * @return
     */
    public static String acronymUpperCase(String str) {
        String t = str.substring(0, 1).toUpperCase() + str.substring(1);

        /*效率高的方法*/
        char[] chars = str.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] = (char) (chars[0] - 32);
        }
        return String.valueOf(chars);
    }

    public static String acronymLowercase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(StringUtil.acronymLowercase("Lifeifei"));
    }
}
