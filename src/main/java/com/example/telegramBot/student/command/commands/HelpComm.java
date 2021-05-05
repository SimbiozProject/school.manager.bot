package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.student.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class HelpComm implements Command {
    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE ="Помогу если смогу";

    public HelpComm(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void  execute(Update update){
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, HELP_MESSAGE);
    }
}