package org.flys.cg.generators;

import javassist.*;
import org.flys.cg.Column;
import org.flys.cg.Generator;
import org.flys.cg.MetaTable;
import org.flys.cg.UtilClassSplicing;
import org.flys.cg.builder.JavaCodeBuilder;
import org.flys.cg.builder.JavaDataMethodBuilderInterface;
import org.flys.cg.builder.JavaDataMethodCodeBuilder;
import org.flys.cg.builder.JavaFieldCodeBuilder;

import java.io.IOException;
import java.util.List;

/**
 * @author feifei.li
 */
public class GeneratorModel extends AbstractGenerator implements Generator {
    JavaCodeBuilder fieldBuilder = new JavaFieldCodeBuilder();
    JavaDataMethodBuilderInterface dataMethodBuilder = new JavaDataMethodCodeBuilder();

    public GeneratorModel(String packageName) {
        super(packageName);
    }

    @Override
    public String doGenerate(MetaTable metaTable) {
        ClassPool pool = ClassPool.getDefault();
        String className = UtilClassSplicing.convertColumnToField(metaTable.getTableName());
        CtClass ct = pool.makeClass(packageName + "." + className);
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
        GeneratorModel com = new GeneratorModel("com");
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

        String generate = com.doGenerate(metaTable);
        System.out.println(generate);
    }

}
