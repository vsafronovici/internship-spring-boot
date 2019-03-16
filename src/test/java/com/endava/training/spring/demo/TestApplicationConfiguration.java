package com.endava.training.spring.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan(
        useDefaultFilters = false,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = CommandLineRunner.class),
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = {RestController.class, Service.class})
)
@EnableAutoConfiguration
public class TestApplicationConfiguration {
}
