package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class StudentMenuComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final String MESSAGE = "Мой кабинет";

    private final StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    public final ReplyKeyboard menu = studentInlineKeyboardSource.getStudentMenuKeyboard();

    public StudentMenuComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), MESSAGE, menu);
    }
}
