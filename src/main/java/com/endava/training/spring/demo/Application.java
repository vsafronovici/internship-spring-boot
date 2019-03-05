package com.endava.training.spring.demo;

import com.endava.training.spring.demo.inheritance.A;
import com.endava.training.spring.demo.inheritance.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring-config.xml")

public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    A ia;

    @Autowired
    B b;

    @Autowired
    B b2;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            System.out.println("==== ia:" + ia);
            System.out.println("==== b:" + b);
            System.out.println("==== b2:" + b2);
        };
    }


}
