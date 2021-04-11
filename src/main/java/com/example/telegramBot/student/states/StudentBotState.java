package com.example.telegramBot.student.states;

import com.example.telegramBot.interfaces.BotState;
import com.example.telegramBot.service.MessageService;
import com.example.telegramBot.service.StudentMessageService;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public enum StudentBotState implements BotState<StudentBotState, StudentBotContext> {

    EnglishTestExecution(false){
        @Override
        public void enter(StudentBotContext studentBotContext) throws TelegramApiException {
            studentMessageService.sendEnglishTestExecution(studentBotContext.getStudent());

        }

        @Override
        public StudentBotState nextState() {
            return null;
        }
    };


    private static StudentMessageService studentMessageService;

    private final Boolean isInputNeeded;

    StudentBotState(Boolean isInputNeeded) {
        this.isInputNeeded = isInputNeeded;
    }
}

