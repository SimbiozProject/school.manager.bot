package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import static com.example.telegramBot.user.Strings.FinalStringsFile.ABOUT_US_MESSAGE;

public class AboutUsComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String ABOUT_US_PHOTO_URL = "https://eurostudy.info/images/content/courses35.jpg";

    public final InlineKeyboardMarkup backToInfo = userInlineKeyboardSource.getBackToInfo();


    public AboutUsComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendPhoto(chatId, ABOUT_US_PHOTO_URL);
        sendBotMessageService.sendMessage(chatId, ABOUT_US_MESSAGE, backToInfo);

    }
}
