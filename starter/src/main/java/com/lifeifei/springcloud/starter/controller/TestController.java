package com.lifeifei.springcloud.starter.controller;

import com.lifeifei.springcloud.starter.components.Compute;
import com.lifeifei.springcloud.starter.components.DateUtil;
import com.lifeifei.springcloud.starter.components.Logger;
import com.lifeifei.springcloud.starter.components.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private StringUtils stringUtils;

    @Autowired
    private Compute compute;

    @Autowired
    private Logger logger;

    @Autowired
    private DateUtil dateUtil;

    @GetMapping("/")
    @ResponseBody
    public String index(String name) {
        return name;
    }
}
