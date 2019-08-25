package org.flys.cg.generators;

import javassist.*;
import org.flys.cg.meta.Column;

import java.io.IOException;
import java.util.List;

public class GenerateExecutor {

    public CtClass execute(String packageName, String className, List<Column> columns,
                           List<String> methods) {
        ClassPool pool = ClassPool.getDefault();
        CtClass ct = pool.makeClass(packageName + "." + className);
        for (Column column : columns) {
            try {
                /*属性*/
                CtField field = CtField.make(column.getName(), ct);
                ct.addField(field);

            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
        /*方法*/
        for (String method : methods) {
            /*方法*/
            CtMethod m1 = null;
            try {
                m1 = CtMethod.make(method, ct);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
            try {
                ct.addMethod(m1);
            } catch (CannotCompileException e) {
                e.printStackTrace();
            }
        }
        try {
            ct.writeFile("D:\\JavaFile\\" + className);
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ct;
    }
}
