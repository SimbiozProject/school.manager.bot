package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

public class FinishSendComm implements Command{
    private final SendBotMessageService sendBotMessageService;
    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();
    public final static String FINISH_SEND_MESSAGE = "Спасибо, результаты вашего теста отправлены преподавателю." +
            " \nСкоро с вами свяжутся для прохождения аудирования." +
            " \nНажмите кнопку вернуться в главное меню";
    public final InlineKeyboardMarkup finishAndSend = userInlineKeyboardSource.getFinishAndSend();

    public FinishSendComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        sendBotMessageService.sendMessage(chatId, FINISH_SEND_MESSAGE);
    }
}
