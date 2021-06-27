package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.web.dao.service.StatisticUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopComm implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final StatisticUserService statisticUserService;


    public StopComm(SendBotMessageService sendBotMessageService, StatisticUserService statisticUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.statisticUserService = statisticUserService;
    }

    public static final String STOP_MESSAGE = "Использование бота приостановлено \uD83D\uDE1F.";

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
        statisticUserService.findByChatId(update.getMessage().getChatId())
                .ifPresent(it -> {
                    it.setActive(false);
                    statisticUserService.save(it);
                });

    }
}
