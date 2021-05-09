package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class HomeWorkComm implements Command{

    private final UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    private final static String HOME_WORK_MESSAGE = "Здусь ты можешь получить домашнее задание и отправить ее на проверку преподавателю";
    private final ReplyKeyboard homeWork = userInlineKeyboardSource.getHomeWorkKeyboard();
    @Override
    public void execute(Update update) {

    }
}
