package com.example.telegramBot.user.states;

import com.example.telegramBot.user.command.UserCommandHandler;
import com.example.telegramBot.model.id.User;
import lombok.Getter;
import org.telegram.telegrambots.meta.api.objects.Update;

@Getter
public class UserBotContext {
    private final UserCommandHandler userCommandHandler;
    private final User user;
    private final Update update;

    private UserBotContext(UserCommandHandler userCommandHandler, User user, Update update) {
        this.userCommandHandler = userCommandHandler;
        this.user = user;
        this.update = update;
    }

    public static UserBotContext of(UserCommandHandler userCommandHandler, User user, Update update) {
        return new UserBotContext(userCommandHandler, user, update);
    }
}
