package com.example.demo;



import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;


import java.util.ArrayList;
import java.util.List;


public class GetContact {

    public ReplyKeyboard takePhoneNumber(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            long chat_id = update.getMessage().getChatId();

            if (update.getMessage().getText().equals("/start")) {
                SendMessage sendMessage = new SendMessage()
                        .setChatId(chat_id)
                        .setText("Здравствуйте, если вы это читаете значит вы решили выучить английски, а мы, WorldLand, поможем Вам в этом");

            }

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);

            List<KeyboardRow> keyboard = new ArrayList<>();

            KeyboardRow takePhoneNumberRow = new KeyboardRow();
            takePhoneNumberRow.add(new KeyboardButton("Поделиться своим номером телефона").setRequestContact(true));
            keyboard.add(takePhoneNumberRow);
            replyKeyboardMarkup.setKeyboard(keyboard);
            return replyKeyboardMarkup;
        }

        return null;

    }
}
