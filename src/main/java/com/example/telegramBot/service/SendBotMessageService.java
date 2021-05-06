package com.example.telegramBot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
    void sendMessage(String chatId, String message, ReplyKeyboard replyMarkup);
    void deleteMessage(String chatId, Integer message_id);
}
