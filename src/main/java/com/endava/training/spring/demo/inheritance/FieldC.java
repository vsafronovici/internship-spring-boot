package com.endava.training.spring.demo.inheritance;

import org.springframework.stereotype.Component;

@Component
public class FieldC implements Field {
    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
