package com.example.telegramBot.command;

public enum CommandName {

    START ("/start"),
    HELP ("/help"),
    HELLO ("/hello"),
    SETTINGS ("/settings"),
    NO("nocommand");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }



}
