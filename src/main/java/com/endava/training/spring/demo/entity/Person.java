package com.endava.training.spring.demo.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

/**
 * Created by vsafronovici on 3/15/2017.
 */
public class Person {

    private static final Logger LOG = LoggerFactory.getLogger(Person.class);


    private static int _id;

    private final int id;

    private String name;
    private String lastname;
    private Date birth;

    private Address address;

    private List<Person> children;

    public Person() {
        this.id = ++_id;
    }

    public Person(String name, Address address) {
        this();
        this.name = name;
        this.address = address;
    }

    public void init() {
        LOG.info("==========================" + this.toString());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setChildren(List<Person> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                ", address=" + address +
                ", children=" + children +
                '}';
    }
}
