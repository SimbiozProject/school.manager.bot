package com.example.telegramBot.student.command;

public enum StudentCommandName {
    SCHEDULE("schedule"),
    HOMEWORK("homework"),
    COMMUNITY("community"),
    PAY("pay"),
    ZOOM("zoom"),
    ALL_SCHEDULE("all.schedule"),
    STUDENT_MENU("menu");

    private final String commandName;

    StudentCommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }
}
