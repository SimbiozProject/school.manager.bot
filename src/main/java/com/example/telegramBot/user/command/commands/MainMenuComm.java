package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;

import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import com.example.web.bean.StatisticUser;
import com.example.web.dao.service.StatisticUserService;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;



public class MainMenuComm implements Command {

    private final UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public final static String MAIN_MENU_MESSAGE = "Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом!";
    private final ReplyKeyboard mainMenuKeyboard = userInlineKeyboardSource.getMainMenuKeyboard();

    private final SendBotMessageService sendBotMessageService;
    private final StatisticUserService statisticUserService;

    public MainMenuComm(SendBotMessageService sendBotMessageService, StatisticUserService statisticUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.statisticUserService = statisticUserService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();
        statisticUserService.findByChatId(chatId).ifPresentOrElse(
                user -> {user.setActive(true);
                statisticUserService.save(user);
                },
                () -> {
                    StatisticUser statisticUser = new StatisticUser();
                    statisticUser.setActive(true);
                    statisticUser.setChatId(chatId);
                    statisticUserService.save(statisticUser);
                }
        );

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), MAIN_MENU_MESSAGE, mainMenuKeyboard);


    }
}
