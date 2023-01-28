package com.leo.demo.foodapp.foodapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodApiApplication.class, args);
	}

}
