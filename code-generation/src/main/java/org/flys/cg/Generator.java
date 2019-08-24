package org.flys.cg;


import org.flys.cg.generators.Product;

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
    Product doGenerate(MetaTable metaTable) throws IOException;
}
