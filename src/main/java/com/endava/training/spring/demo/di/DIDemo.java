package com.endava.training.spring.demo.di;

import com.endava.training.spring.demo.entity.Person;
import com.endava.training.spring.demo.inheritance.A;
import com.endava.training.spring.demo.inheritance.AS;
import com.endava.training.spring.demo.service.PersonService;
import com.endava.training.spring.demo.viaannot.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * Created by vsafronovici on 3/15/2017.
 */
@SpringBootApplication
@ImportResource("classpath:spring-config-di.xml")
@ComponentScan(basePackages = {"com.endava.training.spring.demo.di"})

public class DIDemo {

    private static final Logger LOG = LoggerFactory.getLogger(DIDemo.class);

    private static final String PROFILE = "DIDemo";



    public static void main(String[] args) {
        LOG.info("========= Entering main() =============");

        //SpringApplication.run(Application.class);

        SpringApplication app = new SpringApplication(DIDemo.class);
        app.setAdditionalProfiles(PROFILE);
        app.run(args);


    }


    @Autowired
    private ApplicationContext applicationContext;



    @Bean
    @Profile(PROFILE)
    public CommandLineRunner demo() {
        return (args) -> {
            LOG.info("========= Entering demo() =============");

        };
    }


}
