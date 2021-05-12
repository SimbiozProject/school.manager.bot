package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import com.example.telegramBot.student.keyboard.reply.StudentReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class HomeWorkComm implements Command {

    private final StudentReplyKeyboardSource studentReplyKeyboardSource = new StudentReplyKeyboardSource();
    private final StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    private final static String HOME_WORK_MESSAGE = "Здусь ты можешь получить домашнее задание и отправить ее на проверку преподавателю";
    private final ReplyKeyboard homeWork = studentInlineKeyboardSource.getHomeWorkKeyboard();
    private final ReplyKeyboard returnToStudentMainMenu = studentReplyKeyboardSource.getReturnToMainMenu();
    private final SendBotMessageService sendBotMessageService;

    public HomeWorkComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        String chatId = update.getMessage().getChatId().toString();
        Integer message_id = update.getMessage().getMessageId();
        sendBotMessageService.deleteMessage(chatId, message_id);

        sendBotMessageService.sendMessage(update.getCallbackQuery().getMessage().getChatId().toString(), HOME_WORK_MESSAGE, homeWork);
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), returnToStudentMainMenu);

    }
}
