package com.endava.training.spring.demo;

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
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

/**
 * Created by vsafronovici on 3/15/2017.
 */
@SpringBootApplication
@ImportResource("classpath:spring-config.xml")
public class Application {

    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    private static final String PROFILE = "main";



    public static void main(String[] args) {
        LOG.info("========= Entering main() =============");

        //SpringApplication.run(Application.class);

        SpringApplication app = new SpringApplication(Application.class);
        app.setAdditionalProfiles(PROFILE);
        app.run(args);


    }

    @Autowired
    private Person p1; /* bean name defined same as in xml */

    @Autowired
    private Person p2; /* bean name defined same as in xml */

    @Autowired
    private Person p3; /* bean name defined same as in xml */

    @Bean
    public Person p4() { /* p4 is bean name */
        return new Person("name4", null);
    }


    /*
     ************************************
     ***  Bean scopes demo
     ************************************
     */
    @Autowired
    private Person pS1; /* bean name defined same as in xml */

    @Autowired
    private Person pS2; /* bean name defined same as in xml */

    @Autowired
    private Person pS3; /* bean name defined same as in xml */

    @Autowired
    private Person pS4; /* bean name defined same as in xml */


    /*
     ************************************
     ***  Inheritance demo
     ************************************
    */
    @Autowired
    private A iA;

    @Autowired
    private AS iAS;

    @Autowired
    private AS iAS2;



    /*
     ************************************
     ***  interfaces
     ************************************
     */
    @Autowired
    private PersonService personService;


    /*
     ************************************
     ***  Injection with annotations
     ************************************
     */
    @Autowired
    private Parent parent;

    @Autowired
    private ApplicationContext applicationContext;



    @Bean
    @Profile(PROFILE)
    public CommandLineRunner demo(Person p4) {
        return (args) -> {
            LOG.info("========= Entering demo() =============");

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);

            System.out.println("==================== Bean scopes demo ===========");
            System.out.println(pS1);
            System.out.println(pS2);
            System.out.println(pS3);
            System.out.println(pS4);

            System.out.println("==================== Inheritance demo ===========");
            System.out.println(iA);
            System.out.println(iAS);
            System.out.println(iAS2);


            System.out.println("==================== Interfaces and proxy demo ===========");
            personService.save(p1);
            personService.save(p2);
            System.out.println(personService.getAll());
            System.out.println(personService.getAll());


            System.out.println(parent);

            System.out.println(applicationContext.getBeanDefinitionNames());
            System.out.println(applicationContext.getBean("p1") == p1);
            System.out.println(applicationContext.getBean("adP1") == pS1.getAddress());





        };
    }


}
