package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.user.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class StartComm implements Command {

    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом";
    public final ReplyKeyboard startTest = userInlineKeyboardSource.getStartTest();

    public StartComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, START_MESSAGE, startTest);
    }
}
