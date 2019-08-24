package org.flys.cg;

import javassist.CannotCompileException;
import org.flys.cg.generators.BasedTemplateMapperGenerator;
import org.flys.cg.generators.BasedTemplateModelGenerator;
import org.flys.cg.resource.MySqlMeterial;
import org.flys.cg.resource.RawMaterial;

import java.io.IOException;
import java.util.List;

/**
 * @author feifei.li
 */
public class DefaultConsoleImpl implements Console {
    protected String packageRoot;
    protected String outPath;
    RawMaterial rawMaterial = new MySqlMeterial();

    @Override
    public void setPackage(String packageName) {
        this.packageRoot = packageName;
    }

    @Override
    public void setOutPath(String path) {
        this.outPath = path;
    }

    @Override
    public void invoke() {
        List<String> tables = rawMaterial.getTables();
        for (String table : tables) {
            MetaTable metaTable = rawMaterial.getTable(table);
            BasedTemplateModelGenerator modelGenerator = new BasedTemplateModelGenerator(null);
            modelGenerator.print(metaTable);
            BasedTemplateMapperGenerator mapperGenerator = new BasedTemplateMapperGenerator(null);
            mapperGenerator.print(metaTable);
        }

    }

    public static void main(String[] args) {
        Context context = Context.getInstance();
        context.setPackageRoot("com.db.test");
        context.setOutputPath("G:\\workspaces\\springcloud\\code-generation\\src\\main\\java");
        Console console = new DefaultConsoleImpl();
        try {
            console.invoke();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* @Override*/
  /*  public void invoke() throws CannotCompileException, IOException {
        List<String> tables = rawMaterial.getTables();
        for (String tableName : tables) {
            doInvoke(tableName);
        }
    }*/

   /* protected String doInvoke(String tableName) throws CannotCompileException, IOException {
        MetaTable table = rawMaterial.getTable(tableName);
        String mapper = invokeMapper(table);
        return null;
    }*/

    /*private String invokeMapper(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = new ModelGenerator(packageRoot);
        return generator.doGenerate(metaTable);
    }

    private String invokeMapperXml(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = null;
        return generator.doGenerate(metaTable);
    }

    private String invokeService(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = null;
        return generator.doGenerate(metaTable);
    }

    private String invokeServiceImpl(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = null;
        return generator.doGenerate(metaTable);
    }

    private String invokeController(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = null;
        return generator.doGenerate(metaTable);
    }

    private String invokeHtml(MetaTable metaTable) throws CannotCompileException, IOException {
        Generator generator = null;
        return generator.doGenerate(metaTable);
    }*/
}
