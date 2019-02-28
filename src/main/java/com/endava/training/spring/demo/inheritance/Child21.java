package com.endava.training.spring.demo.inheritance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Child21 extends Parent2 {

    private static final Logger LOG = LoggerFactory.getLogger(Child21.class);

    public Child21(@Autowired @Qualifier("fieldA") Field field) {
        super(field);
    }

    @PostConstruct
    public void init() {
        LOG.info("===post constructor {}", this);
    }

}
