package com.springboot.demo.demoApp.SpringIOC.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// prototype scope will create new object instance for each injection
// singleton(default) scope will create single shared instance
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach{
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    // this method will be called during bean initialization
    @PostConstruct
    public void doMyStartUp() {
        System.out.println("Implement Post Construction " + getClass().getSimpleName());
    }

    // this method will be called during bean destruction
    // with prototype scope bean, spring doesn't call destroy method
    @PreDestroy
    public void doMyCleanUp() {
        System.out.println("Implement Pre Cleaning " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!";
    }
}
