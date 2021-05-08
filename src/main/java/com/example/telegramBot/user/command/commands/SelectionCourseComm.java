package com.example.telegramBot.user.command.commands;


import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import com.example.telegramBot.user.keyboard.reply.UserReplyKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

public class SelectionCourseComm implements Command {

    private final UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    private final UserReplyKeyboardSource userReplyKeyboardSource = new UserReplyKeyboardSource();
    private final static String MENU_MESSAGE_SELECTION_COURSE = "Выберите курс, который хотите приобрести";
    private final static String MENU_MESSAGE_COURSE_ZERO = "Инфо о курсе для новичков, можно найти нажав на кнопку Level 0";
    private final static String MENU_MESSAGE_COURSE_ADVANCED = "Инфо о курсе для ПРОДВИНУТЫХ, можно найти нажав на кнопку Level advanced";
    private final ReplyKeyboard selectionCourseMenuLevelZero = userInlineKeyboardSource.getSelectCourseBoardLevelZero();
    private final ReplyKeyboard selectionCourseMenuLevelAdvanced = userInlineKeyboardSource.getSelectCourseBoardLevelAdvanced();

    public final ReplyKeyboard returnToMainMenu = userReplyKeyboardSource.getReturnToMainMenu();

    private final SendBotMessageService sendBotMessageService;

    public SelectionCourseComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        sendBotMessageService.sendMessage(update.getCallbackQuery().getMessage().getChatId().toString(), MENU_MESSAGE_SELECTION_COURSE, returnToMainMenu);
        sendBotMessageService.sendMessage(update.getCallbackQuery().getMessage().getChatId().toString(), MENU_MESSAGE_COURSE_ZERO, selectionCourseMenuLevelZero);
        sendBotMessageService.sendMessage(update.getCallbackQuery().getMessage().getChatId().toString(), MENU_MESSAGE_COURSE_ADVANCED, selectionCourseMenuLevelAdvanced);


    }


}
