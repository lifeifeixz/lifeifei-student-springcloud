package org.flys.cg;

import org.flys.cg.meta.MetaTable;

/**
 * @author feifei.li
 */
public interface SupportPrintGenerator {

    /**
     * 支持打印的生成器
     *
     * @param table
     */
    void print(MetaTable table);
}
