package com.endava.training.spring.demo.dao;

import com.endava.training.spring.demo.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {
    Person findByName(String name);
    List<Person> findAll();
}
