package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class GroupsComm implements Command{

    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String GROUPS_PHOTO_URL = "https://i.pinimg.com/originals/39/74/57/3974572f4d12c67cb4d54f424a63877a.jpg";
    public final static String GROUPS_MESSAGE = "Немного о наших группах";
    public final InlineKeyboardMarkup backToInfo = userInlineKeyboardSource.getBackToInfo();


    public GroupsComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }
    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendPhoto(chatId, GROUPS_PHOTO_URL);
        sendBotMessageService.sendMessage(chatId, GROUPS_MESSAGE, backToInfo);
    }
}
