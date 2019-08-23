package com.demo1;

/**
 * @author feifei.li
 */
public class Chrome implements Browser {
    @Override
    public Object jumpTo(String link) {
        CmdUtil.excuteCmdCommand("chrome.exe " + link);
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void open() {
        CmdUtil.excuteCmdCommand("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
    }
}
