package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class SettingsComm implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String SETTINGS_MESSAGE ="Здесь будут какие-то настройки";

    public SettingsComm(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void  execute(Update update){
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, SETTINGS_MESSAGE);
    }
}
