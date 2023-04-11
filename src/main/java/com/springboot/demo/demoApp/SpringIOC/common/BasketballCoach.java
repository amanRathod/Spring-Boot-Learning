package com.springboot.demo.demoApp.SpringIOC.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BasketballCoach implements Coach{
    // due to lazy annotation, basketballCoach class will only initialize
    // 1. if needed for dependency injection
    // 2. it is explicitly requested
    public BasketballCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice basketball for 15 minutes!!";
    }
}
