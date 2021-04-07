package com.example.telegramBot;

import com.example.telegramBot.config.Mapper;
import com.example.telegramBot.service.MessageService;

import com.example.telegramBot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class TelegramBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
