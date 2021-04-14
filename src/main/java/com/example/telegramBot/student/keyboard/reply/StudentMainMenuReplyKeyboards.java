package com.example.telegramBot.student.keyboard.reply;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class StudentMainMenuReplyKeyboards {

    public ReplyKeyboard getReplyKeyboard() {
        final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);
        replyKeyboardMarkup.setOneTimeKeyboard(false);

        List<KeyboardRow> keyboardRows = new ArrayList<>();

        KeyboardRow keyboardRowOne = new KeyboardRow();
        KeyboardRow keyboardRowTwo = new KeyboardRow();
        KeyboardRow keyboardRowThree = new KeyboardRow();

        keyboardRowOne.add(new KeyboardButton("1. Начальная проверка уровня английского."));
        keyboardRowTwo.add(new KeyboardButton("2. Запись на пробное занятие."));
        keyboardRowThree.add(new KeyboardButton("3. Информация о курсе."));

        keyboardRows.add(keyboardRowOne);
        keyboardRows.add(keyboardRowTwo);
        keyboardRows.add(keyboardRowThree);

        replyKeyboardMarkup.setKeyboard(keyboardRows);

        return replyKeyboardMarkup;
    }
}
