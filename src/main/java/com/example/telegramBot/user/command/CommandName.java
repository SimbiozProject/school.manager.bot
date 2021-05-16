package com.example.telegramBot.user.command;

public enum CommandName {

    START("/start"),
    HELP("/help"),
    HELLO("/hello"),
    SETTINGS("/settings"),
    NO("nocommand"),
    START_TEST("initial.level.check"),
    TEST("english"),
    MAIN_MENU("shared.contact"),
    SELECTION_COURSE("buy.course"),
    RETURN_TO_SELECTION_COURSE("back.to.selection.course"),
    RETURN_TO_MAIN_MENU("Вернуться в главное меню"),
    GROUPS("groups"),
    COST("cost"),
    INFO("course.information"),
    FAQ("faq"),
    ABOUT_US("about.us"),
    LEVEL_ZERO_MENU("level.zero"),
    LEVEL_ADVANCED_MENU("level.advanced"),
    FINISH_AND_SEND("finish.and.send");

    private final String commandName;

    CommandName(String commandName) {
        this.commandName = commandName;
    }


    public String getCommandName() {
        return commandName;
    }


}
