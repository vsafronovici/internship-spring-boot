package com.endava.training.spring.demo.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FieldA implements Field {

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }
}
