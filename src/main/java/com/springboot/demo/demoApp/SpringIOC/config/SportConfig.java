package com.springboot.demo.demoApp.SpringIOC.config;

import com.springboot.demo.demoApp.SpringIOC.common.Coach;
import com.springboot.demo.demoApp.SpringIOC.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    // default bean id is method name(i.e "swimCoach")
    // bean id for below method is "aquatic"
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}