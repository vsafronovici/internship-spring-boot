package com.endava.training.spring.demo.viaannot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by vsafronovici on 3/20/2017.
 */
@Component
public class Parent {

    @Autowired
    private Child1 child1;

    private Child2 child2;
    private Child3 child3;


    private Child4 child4;


    @Autowired
    public Parent(@Qualifier("child2") Child2 child2, Child3 child3) {
        this.child2 = child2;
        this.child3 = child3;
    }

    @PostConstruct
    public void init() {
        System.out.println("post constructor");
    }


    public Child1 getChild1() {
        return child1;
    }

    public void setChild1(Child1 child1) {
        this.child1 = child1;
    }

    public Child2 getChild2() {
        return child2;
    }

    public void setChild2(Child2 child2) {
        this.child2 = child2;
    }

    public Child3 getChild3() {
        return child3;
    }

    public void setChild3(Child3 child3) {
        this.child3 = child3;
    }

    public Child4 getChild4() {
        return child4;
    }

    @Autowired
    public void setChild4(Child4 child4) {
        this.child4 = child4;
    }


}
