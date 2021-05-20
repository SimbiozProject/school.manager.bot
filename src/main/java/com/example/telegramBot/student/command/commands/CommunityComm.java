package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import com.example.telegramBot.student.keyboard.reply.StudentReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class CommunityComm implements Command {
    private final SendBotMessageService sendBotMessageService;
    private final String MESSAGE = "Перейти в нашу группу в Telegram";
    private final String MESSAGE_COMMUNITY = "Комьюнити - эта группа, которая создана для всех учеников нашей школы.";

    private final StudentReplyKeyboardSource studentReplyKeyboardSource = new StudentReplyKeyboardSource();
    StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
    public final InlineKeyboardMarkup community = studentInlineKeyboardSource.getCommunity();
    private final ReplyKeyboard returnToStudentMainMenu = studentReplyKeyboardSource.getReturnToMainMenu();
    public CommunityComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer message_id = update.getCallbackQuery().getMessage().getMessageId();
        sendBotMessageService.deleteMessage(chatId, message_id);

        sendBotMessageService.sendMessage(chatId, MESSAGE_COMMUNITY, returnToStudentMainMenu);
        sendBotMessageService.sendMessage(chatId, MESSAGE, community);

    }
}
