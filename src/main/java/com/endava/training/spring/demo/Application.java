package com.endava.training.spring.demo;

import com.endava.training.spring.demo.inheritance.*;
import com.endava.training.spring.demo.profile.ProfileConfigSetup;
import com.endava.training.spring.demo.viaannot.TopField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    /*
    * ======= Inheritance
    **/
    @Autowired
    private Child1 child1;

    @Autowired
    private Child2 child2;

    @Autowired
    private Child3 child3;

    @Autowired
    private Child21 child21;

    @Autowired
    private Child22 child22;

    @Autowired
    private Child23 child23;

    @Autowired
    private Child31 child31;

    @Autowired
    private Child41 child41;

    @Bean
    public CommandLineRunner hello() {
        return (args) -> {
            System.out.println("=== child1 " + child1.getField().getName());
            System.out.println("=== child2 " + child2.getField().getName());
            System.out.println("=== child3 " + child3.getField().getName());

            System.out.println("=== child21 " + child21.getField().getName());
            System.out.println("=== child22 " + child22.getField().getName());
            System.out.println("=== child23 " + child23.getField().getName());

            System.out.println("=== child31 " + child31.getField().getName());

            System.out.println("=== child41 " + child41.getField().getName());

            System.out.println("=== child41 " + child41.getField().getName());

        };
    }

}
