package com.example.telegramBot.util;

import com.example.telegramBot.model.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

public class TelegramUtil {

    public static SendMessage createMessageTemplate(User user){
        return createMessageTemplate(String.valueOf(user.getChatId()));
    }
    // Создаем шаблон SendMessage с включенным Markdown
    public static SendMessage createMessageTemplate(String chatId){
        return new SendMessage()
                .setChatId(chatId)
                .enableMarkdown(true);
    }
    // Создаем кнопку
    public static InlineKeyboardButton createInlineKeyboardButton(String text, String command){
        return new InlineKeyboardButton()
                .setText(text)
                .setCallbackData(command);
    }

}
