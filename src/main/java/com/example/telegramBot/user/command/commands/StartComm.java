package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class StartComm implements Command {

    UserReplyKeyboardSource userReplyKeyboardSource = new UserReplyKeyboardSource();
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом";

    public final ReplyKeyboard getContact = userReplyKeyboardSource.getPhoneNumberReplyKeyboard();

    public StartComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        Integer message_id = update.getMessage().getMessageId();
        sendBotMessageService.deleteMessage(chatId, message_id);
        sendBotMessageService.sendMessage(chatId, START_MESSAGE, getContact);

    }
}
