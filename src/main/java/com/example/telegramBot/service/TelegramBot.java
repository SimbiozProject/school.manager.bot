package com.example.telegramBot.service;

import com.example.telegramBot.model.id.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import com.example.telegramBot.command.CommandHandler;

import java.io.File;
import java.io.IOException;

import static com.example.telegramBot.command.CommandName.NO;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    @Autowired
    ObjectMapper objectMapper;


    public static String COMMAND_PREFIX = "/";

    private final CommandHandler commandHandler;

    @Autowired
    public TelegramBot() {
        this.commandHandler = new CommandHandler(new SendBotMessageServiceRealisation(this));
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandHandler.retrieveCommand(commandIdentifier).execute(update);

            } else {
                commandHandler.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
        Long userId = getUserId(update);
        User user = new User();

        //todo connect to database

        commandHandler.handle(update);
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

    private void saveJson(Update update) {
       try {
            objectMapper.writeValue(new File("src/test/resources/update.json"), update);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
