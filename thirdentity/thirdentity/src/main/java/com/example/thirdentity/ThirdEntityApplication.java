package com.example.thirdentity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ThirdEntityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdEntityApplication.class, args);
	}

}
