package org.flys.cg.generators;

import org.flys.cg.Generator;

/**
 * @author feifei.li
 */
public abstract class AbstractGenerator implements Generator {

    protected String packageName;

    public AbstractGenerator(String packageName) {
        this.packageName = packageName;
    }
}
