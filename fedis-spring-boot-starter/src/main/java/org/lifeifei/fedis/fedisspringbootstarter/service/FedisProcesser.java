package org.lifeifei.fedis.fedisspringbootstarter.service;

import java.util.List;

public interface FedisProcesser<K, V> {
    V get(String h, K k);

    List<V> get(String h, V... v);

    void set(String h, K k, V v);

    int del(String h, K... k);
}
