package com.example.telegramBot.command;

import com.example.telegramBot.service.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartComm implements Command {
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE ="Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом";
    public StartComm(SendBotMessageService sendBotMessageService){
        this.sendBotMessageService = sendBotMessageService;
    }
@Override
    public void  execute(Update update){
    String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
       }
}
