package com.endava.training.spring.demo;

import com.endava.training.spring.demo.profile.ProfileConfigSetup;
import com.endava.training.spring.demo.viaannot.TopField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages = {"com.endava.training.spring.demo"})
@PropertySource("classpath:main.properties")
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

    @Value("${say.hi}")
    private String sayhi;

    @Autowired
    private TopField topField;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            LOG.info("==== {}", sayhi);
            profileConfigSetup.setup();

            System.out.println("=== TopField=" + topField);


        };
    }

}
