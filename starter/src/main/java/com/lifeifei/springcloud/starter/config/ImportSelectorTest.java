package com.lifeifei.springcloud.starter.config;

import com.lifeifei.springcloud.starter.components.Logger;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorTest implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{Logger.class.getName()};
    }
}
