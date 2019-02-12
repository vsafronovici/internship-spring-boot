package com.endava.training.spring.demo.service;

import com.endava.training.spring.demo.entity.Person;

import java.util.List;

/**
 * Created by vsafronovici on 3/16/2017.
 */
public interface PersonService {

    List<Person> getAll();

    Person findById(int id);

    void save(Person p);

    void delete(int id);
}
