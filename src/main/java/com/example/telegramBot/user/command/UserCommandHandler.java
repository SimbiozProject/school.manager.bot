package com.example.telegramBot.user.command;

import com.example.telegramBot.service.SendBotMessageService;

import com.example.telegramBot.student.command.commands.ScheduleComm;

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
                //.put(START.getCommandName(), new StartComm(sendBotMessageService))
                .put(HELLO.getCommandName(), new HelloComm(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpComm(sendBotMessageService))
                .put(SETTINGS.getCommandName(), new SettingsComm(sendBotMessageService))
                .put(NO.getCommandName(), new NoComm(sendBotMessageService))
                .put(START_TEST.getCommandName(), new StartTestComm(sendBotMessageService))
                .put(TEST.getCommandName(), new TestComm(sendBotMessageService))
                //.put(MAIN_MENU.getCommandName(), new MainMenuComm(sendBotMessageService))
                .put(START.getCommandName(), new MainMenuComm(sendBotMessageService))
                .put(SELECTION_COURSE.getCommandName(), new SelectionCourseComm(sendBotMessageService))
                .put(LEVEL_ZERO_MENU.getCommandName(), new LevelZeroComm(sendBotMessageService))
                .put(LEVEL_ADVANCED_MENU.getCommandName(), new LevelAdvancedComm(sendBotMessageService))
                .put(RETURN_TO_SELECTION_COURSE.getCommandName(), new SelectionCourseComm(sendBotMessageService))
                .put(RETURN_TO_MAIN_MENU.getCommandName(), new MainMenuComm(sendBotMessageService))
                .put(INFO.getCommandName(), new InfoComm(sendBotMessageService))
                .put(GROUPS.getCommandName(), new GroupsComm(sendBotMessageService))
                .put(FAQ.getCommandName(), new FaqComm(sendBotMessageService))
                .put(ABOUT_US.getCommandName(), new AboutUsComm(sendBotMessageService))
                .put(STUDENT_MENU.getCommandName(), new StudentMenuComm(sendBotMessageService)) //todo  удалить после рефакторинга
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
