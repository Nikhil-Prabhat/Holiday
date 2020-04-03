package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.controller", "com.model", "com.validate" })
public class Movie11Application {

	public static void main(String[] args) {
		SpringApplication.run(Movie11Application.class, args);
	}

}
