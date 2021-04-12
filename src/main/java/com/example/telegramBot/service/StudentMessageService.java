package com.example.telegramBot.service;

//import com.example.telegramBot.model.Student;
import com.example.telegramBot.student.keybord.inline.StudentInlineKeyboardSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import static com.example.telegramBot.student.constants.EnglishTestConstants.ANSWER_OPTIONS;

public class StudentMessageService {

    @Autowired
    private MessageService messageService;

    /*@Autowired
    private StudentInlineKeyboardSource studentInlineKeyboardSource;*/

    /*public void sendEnglishTestExecution(Student student) throws TelegramApiException {
        for (int i = 0; i < ANSWER_OPTIONS.length; i++) {
            SendMessage sendMessage = new SendMessage();

            sendMessage.setChatId(student.getUser().getChatId());
            sendMessage.setText(String.format("%d вопрос от Оли", i));
            sendMessage.setReplyMarkup(studentInlineKeyboardSource.getAnswerOptionsInlineMarkup(i));

            Message message = messageService.sendMessage(sendMessage);

            //todo без ID & date for mesageservise
        }


    }*/

    public SendMessage sendEnglishTestExecution(long chatId) throws TelegramApiException {
        StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();

        //for (int i = 0; i < ANSWER_OPTIONS.length; i++) {
        SendMessage sendMessage = new SendMessage();

        sendMessage.setChatId(chatId);
        sendMessage.setText("вопрос от Оли");
        sendMessage.setReplyMarkup(studentInlineKeyboardSource.getAnswerOptionsInlineMarkup(0));


        //todo без ID & date for mesageservise
        //}
        return sendMessage;
    }

}
