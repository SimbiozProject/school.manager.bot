package com.example.telegramBot.student.command;

public enum CommandName {
    SCHEDULE("schedule"),
    COMMUNITY("community"),
    ZOOM("zoom"),
    STUDENT_MENU("/start");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
