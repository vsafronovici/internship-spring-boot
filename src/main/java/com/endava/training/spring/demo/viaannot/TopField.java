package com.endava.training.spring.demo.viaannot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TopField {

    private static final Logger LOG = LoggerFactory.getLogger(TopField.class);


    @Autowired
    private Field1 field1;

    private final Field2 field2;
    private Field3 field3;


    private Field4 field4;

    @Value("#{field5.name}")
    private String field5Name;


    @Autowired
    public TopField(@Qualifier("field2") Field2 field2, Field3 field3) {
        this.field2 = field2;
        this.field3 = field3;
    }

    @PostConstruct
    public void init() {
        LOG.info("===post constructor {}", this);
    }


    public Field1 getField1() {
        return field1;
    }

    public Field2 getField2() {
        return field2;
    }

    public Field3 getField3() {
        return field3;
    }

    public void setField3(Field3 field3) {
        this.field3 = field3;
    }

    public Field4 getField4() {
        return field4;
    }

    @Autowired
    public void setField4(Field4 field4) {
        this.field4 = field4;
    }

    @Override
    public String toString() {
        return "TopField{" +
                "field1=" + field1 +
                ", field2=" + field2 +
                ", field3=" + field3 +
                ", field4=" + field4 +
                ", field5Name='" + field5Name + '\'' +
                '}';
    }
}
