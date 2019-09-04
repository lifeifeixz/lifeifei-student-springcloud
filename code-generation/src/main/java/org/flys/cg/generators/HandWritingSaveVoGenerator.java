package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.builder.JavaDataMethodBuilderInterface;
import org.flys.cg.builder.JavaDataMethodCodeBuilder;
import org.flys.cg.meta.Column;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.ColumnSplicing;
import org.flys.cg.util.TinyIde;
import org.flys.cg.util.TypeConverter;

import java.util.HashSet;
import java.util.Set;

/**
 * save操作vo生成器
 *
 * @author feifei.li
 */
public class HandWritingSaveVoGenerator extends AbstractGenerator implements Generator {
    private Set<String> imports = new HashSet<>();

    protected void doImport(String invoke) {
        imports.add(invoke);
    }

    public HandWritingSaveVoGenerator(String packageName) {
        super(packageName);
    }

    JavaDataMethodBuilderInterface javaDataMethodCodeBuilder = new JavaDataMethodCodeBuilder();

    @SuppressWarnings("all")
    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "vo";
        String packageName = context.getPackageRoot() + "." + layer;
        TinyIde vo = new TinyIde();
        vo.appendLineEnd("package " + packageName);
        vo.appendLine("&import&");
        String voClassName = current.getModelClassName() + "AddVo";
        vo.appendLine("/**\n" +
                " * @author feifei.li\n" +
                " */");
        vo.appendLine("public class " + voClassName + " {");
        String getAndSet = "";
        for (Column column : metaTable.getColumns()) {
            String field = ColumnSplicing.convertColumnToField(column.getName());
            String validator = "";
            if (column.isNotEmpty() && !column.isPrimaryKey()) {
                if (TypeConverter.exchange(column.getType()).equals("String")) {
                    this.doImport("javax.validation.constraints.NotEmpty");
                    validator = "@NotEmpty(message = \"" + column.getNotes() + "不能为空\")";
                } else {
                    validator = "@NotNull(message = \"" + column.getNotes() + "不能为空\")";
                    this.doImport("javax.validation.constraints.NotNull");
                }
            }
            vo.appendLine("\t" + validator);
            vo.appendLineEnd("\tprivate " + TypeConverter.exchange(column.getType()) + " " + field);
            getAndSet += javaDataMethodCodeBuilder.buildGet(column) + "\n";
            getAndSet += javaDataMethodCodeBuilder.buildSet(column);
        }
        vo.appendLine(getAndSet);
        vo.appendLine("}");
        String text = vo.toString();
        String importText = "";
        for (String imp : imports) {
            importText += "import " + imp + ";\n";
        }
        text = text.replace("&import&", importText);
        current.setSaveVoClassName(voClassName);
        current.setFullSaveVoClassName(packageName + SPOT + voClassName);
        return new Product(voClassName + ".java", text);
    }
}
