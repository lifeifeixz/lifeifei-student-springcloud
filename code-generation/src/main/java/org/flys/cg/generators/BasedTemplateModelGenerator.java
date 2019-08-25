package org.flys.cg.generators;

import org.flys.cg.meta.Column;
import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.builder.JavaCodeBuilder;
import org.flys.cg.builder.JavaDataMethodBuilderInterface;
import org.flys.cg.builder.JavaDataMethodCodeBuilder;
import org.flys.cg.builder.JavaFieldCodeBuilder;
import org.flys.cg.util.FileUtil;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.ColumnSplicing;

import java.util.List;

public class BasedTemplateModelGenerator extends AbstractGenerator implements Generator {
    static final String DATA = "&data&";

    public BasedTemplateModelGenerator(String packageName) {
        super(packageName);
    }

    JavaCodeBuilder fieldBuilder = new JavaFieldCodeBuilder();
    JavaDataMethodBuilderInterface dataMethodBuilder = new JavaDataMethodCodeBuilder();


    @Override
    public Product doGenerate(MetaTable metaTable) {
        this.layer = "model";
        String resource = FileUtil.readFile(resourceRoot + "Model.template");
        String className = StringUtil.acronymUpperCase(ColumnSplicing.convertColumnToField(metaTable.getTableName()));
        resource.replace(CLASS_NAME, className);
        StringBuffer fieldStr = new StringBuffer();
        List<Column> columns = metaTable.getColumns();
        for (Column column : columns) {
            String name = ColumnSplicing.convertColumnToField(column.getName());
            String type = TypeConverter.exchange(column.getType());
            String field = fieldBuilder.build(column);
            fieldStr.append(field);
            fieldStr.append("\n");
        }

        for (Column column : columns) {
            String setMethod = dataMethodBuilder.buildGet(column);
            fieldStr.append(setMethod);
            fieldStr.append("\n");
            String getMethod = dataMethodBuilder.buildSet(column);
            fieldStr.append(getMethod);
            fieldStr.append("\n");
        }
        String packageName = context.getPackageRoot() + "." + layer;
        resource = resource.replace(PACKAGE, packageName).replace(CLASS_NAME, className);
        String classString = resource.replace(DATA, fieldStr.toString());
        Product product = new Product();
        product.setName(className + ".java");
        product.setContext(classString);
        current.setModelClassName(className);
        current.setFullModelClassName(packageName + "." + className);
        return product;
    }
}
