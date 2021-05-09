package com.example.telegramBot.student.command;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.command.commands.*;
import com.google.common.collect.ImmutableMap;

import static com.example.telegramBot.user.command.CommandName.*;

public class StudentCommandHandler {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownComm;

    public StudentCommandHandler(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(HOME_WORK. getCommandName(), new HomeWorkComm(sendBotMessageService))
                .build();

        unknownComm = new UnknownComm(sendBotMessageService);
    }


}
