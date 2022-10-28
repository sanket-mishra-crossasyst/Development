package com.example.springscheduling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringschedulingApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringschedulingApplication.class, args);
	}

}
