package com.example.demo.serviсe;

import com.example.demo.DemoApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class WordLandBotTest extends DemoApplicationTests {

    @Autowired
    WordLandBot wordLandBot;;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void onUpdateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        wordLandBot.onUpdateReceived(update);
    }

    @Test
    void sendMessage() throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1083113433L);
        sendMessage.setText("Do no!");
        wordLandBot.execute(sendMessage);
    }
}