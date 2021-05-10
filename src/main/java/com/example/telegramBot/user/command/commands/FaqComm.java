package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class FaqComm implements Command{

    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String FAQ_MESSAGE = "Здесь будет много ответов на вопросы когда нибудь позже";
    public final InlineKeyboardMarkup backToInfo = userInlineKeyboardSource.getBackToInfo();


    public FaqComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, FAQ_MESSAGE, backToInfo);
    }
}
