package org.flys.cg;

import javassist.CannotCompileException;

import java.io.IOException;

/**
 * @author feifei.li
 */
public interface Console {

    /**
     * 设置包名
     *
     * @param packageName
     */
    void setPackage(String packageName);

    /**
     * 设置生成路径
     *
     * @param path
     */
    void setOutPath(String path);

    void invoke() throws CannotCompileException, IOException;
}
