package com.endava.training.spring.demo;

import com.endava.training.spring.demo.dao.PersonDao;
import com.endava.training.spring.demo.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
@DataJpaTest
public class PersonDaoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonDao personDao;

    @Test
    public void whenFindByName_thenReturnPerson() {
        Person alex = new Person("alex");
        entityManager.persistAndFlush(alex);

        Person found = personDao.findByName(alex.getName());
        assertThat(found.getName()).isEqualTo(alex.getName());
    }

    @Test
    public void whenInvalidName_thenReturnNull() {
        Person fromDb = personDao.findByName("doesNotExist");
        assertThat(fromDb).isNull();
    }

    @Test
    public void whenFindById_thenReturnPerson() {
        Person person = new Person("test");
        entityManager.persistAndFlush(person);

        Person fromDb = personDao.findById(person.getId()).orElse(null);
        assertThat(fromDb.getName()).isEqualTo(person.getName());
    }

    @Test
    public void whenInvalidId_thenReturnNull() {
        Person fromDb = personDao.findById(-11l).orElse(null);
        assertThat(fromDb).isNull();
    }

    @Test
    public void givenSetOfPersons_whenFindAll_thenReturnAllPersons() {
        Person alex = new Person("alex");
        Person ron = new Person("ron");
        Person bob = new Person("bob");

        entityManager.persist(alex);
        entityManager.persist(bob);
        entityManager.persist(ron);
        entityManager.flush();

        List<Person> allPersons = personDao.findAll();

        assertThat(allPersons).hasSize(3).extracting(Person::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());
    }

}
