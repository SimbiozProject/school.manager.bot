package com.example.telegramBot.student.command;

import com.example.telegramBot.student.service.SendBotMessageService;
import com.example.telegramBot.student.command.commands.*;
import com.google.common.collect.ImmutableMap;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegramBot.student.command.CommandName.*;

public class StudentCommandHandler {

private final ImmutableMap<String, Command>commandMap;
private final Command unknownComm;

    public StudentCommandHandler(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartComm(sendBotMessageService))
                .put(HELLO.getCommandName(), new HelloComm(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpComm(sendBotMessageService))
                .put(SETTINGS.getCommandName(), new SettingsComm(sendBotMessageService))
                .put(NO.getCommandName(), new NoComm(sendBotMessageService))
                .put(TEST.getCommandName(), new TestComm(sendBotMessageService))
                .put(TEST_ANSWER.getCommandName(), new TestComm(sendBotMessageService))
                .build();

        unknownComm = new UnknownComm(sendBotMessageService);
    }


    public void handle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String commandIdentifier = update.getMessage().getText();
            retrieveCommand(commandIdentifier).execute(update);

        } else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage().hasText()) {
            String commandIdentifier = update.getCallbackQuery().getData().trim();
            retrieveCommand(commandIdentifier).execute(update);
        }
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownComm);
    }

}
