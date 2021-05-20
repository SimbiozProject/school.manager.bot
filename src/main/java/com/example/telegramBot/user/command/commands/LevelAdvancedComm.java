package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class LevelAdvancedComm implements Command {

    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    public final InlineKeyboardMarkup returnToSelectionCourse = userInlineKeyboardSource.getBackInSelectionCourse();

    private final static String LEVEL_ADVANCED_INFORMATION = "Кому подойдет курс английского для продвинутых?" +
        " \n 1. Ваш  уровень где-то между А1 и С2" +
        " \n 2. Вы устали от говорить об одном и том же" +
        " \n 3. Зависимы от переводчиков";

    public LevelAdvancedComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, LEVEL_ADVANCED_INFORMATION, returnToSelectionCourse);

    }
}
