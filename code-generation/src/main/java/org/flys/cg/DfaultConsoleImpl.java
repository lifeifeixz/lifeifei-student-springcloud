package org.flys.cg;

import javassist.CannotCompileException;
import org.flys.cg.generators.ModelGenerator;

import java.io.IOException;
import java.util.List;

/**
 * @author feifei.li
 */
public class DfaultConsoleImpl implements Console {
    protected String packageRoot;
    protected String outPath;
    DataBaseConnection dataBaseConnection;

    @Override
    public void setPackage(String packageName) {
        this.packageRoot = packageName;
    }

    @Override
    public void setOutPath(String path) {
        this.outPath = path;
    }

    @Override
    public void invoke() throws CannotCompileException, IOException {

    }

   /* @Override*/
  /*  public void invoke() throws CannotCompileException, IOException {
        List<String> tables = dataBaseConnection.getTables();
        for (String tableName : tables) {
            doInvoke(tableName);
        }
    }*/

   /* protected String doInvoke(String tableName) throws CannotCompileException, IOException {
        MetaTable table = dataBaseConnection.getTable(tableName);
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
