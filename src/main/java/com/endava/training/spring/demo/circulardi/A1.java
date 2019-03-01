package com.endava.training.spring.demo.circulardi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class A1 {

    @Autowired
    private B b;

    @Autowired
    private B b2;

    public A1() {
        System.out.println("== constructor " + this.getClass().getSimpleName());
    }

}
