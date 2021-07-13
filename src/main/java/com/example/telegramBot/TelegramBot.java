package com.example.telegramBot;

import com.example.telegramBot.model.id.User;
import com.example.telegramBot.service.SendBotMessageServiceRealisation;
//import com.example.telegramBot.student.command.StudentCommandHandler;
import com.example.telegramBot.student.command.StudentCommandHandler;
import com.example.web.dao.service.StatisticUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.telegramBot.user.command.UserCommandHandler;


//@Component
//@PropertySource("classpath:application.properties")
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    private final UserCommandHandler userCommandHandler;
    private final StudentCommandHandler studentCommandHandler;

    @Autowired
    public TelegramBot(StatisticUserService statisticUserService) {
        this.userCommandHandler = new UserCommandHandler(new SendBotMessageServiceRealisation(this), statisticUserService);
        this.studentCommandHandler = new StudentCommandHandler(new SendBotMessageServiceRealisation(this));
    }


    @Override
    public void onUpdateReceived(Update update) {

        Long userId = getUserId(update);
        User user = new User();

        //todo connect to database

        userCommandHandler.handle(update);
        //studentCommandHandler.handle(update);
    }

    private Long getUserId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getFrom().getId().longValue();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getFrom().getId().longValue();
        } else if (update.hasEditedMessage()) {
            return update.getEditedMessage().getFrom().getId().longValue();
        }
        return null;
    }


    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }


}
