package com.lifeifei.springcloud.starter.controller;

import com.lifeifei.springcloud.starter.annotation.MethodBefore;
import com.lifeifei.springcloud.starter.components.condit.RandDataComponent;
import com.lifeifei.springcloud.starter.components.demo.Compute;
import com.lifeifei.springcloud.starter.components.demo.DateUtil;
import com.lifeifei.springcloud.starter.components.demo.Logger;
import com.lifeifei.springcloud.starter.components.demo.StringUtils;
import com.lifeifei.springcloud.starter.exptions.BizException;
import com.lifeifei.springcloud.starter.mode.User;
import com.lifeifei.springcloud.starter.mode.enums.ResultEnum;
import com.lifeifei.springcloud.starter.service.TestService;
import com.lifeifei.springcloud.starter.util.excel.ExcelUtil;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
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

    @Autowired
    private TestService testService;

    @Autowired
    private RandDataComponent randDataComponent;

    @GetMapping("/")
    @ResponseBody
    public String index(String name) {
        return name;
    }

    @PostMapping("/param/object")
    @ResponseBody
    public User paramBody(@Validated @RequestBody User user) {
        return user;
    }

    @GetMapping("/rand")
    @ResponseBody
    public Object rand() {
        return randDataComponent.rand();
    }

    @GetMapping("/system/error")
    @ResponseBody
    public Object error() {
        String str = null;
        return str.substring(0, 10);
    }

    @GetMapping("/validator")
    @ResponseBody
    public Object validator(@RequestParam(required = true) Integer age) {
        return age;
    }

    @PostMapping("/import")
    @ResponseBody
    public List invokeImport(MultipartFile file) throws IOException {
        return ExcelUtil.invokeImport(file.getInputStream(), User.class);
    }


    @GetMapping("/object")
    @ResponseBody
    public Map<String, Object> object(String name, String addr) {
        Map<String, Object> map = new HashMap<>();
        map.put(name, name);
        if (addr.equals("error")) {
            throw new BizException(ResultEnum.ADDRESS_ERROR, map);
        }
        return map;
    }

    @Autowired
    ListableBeanFactory listableBeanFactory;

    @GetMapping(value = "factory")
    public Object factory() {
        System.out.println(listableBeanFactory);
        return listableBeanFactory;
    }
}
