package com.example.telegramBot.service;


import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@PropertySource("application.properties")
public class TelegramBot extends TelegramLongPollingBot {
    @Value("${bot.username}")
    private String botUsername;
    @Value("${bot.token}")
    private String botToken;

    StudentMessageService studentMessageService = new StudentMessageService();

    public static Integer numberOfQuestion = 0;

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            if (update.getMessage().hasText()) {
                if (update.getMessage().getText().equals("/Test")) {
                    execute(studentMessageService.sendStartTest(update.getMessage().getChatId()));
                }
            }
        } else if (update.hasCallbackQuery()) {
            if (update.getCallbackQuery().getData().equals("Answer accepted") && numberOfQuestion < 25) {
                execute(studentMessageService.sendEnglishTestExecution(update.getCallbackQuery().getMessage().getChatId()));
            } else {
                execute(new SendMessage().setText(update.getCallbackQuery().getData()).setChatId(update.getCallbackQuery().
                        getMessage().getChatId()));
            }

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

