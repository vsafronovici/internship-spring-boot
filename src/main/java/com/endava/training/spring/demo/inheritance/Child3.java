package com.endava.training.spring.demo.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Child3 extends Parent {

    private static final Logger LOG = LoggerFactory.getLogger(Child3.class);


    @Autowired
    @Qualifier("fieldC")
    Field field;

    @Autowired
    @Qualifier("fieldB")
    Field fieldB;

    @PostConstruct
    public void init() {
        LOG.info("===post constructor {}", this);
    }

    @Override
    public Field getField() {
        return field;
    }

}
