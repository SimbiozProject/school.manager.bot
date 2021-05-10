package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;

import com.example.telegramBot.user.command.commands.Command;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownComm implements Command {
    private final SendBotMessageService sendBotMessageService;
    public final static String UNKNOWN_MESSAGE ="Вы о чем?";
    public UnknownComm(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void  execute(Update update){
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, UNKNOWN_MESSAGE);
    }




}
