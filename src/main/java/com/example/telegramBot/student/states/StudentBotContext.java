package com.example.telegramBot.student.states;

import com.example.telegramBot.model.Student;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StudentBotContext {
    private final Student student;
    private final Update update;

    public StudentBotContext(Student student, Update update) {
        this.student = student;
        this.update = update;
    }

    public Student getStudent() {
        return student;
    }

    public Update getUpdate() {
        return update;
    }
}

