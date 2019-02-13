package com.endava.training.spring.demo.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(Profiles.DEV)
public class DevProfileConfigSetup implements ProfileConfigSetup {
    @Override
    public void setup() {
        System.out.println("==== Dev ProfileConfigSetup");
    }
}
