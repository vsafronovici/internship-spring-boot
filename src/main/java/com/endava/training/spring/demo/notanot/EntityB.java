package com.endava.training.spring.demo.notanot;

import com.endava.training.spring.demo.viaannot.Field1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class EntityB {

    @Value("${field5.name}")
    private String name;

    @Value("#{field5.name}")
    private String field5Name;

    @Autowired
    private Field1 field1;

    public String getName() {
        return this.name;
    }

    public String getField5Name() {
        return field5Name;
    }

    public Field1 getField1() {
        return field1;
    }
}
