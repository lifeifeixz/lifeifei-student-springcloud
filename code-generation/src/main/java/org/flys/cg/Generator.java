package org.flys.cg;

import javassist.CannotCompileException;

import java.io.IOException;

/**
 * @author feifei.li
 */
public interface Generator {

    /**
     * 生成文件
     *
     * @param metaTable
     * @return
     */
    String doGenerate(MetaTable metaTable) throws CannotCompileException, IOException;
}
