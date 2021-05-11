package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class StartTestComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String START_TEST_MESSAGE = "Правила прохождения теста на определие уровня английского языка:" +
            " \n 1. Время на прохождение теста - 20 минут." +
            " \n 2. Запрещено пользоваться сторонними приложениями, словарями, помощью друга";
    public final InlineKeyboardMarkup startTest = userInlineKeyboardSource.getStartTest();


    public StartTestComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, START_TEST_MESSAGE, startTest);

    }
}
