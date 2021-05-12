package com.example.telegramBot.student.command.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {

    void execute(Update update);
}
