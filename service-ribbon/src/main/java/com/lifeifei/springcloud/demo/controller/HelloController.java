package com.lifeifei.springcloud.demo.controller;

import com.lifeifei.springcloud.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    HelloService helloService;


    @RequestMapping(value = "hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService(name)+"\t --消息来自ribbon";
    }
}
