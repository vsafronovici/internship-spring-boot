package com.endava.training.spring.demo;

import com.endava.training.spring.demo.circulardi.A;
import com.endava.training.spring.demo.circulardi.A1;
import com.endava.training.spring.demo.notanot.EntityA;
import com.endava.training.spring.demo.notanot.EntityB;
import com.endava.training.spring.demo.profile.ProfileConfigSetup;
import com.endava.training.spring.demo.viaannot.Field5;
import com.endava.training.spring.demo.viaannot.TopField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
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

    /*
     * not annotated
     * */
    @Bean
    EntityA entityA() {
        return new EntityA();
    }

    /*
     * class not annotated, but has @Value and @Autowired on fields
     * */
    @Bean
    EntityB entityB() {
        return new EntityB();
    }

    /*
    * annotated with @Component
    * */
    @Bean
    Field5 myField5() {
        return new Field5() {
            @Override
            public String getName() {
                return "myField5";
            }
        };
    }

    @Bean
    Field5 myField52() {
        return new Field5() {
            @Value("${say.hi}")
            private String name;

            @Override
            public String getName() {
                return "myField5";
            }
        };
    }

    @Bean
    Field5 myField53() {
        Field5 f = new Field5();
        f.setName("myField53");
        return f;
    }


    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ProfileConfigSetup profileConfigSetup;

    @Value("${say.hi}")
    private String sayhi;

    @Autowired
    private TopField topField;


    @Autowired
    private EntityA entityA;

    @Autowired
    private EntityB entityB;

    /*
    * Circular dependency
    * */

//    @Autowired
    private A a;

//    @Autowired
    private A1 a1;

    @Bean
    public CommandLineRunner hello(Field5 myField5, Field5 myField52, Field5 myField53) {
        return (args) -> {
            LOG.info("==== {}", sayhi);
            profileConfigSetup.setup();

            System.out.println("=== TopField=" + topField);
            System.out.println("=== entityA=" + entityA);
            System.out.println("=== entityB=" + entityB);

            EntityB entityB2 = new EntityB();
            System.out.println("=== entityB=" + entityB2);

            System.out.println("=== myField5=" + myField5);
            System.out.println("=== (myField5 == getBean(myField5)) is: " + (myField5 == applicationContext.getBean("myField5")));
            System.out.println("=== (myField5 == field5) is: " + (applicationContext.getBean("myField5") == applicationContext.getBean("field5")));

            System.out.println("=== myField5=" + myField52);
            System.out.println("=== myField5=" + myField53);


        };
    }

}
