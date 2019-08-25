package org.flys.cg;


import org.flys.cg.generators.Product;
import org.flys.cg.meta.MetaTable;

/**
 * @author feifei.li
 */
public interface Generator extends SupportPrintGenerator {

    /**
     * 生成文件
     *
     * @param metaTable
     * @return
     */
    Product doGenerate(MetaTable metaTable);
}
