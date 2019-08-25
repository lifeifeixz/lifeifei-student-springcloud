package org.flys.cg.generators;

import org.flys.cg.*;
import org.flys.cg.meta.Context;
import org.flys.cg.meta.Current;
import org.flys.cg.meta.MetaTable;
import org.flys.cg.util.FileUtil;
import org.flys.cg.util.StringUtil;
import org.flys.cg.util.UtilClassSplicing;

import java.io.File;
import java.util.regex.Matcher;

/**
 * @author feifei.li
 */
public abstract class AbstractGenerator implements Generator {
    protected String layer;
    protected Current current = Current.current;

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

    protected String loadResource(String location) {
        String resource = FileUtil.readFile(resourceRoot + location);
        return resource;
    }

    @Override
    public void print(MetaTable table) {
        Product product = this.doGenerate(table);
        /*解析包*/
        String packagePath = context.getPackageRoot() + "." + layer;
        String path = packagePath.replaceAll("\\.", Matcher.quoteReplacement(File.separator));
        String outPath = context.getOutputPath() + File.separator + path + File.separator;
        String fileName = StringUtil.acronymUpperCase(UtilClassSplicing.convertColumnToField(product.getName()));
        FileUtil.writeFile(outPath, fileName, product.getContext());
    }

    public static void main(String[] args) {
        System.out.println(File.separator);
    }
}
