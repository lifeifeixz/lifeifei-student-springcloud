package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.meta.ModelMeta;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.TinyIde;
import org.flys.cg.util.UtilClassSplicing;

/**
 * 手写service
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
        String serviceName = StringUtil.acronymUpperCase(UtilClassSplicing.convertColumnToField(metaTable.getTableName()));
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
        //        code.appendLineEnd("import " + current.getFullMapperClassName());
        code.appendLine("public interface " + serviceName + "{");
//        code.appendLineEnd("\t" + current.getMapperClassName() + " " + StringUtil.acronymLowercase(current.getMapperClassName()));
        code.appendLineEnd("\tint add(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");
        code.appendLineEnd("\tint delete(" + modelMeta.getPrimaryKeyType() + " " + modelMeta.getPrimaryKey() + ")");
        code.appendLine("     /**\n" +
                "     * 修改\n" +
                "     *\n" +
                "     * @param erpEmp\n" +
                "     * @return\n" +
                "     */");
        code.appendLineEnd("\tint update(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");
        code.appendLineEnd("\tList<" + current.getModelClassName() + "> list(" + current.getModelClassName() + " " + StringUtil.acronymLowercase(current.getModelClassName()) + ")");

        code.appendLine("}");
        return code.toString();
    }
}
