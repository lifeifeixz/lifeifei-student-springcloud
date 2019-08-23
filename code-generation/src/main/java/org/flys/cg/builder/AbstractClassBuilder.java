package org.flys.cg.builder;

import org.flys.cg.generators.AbstractGenerator;

/**
 * @author feifei.li
 */
public abstract class AbstractClassBuilder extends AbstractGenerator implements ClassBuilder {

    protected String packageName;

    public AbstractClassBuilder(String packageName) {
        super(packageName);
        this.packageName = packageName;
    }
}
