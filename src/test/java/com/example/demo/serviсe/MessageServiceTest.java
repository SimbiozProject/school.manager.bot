package com.example.demo.serviсe;


import com.example.demo.DemoApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MessageServiceTest extends DemoApplicationTests {

    @Autowired
    WordLandBot wordLandBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;




    @Test
    void onHelloReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/update.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Hello!");
        assertEquals(expectedResult, actualResult);
    }

    private SendMessage makeMessage(String text) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(1083113433L);
        sendMessage.setText(text);
        return sendMessage;
    }
}