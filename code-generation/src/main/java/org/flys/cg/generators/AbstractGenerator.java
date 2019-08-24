package org.flys.cg.generators;

import org.flys.cg.Context;
import org.flys.cg.Generator;
import org.flys.cg.MetaTable;
import org.flys.cg.SupportPrintGenerator;
import org.flys.cg.util.FileUtil;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.UtilClassSplicing;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;

/**
 * @author feifei.li
 */
public abstract class AbstractGenerator implements Generator, SupportPrintGenerator {
    protected String layer;

    static final String PACKAGE = "&package&";
    static final String CLASS_NAME = "&class-name&";
    static final String MODEL_CLASS_NAME = "&model-class-name&";
    static final String PRIMARY_KEY = "&primary-key&";
    static final String PRIMARY_KEY_TYPE = "&primary-key-type&";
    static final String IMPORT_ITEM = "&import-item&";

    protected String resourceRoot = "G:\\workspaces\\springcloud\\code-generation\\src\\main\\java\\org\\flys\\cg\\template\\";

    protected String packageName;

    protected Context context = Context.getInstance();

    public AbstractGenerator(String packageName) {
        this.packageName = packageName;
    }

    @Override
    public void print(MetaTable table) {
        try {
            Product product = this.doGenerate(table);
            /*解析包*/
            String packagePath = context.getPackageRoot() + "." + layer;
            String path = packagePath.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
            String outPath = context.getOutputPath() + File.separator + path + File.separator;
            String fileName = StringUtil.acronymUpperCase(UtilClassSplicing.convertColumnToField(product.getName()));
            FileUtil.writeFile(outPath, fileName, product.getContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        System.out.println(File.separator);
    }
}
