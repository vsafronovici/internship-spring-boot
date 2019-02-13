package com.endava.training.spring.demo.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Profiles.PRODUCTION)
public class ProductionProfileConfigSetup implements ProfileConfigSetup {
    @Override
    public void setup() {
        System.out.println("==== Production ProfileConfigSetup");
    }
}
