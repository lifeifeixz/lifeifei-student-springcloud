package com.db.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @program: code-generation
 * @description: 启动类
 * @author: feifei.li
 * @create: 2019-08-28 16:52
 **/

@MapperScan("com.db.test.mapper")
@SpringBootApplication
public class CgApplication {
    public static void main(String[] args) {
        SpringApplication.run(CgApplication.class);
    }
}
