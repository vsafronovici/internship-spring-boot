package com.endava.training.spring.demo;

import com.endava.training.spring.demo.dao.PersonDao;
import com.endava.training.spring.demo.entity.Person;
import com.endava.training.spring.demo.service.PersonService;
import com.endava.training.spring.demo.service.PersonServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@Configuration
class PersonServiceImplTestContextConfiguration {
    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }
}


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestApplicationConfiguration.class, PersonServiceImplTestContextConfiguration.class})
public class PersonServiceTest {

    /*@TestConfiguration
    static class PersonServiceImplTestContextConfiguration {
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }*/


    @MockBean
    private PersonDao personDao;

    @Autowired
    private PersonService personService;


    @Before
    public void setUp() {
        Person john = new Person("john");
        john.setId(11L);

        Person bob = new Person("bob");
        Person alex = new Person("alex");

        List<Person> allPersons = Arrays.asList(john, bob, alex);

        Mockito.when(personDao.findByName(john.getName())).thenReturn(john);
        Mockito.when(personDao.findByName(alex.getName())).thenReturn(alex);
        Mockito.when(personDao.findByName("wrong_name")).thenReturn(null);
        Mockito.when(personDao.findById(john.getId())).thenReturn(Optional.of(john));
        Mockito.when(personDao.findAll()).thenReturn(allPersons);
        Mockito.when(personDao.findById(-99L)).thenReturn(Optional.empty());
    }

    @Test
    public void whenValidName_thenPersonShouldBeFound() {
        String name = "alex";
        Person found = personService.getPersonByName(name);

        assertThat(found.getName()).isEqualTo(name);
    }


    @Test
    public void whenInValidName_thenPersonShouldNotBeFound() {
        Person fromDb = personService.getPersonByName("wrong_name");
        assertThat(fromDb).isNull();

        verifyFindByNameIsCalledOnce("wrong_name");
    }

    @Test
    public void whenValidName_thenPersonShouldExist() {
        boolean doesPersonExist = personService.exists("john");
        assertThat(doesPersonExist).isEqualTo(true);

        verifyFindByNameIsCalledOnce("john");
    }

    @Test
    public void whenNonExistingName_thenPersonShouldNotExist() {
        boolean doesPersonExist = personService.exists("some_name");
        assertThat(doesPersonExist).isEqualTo(false);

        verifyFindByNameIsCalledOnce("some_name");
    }

    @Test
    public void whenValidId_thenPersonShouldBeFound() {
        Person fromDb = personService.getPersonById(11L);
        assertThat(fromDb.getName()).isEqualTo("john");

        verifyFindByIdIsCalledOnce();
    }

    @Test
    public void whenInValidId_thenPersonShouldNotBeFound() {
        Person fromDb = personService.getPersonById(-99L);
        verifyFindByIdIsCalledOnce();
        assertThat(fromDb).isNull();
    }

    @Test
    public void given3Persons_whengetAll_thenReturn3Records() {
        Person alex = new Person("alex");
        Person john = new Person("john");
        Person bob = new Person("bob");

        List<Person> allPersons = personService.getAllPersons();
        verifyFindAllPersonsIsCalledOnce();
        assertThat(allPersons).hasSize(3).extracting(Person::getName).contains(alex.getName(), john.getName(), bob.getName());
    }

    private void verifyFindByNameIsCalledOnce(String name) {
        Mockito.verify(personDao, VerificationModeFactory.times(1)).findByName(name);
        Mockito.reset(personDao);
    }

    private void verifyFindByIdIsCalledOnce() {
        Mockito.verify(personDao, VerificationModeFactory.times(1)).findById(Mockito.anyLong());
        Mockito.reset(personDao);
    }

    private void verifyFindAllPersonsIsCalledOnce() {
        Mockito.verify(personDao, VerificationModeFactory.times(1)).findAll();
        Mockito.reset(personDao);
    }
}
