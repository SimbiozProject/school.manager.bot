package com.example.telegramBot.student.command;

public enum CommandName {

    HOME_WORK("homework");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }



}
