package com.example.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PizzaApplication {

	public static void main(String[] args) {
//		System.setProperty("db_url", "jdbc:postgresql://localhost:5432/postgres");
//		System.setProperty("db_username", "postgres");
//		System.setProperty("db_password", "postgres");
		SpringApplication.run(PizzaApplication.class, args);
	}


}
