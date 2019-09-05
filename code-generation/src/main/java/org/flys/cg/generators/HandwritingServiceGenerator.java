package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.meta.ModelMeta;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TinyIde;
import org.flys.cg.util.ColumnSplicing;
import org.flys.cg.util.TypeConverter;

/**
 * 手写service
 *
 * @author feifei.li
 */
public class HandwritingServiceGenerator extends AbstractGenerator implements Generator {
    public HandwritingServiceGenerator(String packageName) {
        super(packageName);
    }

    protected ModelMeta modelMeta;
    protected MetaTable metaTable;
    protected String serviceName;
    protected String packageName;

    @Override
    public Product doGenerate(MetaTable metaTable) {
        modelMeta = new ModelMeta(metaTable);
        this.metaTable = metaTable;
        super.layer = "service";
        String serviceName = StringUtil.acronymUpperCase(ColumnSplicing.convertColumnToField(metaTable.getTableName()));
        serviceName = serviceName + "Service";
        this.packageName = context.getPackageRoot() + "." + layer;
        String code = writer(serviceName);
        current.setServiceClassName(serviceName);
        current.setFullServiceClassName(packageName + "." + serviceName);
        return new Product((serviceName + ".java"), code);
    }

    private String writer(String serviceName) {
        TinyIde code = new TinyIde();
        code.appendLineEnd("package " + context.getPackageRoot() + "." + layer);
        code.appendLineEnd("import " + current.getFullModelClassName());
        code.appendLine("import java.util.List;");

        code.appendLine("/**\n" +
                " * @author feifei.li\n" +
                " */");
        code.appendLine("public interface " + serviceName + "{");

        code.appendLine("/**\n" +
                " * 添加\n" +
                " *\n" +
                " * @param " + StringUtil.acronymLowercase(current.getModelClassName()) + "\n" +
                " * @return\n" +
                " */");
        code.appendLineEnd("\tint add(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");
        code.appendLine("/**\n" +
                " * 删除\n" +
                " *\n" +
                " * @param " + modelMeta.getPrimaryKey() + "\n" +
                " * @return\n" +
                " */");
        code.appendLineEnd("\tint delete(" + modelMeta.getPrimaryKeyType() + " " + modelMeta.getPrimaryKey() + ")");
        code.appendLine("     /**\n" +
                "      * 修改\n" +
                "      *\n" +
                "      * @param " + StringUtil.acronymLowercase(current.getModelClassName()) + "\n" +
                "      * @return\n" +
                "      */");
        code.appendLineEnd("\tint update(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");

        code.appendLine("/**\n" +
                " * 筛选列表\n" +
                " *\n" +
                " * @param " + StringUtil.acronymLowercase(current.getModelClassName()) + "\n" +
                " * @return\n" +
                " */");
        code.appendLineEnd("\tList<" + current.getModelClassName() + "> list(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");

        code.appendLine("/**\n" +
                " * 根据主键查询\n" +
                " *\n" +
                " * @param " + current.getPrimaryKey() + "\n" +
                " * @return\n" +
                " */");
        String primaryKey = ColumnSplicing.convertColumnToField(current.getPrimaryKey());
        code.appendLineEnd("\t" + current.getModelClassName() + " get(" + TypeConverter.exchange(current.getPrimaryKeyType()) + " " + primaryKey + ")");


        code.appendLine("}");
        return code.toString();
    }
}
