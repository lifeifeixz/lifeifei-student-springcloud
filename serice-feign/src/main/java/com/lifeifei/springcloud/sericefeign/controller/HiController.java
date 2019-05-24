package com.lifeifei.springcloud.sericefeign.controller;

import com.lifeifei.springcloud.sericefeign.feigns.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 作者：方志朋
 * 来源：CSDN
 * 原文：https://blog.csdn.net/forezp/article/details/69808079
 * 版权声明：本文为博主原创文章，转载请附上博文链接！
 * @author feifei.li
 */
@RestController
public class HiController {

    @Autowired
    public SchedualServiceHi schedualServiceHi;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }
}

