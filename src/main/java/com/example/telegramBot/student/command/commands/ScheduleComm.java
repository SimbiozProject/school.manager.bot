package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class ScheduleComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final String MESSAGE = "Расписание занятий";

    StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();

    public final InlineKeyboardMarkup schedule = studentInlineKeyboardSource.getSchedule();

    public ScheduleComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, MESSAGE, schedule);
    }
}
