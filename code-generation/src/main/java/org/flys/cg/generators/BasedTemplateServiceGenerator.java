package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;

/**
 * service
 */
@Deprecated
public class BasedTemplateServiceGenerator extends AbstractGenerator implements Generator {
    public BasedTemplateServiceGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        return null;
    }
}
