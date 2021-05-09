package com.example.telegramBot.user.command;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.student.command.commands.HomeWorkComm;
import com.example.telegramBot.user.command.commands.*;
import com.google.common.collect.ImmutableMap;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.example.telegramBot.user.command.CommandName.*;

public class UserCommandHandler {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownComm;

    public UserCommandHandler(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartComm(sendBotMessageService))
                .put(HELLO.getCommandName(), new HelloComm(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpComm(sendBotMessageService))
                .put(SETTINGS.getCommandName(), new SettingsComm(sendBotMessageService))
                .put(NO.getCommandName(), new NoComm(sendBotMessageService))
                .put(TEST.getCommandName(), new TestComm(sendBotMessageService))
                .put(TEST_ANSWER.getCommandName(), new TestComm(sendBotMessageService))
                .put(MAIN_MENU.getCommandName(), new MainMenuComm(sendBotMessageService))
                .build();

        unknownComm = new UnknownComm(sendBotMessageService);
    }


    public void handle(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                String commandIdentifier = update.getMessage().getText();
                retrieveCommand(commandIdentifier).execute(update);
            } else if (update.getMessage().hasContact()) {
                String commandIdentifier = ifTheContact(update.getMessage().getContact().getPhoneNumber());
                retrieveCommand(commandIdentifier).execute(update);
            }
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

    public String ifTheContact(String str) {
        if (str.startsWith("+")) {
            str = "shared.contact";
        }
        return str;
    }

}
