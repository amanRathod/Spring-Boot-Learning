package com.springboot.demo.demoApp;

import com.springboot.demo.demoApp.HibernateJPA.CrudDemoApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(
		scanBasePackages = {
				"com.springboot.demo.demoApp",
				"com.springboot.util"
		}
)
public class DemoAppApplication {
	static CrudDemoApplication crudDemoApplication;

	public static void main(String[] args) {
		SpringApplication.run(DemoAppApplication.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(String[] args) {
//		return runner -> {
//			System.out.println("Database connected successfully");
//		};
//	}

}
