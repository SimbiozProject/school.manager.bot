package com.example.telegramBot;

import com.example.telegramBot.model.id.User;
import com.example.telegramBot.student.service.SendBotMessageServiceRealisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.telegramBot.student.command.StudentCommandHandler;


@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    private final StudentCommandHandler studentCommandHandler;

    @Autowired
    public TelegramBot() {
        this.studentCommandHandler = new StudentCommandHandler(new SendBotMessageServiceRealisation(this));
    }

    @Override
    public void onUpdateReceived(Update update) {

        Long userId = getUserId(update);
        User user = new User();

        //todo connect to database

        studentCommandHandler.handle(update);
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
