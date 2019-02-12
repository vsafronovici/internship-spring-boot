package com.endava.training.spring.demo.service;

import com.endava.training.spring.demo.annot.MyAnnotation;
import com.endava.training.spring.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vsafronovici on 3/16/2017.
 */
public class PersonServiceImpl implements PersonService {

    private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    private List<Person> persons = new ArrayList<>();


    @Cacheable(value = "persons")
    @Override
    public List<Person> getAll() {
        LOG.info("=============== entering getAll");
        return persons;
    }

    @Override
    public Person findById(int id) {
        return null;
    }

    @Override
    @MyAnnotation
    public void save(Person p) {
        persons.add(p);
    }

    @Override
    public void delete(int id) {

    }
}
