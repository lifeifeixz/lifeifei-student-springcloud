package org.flys.cg.generators;

import org.flys.cg.Generator;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.ColumnSplicing;
import org.flys.cg.util.TinyIde;

/**
 * 生成controller
 *
 * @author feifei.li
 */
public class HandwritingControllerGenerator extends AbstractGenerator implements Generator {
    public HandwritingControllerGenerator(String packageName) {
        super(packageName);
    }

    @Override
    public Product doGenerate(MetaTable metaTable) {
        super.layer = "controller";
        String requestMapping = ColumnSplicing.convertColumnToField(metaTable.getTableName());
        String className = StringUtil.acronymUpperCase(requestMapping) + StringUtil.acronymUpperCase(layer);
        String packageName = context.getPackageRoot() + SPOT + layer;
        String fullClassName = packageName + SPOT + className;
        join(className, fullClassName);
        current.setRequestMapping(className);
        /*开始编*/
        TinyIde code = new TinyIde();
        code.appendLineEnd("package " + packageName);
        code.appendLineEnd("import " + current.getFullModelClassName());
        code.appendLineEnd("import " + current.getFullServiceClassName());
        code.appendLineEnd("import " + current.getFullVoClassName());
        code.appendLineEnd("import org.springframework.web.bind.annotation.RestController");
        code.appendLineEnd("import org.springframework.web.bind.annotation.RequestMapping");
        code.appendLineEnd("import org.springframework.beans.factory.annotation.Autowired");
        code.appendLineEnd("import org.springframework.beans.BeanUtils");
        code.appendLineEnd("import org.springframework.web.bind.annotation.PostMapping");
        code.appendLineEnd("import org.springframework.web.bind.annotation.GetMapping");
        code.appendLineEnd("import org.springframework.web.bind.annotation.RequestBody");
        /*code.appendLineEnd("import org.springframework.web.bind.annotation.CrossOrigin");*/
        code.appendLineEnd("import org.springframework.validation.annotation.Validated");
        code.appendLineEnd("import " + current.getFullSaveVoClassName());
        code.appendLineEnd("import java.util.List");
        code.appendLine("");

        code.appendLine("/**\n" +
                " * @author feifei.li\n" +
                " */");
        /*code.appendLine("@CrossOrigin");*/
        code.appendLine("@RestController");
        code.appendLine("@RequestMapping(value = \"" + StringUtil.acronymLowercase(current.getModelClassName()) + "\")");
        code.appendLine("public class " + className + "{");

        String serviceVar = StringUtil.acronymLowercase(current.getServiceClassName());

        code.appendLine("@Autowired");
        code.appendLineEnd(current.getServiceClassName() + " " + serviceVar);
        String voVar = StringUtil.acronymLowercase(current.getVoClassName());
        /*方法*/
        code.appendLine("@PostMapping(\"list\")");
        code.appendLine("\tpublic List<" + current.getModelClassName() + "> list(@RequestBody " + current.getVoClassName() + " " + voVar + "){" +
                current.getModelClassName() + " bean = new " + current.getModelClassName() + "();\n" +
                "        BeanUtils.copyProperties(" + voVar + ", bean);\n" +
                "\t\treturn " + serviceVar + ".list(bean);" +
                "\t}");

        /*code.appendLine("@CrossOrigin");*/
        code.appendLine("@PostMapping(\"save\")");
        code.appendLine("public int save(@Validated @RequestBody " + current.getSaveVoClassName() + " saveVo){\n" +
                current.getModelClassName() + " bean = new " + current.getModelClassName() + "();\n" +
                "        BeanUtils.copyProperties(saveVo, bean);" +
                "return " + serviceVar + ".add(bean);" +
                "}");

        code.appendLine("@PostMapping(\"update\")");
        code.appendLine("public int update(@Validated @RequestBody " + current.getVoClassName() + " vo){" +
                current.getModelClassName() + " bean = new " + current.getModelClassName() + "();\n" +
                "        BeanUtils.copyProperties(vo, bean);" +
                "return " + serviceVar + ".update(bean);" +
                "}");

        code.appendLine("@GetMapping(\"delete\")");
        code.appendLine("public int delete(" + current.getPrimaryKeyType() + " " + current.getPrimaryKey() + "){" +
                "return " + serviceVar + ".delete(" + current.getPrimaryKey() + ");" +
                "}");

        code.appendLine("@GetMapping(\"get\")");
        code.appendLine("public " + current.getModelClassName() + " get(" + current.getPrimaryKeyType() + " " + current.getPrimaryKey() + "){" +
                "return " + serviceVar + ".get(" + current.getPrimaryKey() + ");" +
                "}");

        code.appendLine("}");


        return new Product(className + ".java", code.toString());
    }
}
