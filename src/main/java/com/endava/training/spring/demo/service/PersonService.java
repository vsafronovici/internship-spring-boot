package com.endava.training.spring.demo.service;

import com.endava.training.spring.demo.entity.Person;

import java.util.List;

public interface PersonService {

    Person getPersonById(Long id);

    Person getPersonByName(String name);

    List<Person> getAllPersons();

    boolean exists(String name);

    Person save(Person person);
}
