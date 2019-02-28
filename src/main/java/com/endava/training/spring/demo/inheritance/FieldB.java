package com.endava.training.spring.demo.inheritance;

import org.springframework.stereotype.Component;

@Component
public class FieldB implements Field {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
