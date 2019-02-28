package com.endava.training.spring.demo.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Child41 extends Parent4 {

    private static final Logger LOG = LoggerFactory.getLogger(Child41.class);

    public Child41(@Autowired @Qualifier("fieldC") Field field) {
        super(field);
    }

    @PostConstruct
    public void init() {
        LOG.info("===post constructor {}", this);
    }

}
