package com.example.telegramBot.student.states;

import com.example.telegramBot.model.id.Student;
import com.example.telegramBot.student.command.StudentCommandHandler;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class StudentBotContext {
    private final StudentCommandHandler studentCommandHandle;
    private final Student student;
    private final Update update;

    private StudentBotContext(StudentCommandHandler studentCommandHandle, Student student, Update update) {
        this.studentCommandHandle = studentCommandHandle;
        this.student = student;
        this.update = update;
    }

    public static StudentBotContext of(StudentCommandHandler studentCommandHandler, Student student, Update update) {
        return new StudentBotContext(studentCommandHandler, student, update);
    }
}
