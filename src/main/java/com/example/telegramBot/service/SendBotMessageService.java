package com.example.telegramBot.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public interface SendBotMessageService {

    void sendMessage(String chatId, String message);
    void sendMessage(String chatId, ReplyKeyboard replyMarkup);
    void sendMessage(String chatId, String message, ReplyKeyboard replyMarkup);
    void deleteMessage(String chatId, Integer message_id);
    void sendPhoto(String chatId, String url);
}
