package com.lifeifei.springcloud.starter.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {
    private String name;

    public String showName() {
        return name;
    }
}
