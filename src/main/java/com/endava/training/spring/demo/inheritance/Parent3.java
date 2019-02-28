package com.endava.training.spring.demo.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class Parent3 {

    Field field;

    public Parent3(@Autowired @Qualifier("fieldA") Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }
}
