package com.example.telegramBot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageService {

    @Autowired TelegramBot telegramBot;

    public SendMessage onUpdateReceived(Update update) {
        SendMessage sendMessage = new SendMessage();
        if(update != null) {
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());
            if(message != null && message.hasText()) {
                String magText = message.getText();
                if(magText.equals("/start")) {
                    return sendMessage.setText("Hello!");
                } else if (magText.equals("/settings")) {
                    return sendMessage.setText("Settings!");
                } else if (magText.equals("/help")) {

                    return sendMessage.setText("Help!");
                }
            }
        }
        return sendMessage.setText("Do no!");
    }

    public Message sendMessage(SendMessage sendMessage) throws TelegramApiException {
        return telegramBot.execute(sendMessage);
    }
}
