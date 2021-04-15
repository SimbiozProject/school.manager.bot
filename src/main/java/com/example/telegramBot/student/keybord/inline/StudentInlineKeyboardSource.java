package com.example.telegramBot.student.keybord.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static com.example.telegramBot.student.constants.EnglishTestConstants.ANSWER_OPTIONS;


public class StudentInlineKeyboardSource {

    public StudentInlineKeyboardSource() {
    }

    public InlineKeyboardMarkup getAnswerOptionsInlineMarkup(Integer numberOfQuestion) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[numberOfQuestion][0]);
        InlineKeyboardButton secondKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[numberOfQuestion][1]);
        InlineKeyboardButton thirdKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[numberOfQuestion][2]);
        InlineKeyboardButton fourthKeyboardButton = new InlineKeyboardButton().setText(ANSWER_OPTIONS[numberOfQuestion][3]);

        firstKeyboardButton.setCallbackData("Answer accepted");
        secondKeyboardButton.setCallbackData("Answer accepted");
        thirdKeyboardButton.setCallbackData("Answer accepted");
        fourthKeyboardButton.setCallbackData("Answer accepted");

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

        InlineKeyboardButton firstKeyboardButton = new InlineKeyboardButton().setText("start test");
        firstKeyboardButton.setCallbackData("Answer accepted");
        List<InlineKeyboardButton> keyboardFirstRow = new ArrayList<>();
        keyboardFirstRow.add(firstKeyboardButton);
        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(keyboardFirstRow);
        inlineKeyboardMarkup.setKeyboard(keyboard);

        return inlineKeyboardMarkup;
    }
}

