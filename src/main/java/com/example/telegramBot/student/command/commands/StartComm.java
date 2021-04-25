package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.student.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class StartComm implements Command {

    StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    private final SendBotMessageService sendBotMessageService;
    public final static String START_MESSAGE = "Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом";
    public final ReplyKeyboard startTest = studentInlineKeyboardSource.getStartTest();

    public StartComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, START_MESSAGE, startTest);
    }
}
