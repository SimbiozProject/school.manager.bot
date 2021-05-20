package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class LevelZeroComm implements Command {

    private final SendBotMessageService sendBotMessageService;

    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    public final InlineKeyboardMarkup returnToSelectionCourse = userInlineKeyboardSource.getBackInSelectionCourse();

    private final static String LEVEL_ZERO_INFORMATION = "Кому подойдет курс английского для начинающих?" +
        " \n 1. Уже был опыт изучения языка" +
        " \n 2. Никогда раньше не изучали английский" +
        " \n 3. Испытываете дискомфорт от незнания";

    public LevelZeroComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();

        sendBotMessageService.sendMessage(chatId, LEVEL_ZERO_INFORMATION, returnToSelectionCourse);

    }
}
