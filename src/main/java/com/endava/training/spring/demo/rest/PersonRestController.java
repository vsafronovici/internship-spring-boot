package com.endava.training.spring.demo.rest;

import com.endava.training.spring.demo.entity.Person;
import com.endava.training.spring.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonRestController {

    @Autowired
    private PersonService personService;

    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person Person) {
        Person saved = personService.save(Person);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping("/persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

}
