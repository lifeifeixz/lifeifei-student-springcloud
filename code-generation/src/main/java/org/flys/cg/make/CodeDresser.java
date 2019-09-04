package org.flys.cg.make;

/**
 * @program: code-generation
 * @description: 代码格式美化
 * @author: feifei.li
 * @create: 2019-09-04 18:16
 **/
public interface CodeDresser {

    /**
     * 代码格式化
     *
     * @param source
     * @return
     */
    String format(String source);
}
