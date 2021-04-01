package com.example.demo;

import com.example.demo.testForWordLand.TestAnswersOnQuestions;
import com.example.demo.testForWordLand.TestQuestions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		TestQuestions testQuestions = new TestQuestions();
		testQuestions.addsQuestionsToTest();

		TestAnswersOnQuestions testAnswersOnQuestions = new TestAnswersOnQuestions();
		testAnswersOnQuestions.addsAnswersOnQuestions();
	}

}
