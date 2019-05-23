package com.lifeifei.springcloud.starter.components.condit;

import java.util.function.Supplier;

/**
 * 作者：一灰灰blog
 * 来源：CSDN
 * 原文：https://blog.csdn.net/liuyueyi25/article/details/83244263
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 *
 * @param <T>
 */
public class RandDataComponent<T> {
    private Supplier<T> rand;

    public RandDataComponent(Supplier<T> rand) {
        this.rand = rand;
    }

    public T rand() {
        return rand.get();
    }
}
