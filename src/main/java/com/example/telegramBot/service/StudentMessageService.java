package com.example.telegramBot.service;

import com.example.telegramBot.student.keybord.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import static com.example.telegramBot.service.TelegramBot.numberOfQuestion;

public class StudentMessageService {



    public SendMessage sendEnglishTestExecution(long chatId) {
        StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);

        sendMessage.setText(String.format("%d вопрос от Оли надо оочень длинный во всю строку", (numberOfQuestion + 1)));
        sendMessage.setReplyMarkup(studentInlineKeyboardSource.getAnswerOptionsInlineMarkup(numberOfQuestion));
        numberOfQuestion++;

        return sendMessage;

        //todo без ID & date for mesageservise
    }

    public SendMessage sendStartTest(long chatId)  {
        StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();

        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);

        sendMessage.setText("для начала нажмите кнопку");
        sendMessage.setReplyMarkup(studentInlineKeyboardSource.getStartTest());

        //todo без ID & date for mesageservise

        return sendMessage;
    }
}
