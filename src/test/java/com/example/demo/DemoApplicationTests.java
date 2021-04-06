package com.example.demo;

import com.example.demo.config.Mapper;
import com.example.demo.serviсe.MessageService;
import com.example.demo.serviсe.WordLandBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {WordLandBot.class, Mapper.class, MessageService.class})
public class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
