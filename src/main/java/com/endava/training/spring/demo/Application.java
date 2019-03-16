package com.endava.training.spring.demo;

import com.endava.training.spring.demo.dao.PersonDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private ApplicationContext applicationContext;


    /*@Bean
    public CommandLineRunner hello() {
        return (args) -> {
            LOG.info("======================================= Hello world !!! ==================");
            System.out.println(applicationContext.getBeanDefinitionNames());
        };
    }*/


}
