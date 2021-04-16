package com.example.telegramBot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface Command {



void execute(Update update);
}
