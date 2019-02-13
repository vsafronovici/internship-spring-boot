package com.endava.training.spring.demo;

import com.endava.training.spring.demo.profile.ProfileConfigSetup;
import com.endava.training.spring.demo.profile.Profiles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.endava.training.spring.demo"})
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Application.class);
        /*
        * uncomment that to use it programatically
        * */
        // app.setAdditionalProfiles(Profiles.PRODUCTION);
        app.run(args);

    }

    @Autowired
    private ProfileConfigSetup profileConfigSetup;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            LOG.info("==== Hello world !!!");
            profileConfigSetup.setup();
        };
    }

}
