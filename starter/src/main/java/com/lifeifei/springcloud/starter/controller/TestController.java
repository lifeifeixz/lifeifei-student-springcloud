package com.lifeifei.springcloud.starter.controller;

import com.lifeifei.springcloud.starter.components.Compute;
import com.lifeifei.springcloud.starter.components.DateUtil;
import com.lifeifei.springcloud.starter.components.Logger;
import com.lifeifei.springcloud.starter.components.StringUtils;
import com.lifeifei.springcloud.starter.exptions.BizException;
import com.lifeifei.springcloud.starter.mode.enums.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/object")
    @ResponseBody
    public Map<String, Object> object(String name,String addr) {
        Map<String, Object> map = new HashMap<>();
        map.put(name, name);
        if(addr.equals("error")){
            throw new BizException(ResultEnum.ADDRESS_ERROR);
        }
        return map;
    }
}
