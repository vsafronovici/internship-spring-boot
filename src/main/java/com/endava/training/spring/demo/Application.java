package com.endava.training.spring.demo;

import com.endava.training.spring.demo.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.endava.training.spring.demo"})
@EnableCaching
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    MyService myService;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            System.out.println(myService.getSomething("1"));
            System.out.println(myService.getSomething("2"));
            System.out.println(myService.getSomething("1"));
            System.out.println(myService.getSomething("2"));
            System.out.println();
        };
    }


}
