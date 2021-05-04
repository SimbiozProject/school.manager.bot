package com.example.telegramBot.student.keyboard.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegramBot.student.repositiry.TestAnswerOptions.ANSWER_OPTIONS;


public class StudentInlineKeyboardSource {

    public StudentInlineKeyboardSource() {
    }

    public InlineKeyboardMarkup getAnswerOptionsInlineMarkup(Integer number) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[number][0]);
        InlineKeyboardButton secondKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[number][1]);
        InlineKeyboardButton thirdKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[number][2]);
        InlineKeyboardButton fourthKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[number][3]);

        firstKeyboardButton.setCallbackData("english" + ANSWER_OPTIONS[number][0]);
        secondKeyboardButton.setCallbackData("english" + ANSWER_OPTIONS[number][1]);
        thirdKeyboardButton.setCallbackData("english" + ANSWER_OPTIONS[number][2]);
        fourthKeyboardButton.setCallbackData("english" + ANSWER_OPTIONS[number][3]);

        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(firstKeyboardButton);
        keyboardFirstRow.add(secondKeyboardButton);

        List<InlineKeyboardButton> keyboardSecondRow = new ArrayList<>();
        keyboardSecondRow.add(thirdKeyboardButton);
        keyboardSecondRow.add(fourthKeyboardButton);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardFirstRow);
        keyboard.add(keyboardSecondRow);

        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }

    public InlineKeyboardMarkup getStartTest() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstKeyboardButton = new InlineKeyboardButton().setText("Start test");
        firstKeyboardButton.setCallbackData("inline.test");
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(firstKeyboardButton);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardFirstRow);
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }
}

