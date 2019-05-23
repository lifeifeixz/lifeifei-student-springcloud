package org.lifeifei.fedis.fedisspringbootstarter.service;

import org.lifeifei.fedis.fedisspringbootstarter.config.RedisConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class FedisProcesserImpl<K, V> implements FedisProcesser<K, V> {

    @Autowired
    private RedisConfig redisConfig;

    private Jedis jedis;

    public FedisProcesserImpl() {
        this.jedis = new Jedis(redisConfig.getHostname(), redisConfig.getDatabase());
    }

    @Override
    public V get(String h, K k) {
        return (V) jedis.get(h);
    }

    @Override
    public List<V> get(String h, V... v) {
        return null;
    }

    @Override
    public void set(String h, K k, V v) {

    }

    @Override
    public int del(String h, K... k) {
        return 0;
    }
}
