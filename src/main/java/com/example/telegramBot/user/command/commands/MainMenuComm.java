package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;

import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;



public class MainMenuComm implements Command {

    private final UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String MAIN_MENU_MESSAGE = "Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом!";
    private final ReplyKeyboard mainMenuKeyboard = userInlineKeyboardSource.getMainMenuKeyboard();

    private final SendBotMessageService sendBotMessageService;

    public MainMenuComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), MAIN_MENU_MESSAGE, mainMenuKeyboard);


    }
}
