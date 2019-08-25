package org.flys.cg.generators;

import javassist.*;
import org.flys.cg.*;
import org.flys.cg.builder.JavaCodeBuilder;
import org.flys.cg.builder.JavaDataMethodBuilderInterface;
import org.flys.cg.builder.JavaDataMethodCodeBuilder;
import org.flys.cg.builder.JavaFieldCodeBuilder;
import org.flys.cg.meta.Column;
import org.flys.cg.meta.Context;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.ColumnSplicing;

import java.io.IOException;
import java.util.List;

/**
 * @author feifei.li
 */
@SuppressWarnings("all")
public class ModelGenerator extends AbstractGenerator implements Generator {
    JavaCodeBuilder fieldBuilder = new JavaFieldCodeBuilder();
    JavaDataMethodBuilderInterface dataMethodBuilder = new JavaDataMethodCodeBuilder();

    public ModelGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        String doGenerate_ = doGenerate_(metaTable);
        Product product = new Product();
        product.setName(StringUtil.acronymUpperCase(ColumnSplicing.convertColumnToField(metaTable.getTableName())));
        return product;
    }

    private String doGenerate_(MetaTable metaTable) {
        this.layer = "model";
        ClassPool pool = ClassPool.getDefault();
        String className = ColumnSplicing.convertColumnToField(metaTable.getTableName());
        className = StringUtil.acronymUpperCase(className);
        CtClass ct = pool.makeClass(context.getPackageRoot() + ".model." + className);
        List<Column> columns = metaTable.getColumns();
        for (Column column : columns) {

            try {
                /*属性*/
                CtField field = CtField.make(fieldBuilder.build(column), ct);
                ct.addField(field);
                /*方法*/
                CtMethod m1 = CtMethod.make(dataMethodBuilder.buildGet(column), ct);
                CtMethod m2 = CtMethod.make(dataMethodBuilder.buildSet(column), ct);
                ct.addMethod(m1);
                ct.addMethod(m2);

            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
        try {
            ct.writeFile("D:\\JavaFile\\" + className);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ct.toString();
    }

    public static void main(String[] args) {
        Context context = Context.getInstance();
        context.setOutputPath("G:\\workspaces\\springcloud\\code-generation\\src\\main\\java");
        context.setPackageRoot("com.cg.test");
        BasedTemplateMapperGenerator com = new BasedTemplateMapperGenerator(null);
        MetaTable metaTable = new MetaTable("user");
        List<Column> columns = metaTable.getColumns();
        Column column = new Column();
        column.setName("name");
        column.setLength(255);
        column.setType("VARCHAR");
        column.setNotes("用户姓名,真实的姓名");
        columns.add(column);

        Column column0 = new Column();
        column0.setName("user_id");
        column0.setLength(10);
        column0.setType("bigint");
        column0.setNotes("用户id");
        column0.setPrimaryKey(true);
        columns.add(column0);

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

        String generate = null;
        com.print(metaTable);
        System.out.println(generate);
    }

}
