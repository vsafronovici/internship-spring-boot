package com.endava.training.spring.demo.circulardi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class C {

    @Autowired
    private C c;

    public C() {
        System.out.println("== constructor " + this.getClass().getSimpleName());
    }

}
