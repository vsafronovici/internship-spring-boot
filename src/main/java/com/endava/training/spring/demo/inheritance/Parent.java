package com.endava.training.spring.demo.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class Parent {

    @Autowired
    @Qualifier("fieldA")
    Field field;

    public Field getField() {
        return field;
    }
}
