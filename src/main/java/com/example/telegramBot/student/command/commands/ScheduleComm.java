package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import com.example.telegramBot.student.keyboard.reply.StudentReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class ScheduleComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final String MESSAGE = "а так же ссылку на Zoom";
    private final String MESSAGE_SCHEDULE = "В этом разделе Вы найдете расписание занятий, ";

    StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    public final InlineKeyboardMarkup schedule = studentInlineKeyboardSource.getSchedule();

    private final StudentReplyKeyboardSource studentReplyKeyboardSource = new StudentReplyKeyboardSource();
    private final ReplyKeyboard returnToStudentMainMenu = studentReplyKeyboardSource.getReturnToMainMenu();

    public ScheduleComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer message_id = update.getCallbackQuery().getMessage().getMessageId();
        sendBotMessageService.deleteMessage(chatId, message_id);

        sendBotMessageService.sendMessage(chatId, MESSAGE_SCHEDULE, returnToStudentMainMenu);
        sendBotMessageService.sendMessage(chatId, MESSAGE, schedule);

    }
}
