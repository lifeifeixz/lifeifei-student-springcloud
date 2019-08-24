package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.MetaTable;
import org.flys.cg.builder.SqlBuilder;
import org.flys.cg.builder.sql.SqlSelectByIdBuilder;
import org.flys.cg.make.MapperMeta;


public class BasedTemplateMapperXmlGenerator extends AbstractGenerator implements Generator {
    public BasedTemplateMapperXmlGenerator(String packageName) {
        super(packageName);
    }

    static final String FULL_MAPPER_CLASS = "&full-mapper-class&";
    static final String FULL_MODEL_CLASS = "&full-model-class&";
    static final String PRIMARY_KEY_TYPE = "&primary-key-type&";
    static final String SELECT_SQL = "&select-sql&";

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "mapperXml";
        String resource = this.loadResource("MapperXml.template");
        MapperMeta mapper = new MapperMeta(metaTable);
        SqlBuilder sqlBuilder = new SqlSelectByIdBuilder(metaTable.getColumns(),
                metaTable.getTableName(),
                current.getFullModelClassName(),
                current.getFullModelClassName());
        resource = resource.replaceAll(FULL_MAPPER_CLASS, current.getFullMapperClassName())
                .replaceAll(FULL_MODEL_CLASS, current.getFullModelClassName())
                .replaceAll(PRIMARY_KEY_TYPE, mapper.getPrimaryKey())
                .replaceAll(SELECT_SQL, sqlBuilder.build());
        Product product = new Product();
        product.setName(current.getMapperClassName() + ".xml");
        product.setContext(resource);
        return product;
    }
}
