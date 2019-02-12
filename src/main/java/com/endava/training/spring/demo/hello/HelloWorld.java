package com.endava.training.spring.demo.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.endava.training.spring.demo.hello"})
public class HelloWorld {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        SpringApplication.run(HelloWorld.class);
    }

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            LOG.info("==== Hello world !!!");
        };
    }


}
