package com.example.demo.WordLandBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(DemoApplication.class, args);
	}

}
