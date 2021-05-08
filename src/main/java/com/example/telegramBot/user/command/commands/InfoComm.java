package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class InfoComm implements Command{
    private final SendBotMessageService sendBotMessageService;

    public InfoComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update) {

    }
}
