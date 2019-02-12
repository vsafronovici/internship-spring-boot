package com.endava.training.spring.test;

import com.endava.training.spring.demo.entity.Person;
import com.endava.training.spring.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by vsafronovici on 3/21/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.endava.training.spring.demo.Application.class)
@ActiveProfiles("test")
public class SpringUnitTest {

    @Autowired
    private PersonService personService;

    @Autowired
    private Person p1;

    @Autowired
    private Person p2;


    @Test
    public void test1() {

        personService.save(p1);
        personService.save(p2);
        List<Person> list =  personService.getAll();

        assertEquals(list.size(), 2);

    }

}
