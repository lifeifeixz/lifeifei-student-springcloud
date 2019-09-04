package org.flys.cg.make;

import de.hunsicker.jalopy.Jalopy;

/**
 * @program: code-generation
 * @description: 默认的代码格式化转化器
 * @author: feifei.li
 * @create: 2019-09-04 18:19
 **/
public class DefaultCodeDresser implements CodeDresser{
    private String fileName;

    public DefaultCodeDresser(String fileName) {
        this.fileName = fileName;
    }

    public DefaultCodeDresser() {
    }

    @Override
    public String format(String source) {
        StringBuffer buffer = new StringBuffer();
        Jalopy j = new Jalopy();
        j.setEncoding("UTF-8");
        /*第二个参数随便填个java类名*/
        j.setInput(source, fileName);
        j.setOutput(buffer);
        j.format();
        return buffer.toString();
    }
}
