package org.flys.cg.generators;

import org.flys.cg.*;
import org.flys.cg.make.MapperMeta;
import org.flys.cg.util.FileUtil;

import java.util.List;

/**
 * 基于模板的mapper代码生成器
 */
public class BasedTemplateMapperGenerator extends AbstractGenerator implements Generator {

    public BasedTemplateMapperGenerator(String packageName) {
        super(packageName);
    }

    String resource = "G:\\workspaces\\springcloud\\code-generation\\src\\main\\java\\org\\flys\\cg\\template\\Mapper.template";

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "mapper";
        String template = FileUtil.readFile(resource);
        MapperMeta mapperMeta = new MapperMeta(metaTable);
        String text = make(template, mapperMeta);
        Product product = new Product();
        product.setName(mapperMeta.getClassName() + ".java");
        product.setContext(text);
        String fullClassName = mapperMeta.getPackageText() + "." + mapperMeta.getClassName();
        current.setMapperClassName(mapperMeta.getClassName());
        current.setFullMapperClassName(fullClassName);
        return product;
    }

    private String make(String template, MapperMeta meta) {
        template = template.replaceAll("&package&", meta.getPackageText());
        template = template.replaceAll("&class-name&", meta.getClassName());
        template = template.replaceAll("&model-class-name&", meta.getModelName());
        if(meta.getPrimaryKey()!=null){
            template = template.replaceAll("&primary-key&", meta.getPrimaryKey());
            template = template.replaceAll("&primary-key-type&", meta.getPrimaryKeyType());
        }
        template = template.replaceAll("&import-item&", meta.getImportText());
        return template;
    }

    public static void main(String[] args) {
        Context context = Context.getInstance();
        context.setPackageRoot("com.cg.test");
        Generator com = new BasedTemplateMapperGenerator("com.mapper");
        MetaTable metaTable = new MetaTable("user");
        List<Column> columns = metaTable.getColumns();
        Column column = new Column();
        column.setName("name");
        column.setLength(255);
        column.setType("VARCHAR");
        column.setNotes("用户姓名,真实的姓名");
        columns.add(column);

        Column column2 = new Column();
        column2.setName("age");
        column2.setLength(6);
        column2.setType("int");
        column2.setNotes("用户年龄");
        columns.add(column2);

        Column column3 = new Column();
        column3.setName("birdth");
        column3.setLength(255);
        column3.setType("DATETIME");
        column3.setNotes("出生日期");
        columns.add(column3);

        Column column4 = new Column();
        column4.setName("id");
        column4.setLength(10);
        column4.setType("bigint");
        column4.setNotes("id");
        column4.setPrimaryKey(true);
        columns.add(column4);


        String generate = null;
        ((BasedTemplateMapperGenerator) com).print(metaTable);
        System.out.println(generate);
    }
}
