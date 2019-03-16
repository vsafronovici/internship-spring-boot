package com.endava.training.spring.demo.service;

import com.endava.training.spring.demo.dao.PersonDao;
import com.endava.training.spring.demo.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDao personDao;

    @Override
    public Person getPersonById(Long id) {
        return personDao.findById(id).orElse(null);
    }

    @Override
    public Person getPersonByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDao.findAll();
    }

    @Override
    public boolean exists(String name) {
        return getPersonByName(name) != null;
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }
}
