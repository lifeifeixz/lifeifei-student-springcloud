package org.flys.cg.meta;

/**
 * @author feifei.li
 */
public class Context {
    private static Context context;
    private String packageRoot;
    private String outputPath;

    private Context() {
    }

    public synchronized static Context getInstance() {
        if (context == null) {
            context = new Context();
        }
        return context;
    }

    public String getPackageRoot() {
        return packageRoot;
    }

    public void setPackageRoot(String packageRoot) {
        this.packageRoot = packageRoot;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
