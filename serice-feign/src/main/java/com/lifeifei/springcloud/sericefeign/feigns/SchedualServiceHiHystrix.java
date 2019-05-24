package com.lifeifei.springcloud.sericefeign.feigns;

import org.springframework.stereotype.Component;

/**
 * @author feifei.li
 */
@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return name + "你好。feign没有获取到正确的数据";
    }
}
