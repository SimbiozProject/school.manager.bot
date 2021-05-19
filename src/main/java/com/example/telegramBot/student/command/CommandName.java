package com.example.telegramBot.student.command;

public enum CommandName {
  
    SCHEDULE("schedule"),
    COMMUNITY("community"),
    ZOOM("zoom"),
    STUDENT_MENU("/start"),
    HOME_WORK("homework");


    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
