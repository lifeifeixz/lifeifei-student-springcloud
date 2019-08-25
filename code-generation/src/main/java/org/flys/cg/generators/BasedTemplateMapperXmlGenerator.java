package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.MetaTable;
import org.flys.cg.PowerfulMetaTable;
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
    static final String SELECT_FIND_ALL = "&select-sql-findAll&";
    static final String SELECT_FIND_ONE = "&select-sql-findOne&";
    static final String UPDATE_SQL = "&update-sql&";
    static final String DELETE_SQL = "&delete-sql&";
    static final String SAVE_SQL = "&save-sql&";

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "mapperXml";
        String resource = this.loadResource("MapperXml.template");
        MapperMeta mapper = new MapperMeta(metaTable);
        PowerfulMetaTable powerfulMetaTable = new PowerfulMetaTable(metaTable);
        SqlBuilder selectSqlBuilder = new SqlSelectByIdBuilder(metaTable.getColumns(),
                metaTable.getTableName(),
                current.getFullModelClassName(),
                current.getFullModelClassName(),
                powerfulMetaTable.getPrimaryKey(),
                powerfulMetaTable.getPrimaryKeyType());
        resource = resource
                .replaceAll(FULL_MAPPER_CLASS, current.getFullMapperClassName())
                .replaceAll(FULL_MODEL_CLASS, current.getFullModelClassName())
                .replaceAll(PRIMARY_KEY_TYPE, mapper.getPrimaryKeyType())
                .replaceAll(SELECT_FIND_ALL, selectSqlBuilder.buildFindAll())
                .replaceAll(SELECT_FIND_ONE, selectSqlBuilder.buildFindOne())
                .replaceAll(UPDATE_SQL, selectSqlBuilder.buildUpdate())
                .replaceAll(DELETE_SQL, selectSqlBuilder.buildDelete())
                .replaceAll(SAVE_SQL, selectSqlBuilder.buildSave());


        Product product = new Product();
        product.setName(current.getMapperClassName() + ".xml");
        product.setContext(resource);
        return product;
    }
}
