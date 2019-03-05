package com.endava.training.spring.demo.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Cacheable(value = "something")
    public String getSomething(String key) {
        System.out.println("===getSomething with key=" + key);
        return key;
    }
}
