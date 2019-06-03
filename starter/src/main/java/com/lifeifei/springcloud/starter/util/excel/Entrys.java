package com.lifeifei.springcloud.starter.util.excel;


import java.util.ArrayList;
import java.util.List;

public class Entrys<T extends Entry> {
    private final List<Entry> entrys = new ArrayList<>(100);
    public void add(Entry entry) {
        entrys.add(entry);
    }

}
