package com.example.telegramBot.user.command.commands;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {


    void execute(Update update);
}
