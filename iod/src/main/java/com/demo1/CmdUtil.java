package com.demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author feifei.li
 */
public class CmdUtil {


    /**
     * 版权声明：本文为CSDN博主「df0128」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/df0128/article/details/82776689
     *
     * @param cmdCommand
     * @return
     */
    public static String excuteCmdCommand(String cmdCommand) {
        StringBuilder stringBuilder = new StringBuilder();
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmdCommand);
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream(), "GBK"));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        CmdUtil.excuteCmdCommand("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    }
}
