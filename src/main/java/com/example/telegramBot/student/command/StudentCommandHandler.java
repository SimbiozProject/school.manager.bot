package com.example.telegramBot.student.command;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.command.commands.*;
import com.example.telegramBot.student.command.commands.Command;
import com.google.common.collect.ImmutableMap;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegramBot.student.command.CommandName.*;

public class StudentCommandHandler {
    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownComm;

    public StudentCommandHandler(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(SCHEDULE.getCommandName(), new ScheduleComm(sendBotMessageService))
                .put(COMMUNITY.getCommandName(), new CommunityComm(sendBotMessageService))
                //.put(PAY.getCommandName(), new PayComm(sendBotMessageService))
                .put(ZOOM.getCommandName(), new ZoomComm(sendBotMessageService))
                //.put(ALL_SCHEDULE.getCommandName(), new AllScheduleComm(sendBotMessageService))
                .put(STUDENT_MENU.getCommandName(), new StudentMenuComm(sendBotMessageService))
                .build();

        unknownComm = new UnknownComm(sendBotMessageService);
    }

    public void handle(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String commandIdentifier = update.getMessage().getText();
            retrieveCommand(commandIdentifier).execute(update);

        } else if (update.hasCallbackQuery() && update.getCallbackQuery().getMessage().hasText()) {
            String commandIdentifier = ifTheTest(update.getCallbackQuery().getData().trim());
            retrieveCommand(commandIdentifier).execute(update);
        }
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownComm);
    }

    public String ifTheTest(String str) {
        if (str.startsWith("english")) {
            str = "english";
        }
        return str;
    }

}



