package com.endava.training.spring.demo.circulardi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class A2 {

    private B2 b2;

    public A2(@Autowired B2 b2) {
        System.out.println("== constructor " + this.getClass().getSimpleName());
        this.b2 = b2;
    }

}
