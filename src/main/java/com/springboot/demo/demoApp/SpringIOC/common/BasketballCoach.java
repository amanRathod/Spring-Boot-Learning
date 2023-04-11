package com.springboot.demo.demoApp.SpringIOC.common;

import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Practice basketball for 15 minutes!!";
    }
}
