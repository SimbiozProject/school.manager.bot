package com.example.telegramBot.command;

import com.example.telegramBot.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;
import com.example.telegramBot.service.SendBotMessageService;

import static com.example.telegramBot.command.CommandName.*;

public class CommandHandler {

private final ImmutableMap<String,Command>commandMap;
private final Command unknownComm;

    public CommandHandler(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartComm(sendBotMessageService))
                .put(HELLO.getCommandName(), new HelloComm(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpComm(sendBotMessageService))
                .put(SETTINGS.getCommandName(), new SettingsComm(sendBotMessageService))
                .put(NO.getCommandName(), new NoComm(sendBotMessageService))
                .build();

        unknownComm = new UnknownComm(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownComm);
    }




}
