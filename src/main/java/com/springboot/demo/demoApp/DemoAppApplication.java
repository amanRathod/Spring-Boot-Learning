package com.springboot.demo.demoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages = {
				"com.springboot.demo.demoApp",
				"com.springboot.util"
		}
)
public class DemoAppApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoAppApplication.class, args);
	}

}
