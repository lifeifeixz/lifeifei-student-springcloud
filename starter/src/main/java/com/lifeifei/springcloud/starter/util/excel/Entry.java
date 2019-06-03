package com.lifeifei.springcloud.starter.util.excel;

public class Entry<K,V> {
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
