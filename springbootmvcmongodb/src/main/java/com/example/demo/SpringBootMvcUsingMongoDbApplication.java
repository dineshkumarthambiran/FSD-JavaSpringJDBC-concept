package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMvcUsingMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcUsingMongoDbApplication.class, args);
	}

}
