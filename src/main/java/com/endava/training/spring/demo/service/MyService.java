package com.endava.training.spring.demo.service;

import com.endava.training.spring.demo.annot.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class MyService {

    public String get(Integer id) {
        return String.valueOf(id);
    }

    @MyAnnotation
    public void save(Integer id) {
        return;
    }


}
