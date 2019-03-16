package com.endava.training.spring.demo;

import com.endava.training.spring.demo.dao.PersonDao;
import com.endava.training.spring.demo.entity.Person;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplicationConfiguration.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
public class PersonRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PersonDao personDao;

    @After
    public void resetDb() {
        personDao.deleteAll();
    }

    @Test
    public void whenValidInput_thenCreatePerson() throws Exception {
        Person bob = new Person("bob");
        mvc.perform(post("/api/persons").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(bob)));

        List<Person> found = personDao.findAll();
        assertThat(found).extracting(Person::getName).containsOnly("bob");
    }

    @Test
    public void givenPersons_whenGetPersons_thenStatus200() throws Exception {
        createTestPerson("bob");
        createTestPerson("alex");

        // @formatter:off
        mvc.perform(get("/api/persons").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(greaterThanOrEqualTo(2))))
                .andExpect(jsonPath("$[0].name", is("bob")))
                .andExpect(jsonPath("$[1].name", is("alex")));
        // @formatter:on
    }

    private void createTestPerson(String name) {
        Person emp = new Person(name);
        personDao.saveAndFlush(emp);
    }

}
