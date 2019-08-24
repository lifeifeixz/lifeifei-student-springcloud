package org.flys.cg.util;

import java.io.*;

public class FileUtil {

    /**
     * 版权声明：本文为CSDN博主「nickwong_」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/nickwong_/article/details/51502969
     */
    public static String readFile(String pathname) {
        // 绝对路径或相对路径都可以，写入文件时演示相对路径,读取以上路径的input.txt文件
        //防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw;
        //不关闭文件会导致资源的泄露，读写文件都同理
        //Java7的try-with-resources可以优雅关闭文件，异常时自动关闭文件；详细解读https://stackoverflow.com/a/12665271
        StringBuffer text = new StringBuffer();
        try (FileReader reader = new FileReader(pathname);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line = "";
            //网友推荐更加简洁的写法
            while ((line = br.readLine()) != null) {
                // 一次读入一行数据
                text.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    /**
     * 版权声明：本文为CSDN博主「nickwong_」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/nickwong_/article/details/51502969
     *
     * @param path
     * @param text
     */
    public static void writeFile(String path, String fileName, String text) {
        try {
            File dir = new File(path);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            try (FileWriter writer = new FileWriter(path + File.separator + fileName);
                 BufferedWriter out = new BufferedWriter(writer)
            ) {
                out.write(text); // \r\n即为换行
                out.flush(); // 把缓存区内容压入文件
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
