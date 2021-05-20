package com.example.telegramBot.student.command;

public enum CommandName {
  
    SCHEDULE("schedule"),
    COMMUNITY("community"),
    ZOOM("zoom"),
    STUDENT_MENU("/start"),
    HOME_WORK("homework"),
    RETURN_TO_STUDENT_MAIN_MENU("Вернуться в главное меню");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }

    public String getCommandName() {
        return commandName;
    }

}
