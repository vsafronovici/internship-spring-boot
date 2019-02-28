package com.endava.training.spring.demo.inheritance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Child1 extends Parent {

    @Autowired
    @Qualifier("fieldB")
    Field fieldB;
}
