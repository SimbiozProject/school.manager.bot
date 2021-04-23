package com.example.telegramBot.states;

import com.example.telegramBot.command.CommandHandler;
import com.example.telegramBot.model.User;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class UserBotContext {
    private final CommandHandler userCommandHandler;
    private final User user;
    private final Update update;

    private UserBotContext(CommandHandler userCommandHandler, User user, Update update) {
        this.userCommandHandler = userCommandHandler;
        this.user = user;
        this.update = update;
    }

    public static UserBotContext of(CommandHandler userCommandHandler, User user, Update update) {
        return new UserBotContext(userCommandHandler, user, update);
    }
}
