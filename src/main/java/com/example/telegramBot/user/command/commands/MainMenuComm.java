package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;

import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static com.example.telegramBot.user.repositiry.Contacts.contacts;

public class MainMenuComm implements Command {

    private final UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    private final UserReplyKeyboardSource userReplyKeyboardSource = new UserReplyKeyboardSource();
    private final static String MAIN_MENU_MESSAGE = "Да выбери уже что-нить \ud83d\ude34 \ud83e\udd28 ))).";
    private final ReplyKeyboard mainMenuKeyboard = userInlineKeyboardSource.getMainMenuKeyboard();

    private final SendBotMessageService sendBotMessageService;

    public MainMenuComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        //временный вариант получ ения контакта
//        String phoneNumber = update.getMessage().getContact().getPhoneNumber();
//        Integer userID = update.getMessage().getContact().getUserID();
//        contacts.put(userID, phoneNumber);
//
//        String chatId = update.getMessage().getChatId().toString();
//        Integer message_id = update.getMessage().getMessageId();
//        sendBotMessageService.deleteMessage(chatId, message_id);
//        userReplyKeyboardSource.getPhoneNumberReplyKeyboard().getKeyboard().clear();

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), MAIN_MENU_MESSAGE, mainMenuKeyboard);


    }
}
