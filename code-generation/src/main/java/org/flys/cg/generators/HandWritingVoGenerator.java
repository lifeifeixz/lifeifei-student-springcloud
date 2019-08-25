package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.builder.JavaCodeBuilder;
import org.flys.cg.builder.JavaDataMethodBuilderInterface;
import org.flys.cg.builder.JavaDataMethodCodeBuilder;
import org.flys.cg.builder.JavaMethodCodeBuilder;
import org.flys.cg.meta.Column;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.TinyIde;
import org.flys.cg.util.TypeConverter;
import org.flys.cg.util.UtilClassSplicing;

import java.util.HashSet;
import java.util.Set;

/**
 * vo生成器
 */
public class HandWritingVoGenerator extends AbstractGenerator implements Generator {
    private Set<String> imports = new HashSet<>();

    protected void doImport(String invoke) {
        imports.add(invoke);
    }

    public HandWritingVoGenerator(String packageName) {
        super(packageName);
    }

    JavaDataMethodBuilderInterface javaDataMethodCodeBuilder = new JavaDataMethodCodeBuilder();

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "vo";
        String packageName = context.getPackageRoot() + "." + layer;
        TinyIde vo = new TinyIde();
        vo.appendLineEnd("package " + packageName);
        vo.appendLine("&import&");
        String voClassName = current.getModelClassName() + "Vo";
        vo.appendLine("public class " + voClassName + " {");
        String getAndSet = "";
        for (Column column : metaTable.getColumns()) {
            String field = UtilClassSplicing.convertColumnToField(column.getName());
            String validator = "";
            if (column.isNotEmpty()) {
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
        return new Product(voClassName + ".java", text);
    }
}
