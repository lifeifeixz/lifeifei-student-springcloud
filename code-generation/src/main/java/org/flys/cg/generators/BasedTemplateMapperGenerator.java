package org.flys.cg.generators;

import org.flys.cg.*;
import org.flys.cg.meta.MapperMeta;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.FileUtil;


/**
 * 基于模板的mapper代码生成器
 */
public class BasedTemplateMapperGenerator extends AbstractGenerator implements Generator {

    public BasedTemplateMapperGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "mapper";
        String template = this.loadResource("Mapper.template");
        MapperMeta mapperMeta = new MapperMeta(metaTable);
        String text = make(template, mapperMeta);
        Product product = new Product();
        product.setName(mapperMeta.getClassName() + ".java");
        product.setContext(text);
        String fullClassName = mapperMeta.getPackageText() + "." + mapperMeta.getClassName();

        /*设置主键*/
        current.setPrimaryKey(mapperMeta.getPrimaryKey());
        current.setPrimaryKeyType(mapperMeta.getPrimaryKeyType());

        /*封装结果*/
        current.setMapperClassName(mapperMeta.getClassName());
        current.setFullMapperClassName(fullClassName);
        return product;
    }

    private String make(String template, MapperMeta meta) {
        template = template.replaceAll("&package&", meta.getPackageText() + ";");
        template = template.replaceAll("&class-name&", meta.getClassName());
        template = template.replaceAll("&model-class-name&", meta.getModelName());
        template = template.replaceAll("&primary-key&", meta.getPrimaryKey());
        template = template.replaceAll("&primary-key-type&", meta.getPrimaryKeyType());

        template = template.replaceAll("&import-item&", meta.getImportText());
        return template;
    }
}
