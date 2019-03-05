package com.endava.training.spring.demo;

import com.endava.training.spring.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.endava.training.spring.demo"})
@ImportResource("classpath:spring-config.xml")

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private Person person1;

    @Autowired
    private Person person2;

    @Autowired
    private Person person3;

    @Autowired
    private Person person4;



    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            System.out.println("==== p1:" + person1);
            System.out.println("==== p2:" + person2);
            System.out.println("==== p3:" + person3);
            System.out.println("==== p4:" + person4);
        };
    }


}
