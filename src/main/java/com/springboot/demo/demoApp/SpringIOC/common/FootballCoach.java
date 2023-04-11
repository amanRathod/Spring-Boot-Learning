package com.springboot.demo.demoApp.SpringIOC.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class FootballCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Practice football for 15 minutes!!";
    }
}
