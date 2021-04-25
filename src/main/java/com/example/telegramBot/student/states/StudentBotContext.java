package com.example.telegramBot.student.states;

import com.example.telegramBot.student.command.StudentCommandHandler;
import com.example.telegramBot.model.id.User;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class StudentBotContext {
    private final StudentCommandHandler studentCommandHandler;
    private final User user;
    private final Update update;

    private StudentBotContext(StudentCommandHandler studentCommandHandler, User user, Update update) {
        this.studentCommandHandler = studentCommandHandler;
        this.user = user;
        this.update = update;
    }

    public static StudentBotContext of(StudentCommandHandler studentCommandHandler, User user, Update update) {
        return new StudentBotContext(studentCommandHandler, user, update);
    }
}
