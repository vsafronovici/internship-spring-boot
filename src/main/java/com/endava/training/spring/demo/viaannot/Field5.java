package com.endava.training.spring.demo.viaannot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Field5 {

    @Value("${field5.name}")
    private String name;

    public String getName() {
        return this.name;
    }
}
