package com.example.telegramBot.service;

import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static org.junit.jupiter.api.Assertions.*;

class StudentMessageServiceTest {

    StudentMessageService studentMessageService = new StudentMessageService();

    @Test
    void sendKeyboard() throws TelegramApiException {
        SendMessage actual = studentMessageService.sendEnglishTestExecution(1234567890);
        assertEquals("1234567890", actual.getChatId());
        assertEquals("вопрос от Оли", actual.getText());
        System.out.println(actual.getReplyMarkup());

    }

}