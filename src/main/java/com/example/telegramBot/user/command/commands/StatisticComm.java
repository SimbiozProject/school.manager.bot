package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.web.dao.service.StatisticUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StatisticComm implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final StatisticUserService statisticUserService;

    @Autowired
    public StatisticComm(SendBotMessageService sendBotMessageService, StatisticUserService statisticUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.statisticUserService = statisticUserService;
    }

    public final static String STATISTIC_MESSAGE = "Telegram Bot использует %s человек.";

    @Override
    public void execute(Update update) {
        int activeUserCount = statisticUserService.retrieveAllActiveUsers().size();
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), String.format(STATISTIC_MESSAGE, activeUserCount));
    }
}
