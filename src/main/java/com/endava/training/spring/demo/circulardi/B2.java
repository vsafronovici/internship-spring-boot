package com.endava.training.spring.demo.circulardi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class B2 {

    private A2 a2;

    public B2(@Autowired A2 a2) {
        System.out.println("== constructor " + this.getClass().getSimpleName());
        this.a2 = a2;
    }
}
