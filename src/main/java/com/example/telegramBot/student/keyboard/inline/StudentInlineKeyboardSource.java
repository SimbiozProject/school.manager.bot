package com.example.telegramBot.student.keyboard.inline;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class StudentInlineKeyboardSource {

    public StudentInlineKeyboardSource() {
    }

    public InlineKeyboardMarkup getHomeWorkKeyboard() {

        final InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstButton = new InlineKeyboardButton().setText("Получить\n" +  "домашку").setCallbackData("homework.request");
        InlineKeyboardButton secondButton = new InlineKeyboardButton().setText("Отправить\n" + "домашку").setCallbackData("homework.sent");


        List<InlineKeyboardButton> firstKeyboard = new ArrayList<>();
        firstKeyboard.add(firstButton);
        List<InlineKeyboardButton> secondKeyboard = new ArrayList<>();
        secondKeyboard.add(secondButton);
      
        List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(firstKeyboard);
        keyboardRows.add(secondKeyboard);
      
        inlineKeyboardMarkup.setKeyboard(keyboardRows);

        return inlineKeyboardMarkup;
    }
    
          
    public InlineKeyboardMarkup getStudentMenuKeyboard() {

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstButton = new InlineKeyboardButton().setText("Мое расписание").setCallbackData("schedule");
        InlineKeyboardButton secondButton = new InlineKeyboardButton().setText("Домашнее задание").setCallbackData("homework");
        InlineKeyboardButton thirdButton = new InlineKeyboardButton().setText("Комьюнити").setCallbackData("community");
        InlineKeyboardButton fourthButton = new InlineKeyboardButton().setText("Оплата").setCallbackData("pay");    
      
        List<InlineKeyboardButton> firstKeyboard = new ArrayList<>();
        firstKeyboard.add(firstButton);
        List<InlineKeyboardButton> secondKeyboard = new ArrayList<>();
        secondKeyboard.add(secondButton);
        List<InlineKeyboardButton> thirdKeyboard = new ArrayList<>();
        thirdKeyboard.add(thirdButton);
        List<InlineKeyboardButton> fourthKeyboard = new ArrayList<>();
        fourthKeyboard.add(fourthButton);
      
         List<List<InlineKeyboardButton>> keyboardRows = new ArrayList<>();
        keyboardRows.add(firstKeyboard);
        keyboardRows.add(secondKeyboard);
        keyboardRows.add(thirdKeyboard);
        keyboardRows.add(fourthKeyboard);

        inlineKeyboardMarkup.setKeyboard(keyboardRows);

        return inlineKeyboardMarkup;
    }
     


    public InlineKeyboardMarkup getSchedule() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        InlineKeyboardButton firstButton = new InlineKeyboardButton().setText("Писоединитсья в Zoom").setCallbackData("zoom");
        InlineKeyboardButton secondButton = new InlineKeyboardButton()
                .setText("Посмотреть все расписание")
                .setUrl("https://calendar.google.com/calendar/u/0?cid=dHJpYWwuZW5nbGlzaC5zY2hvb2xAZ21haWwuY29t");
        List<InlineKeyboardButton> firstButtonRow = new ArrayList<>();
        firstButtonRow.add(firstButton);
        List<InlineKeyboardButton> secondButtonRow = new ArrayList<>();
        secondButtonRow.add(secondButton);

        List<List<InlineKeyboardButton>> keyboardRow = new ArrayList<>();
        keyboardRow.add(firstButtonRow);
        keyboardRow.add(secondButtonRow);

        inlineKeyboardMarkup.setKeyboard(keyboardRow);

        return inlineKeyboardMarkup;
    }


    public InlineKeyboardMarkup getCommunity() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton firstButton = new InlineKeyboardButton()
                .setText("Комьюнити")
                .setUrl("https://t.me/Jis6");

        List<InlineKeyboardButton> firstButtonRow = new ArrayList<>();
        firstButtonRow.add(firstButton);

        List<List<InlineKeyboardButton>> keyboardRow = new ArrayList<>();
        keyboardRow.add(firstButtonRow);
        inlineKeyboardMarkup.setKeyboard(keyboardRow);
        return inlineKeyboardMarkup;
    }


    public InlineKeyboardMarkup getZoom() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        InlineKeyboardButton firstButton = new InlineKeyboardButton()
                .setText("zoom")
                .setUrl("https://us05web.zoom.us/meeting/tZctdumorj0uG9JVmov_cjNUObX_hLF5PV20/ics?icsToken=98tyKuGrrjoqGtSTtBiBRpwqAoj4c_TziCFbjfp3qhLqFR9QaC3DGeB6DbpTNo3g");
        List<InlineKeyboardButton> firstButtonRow = new ArrayList<>();
        firstButtonRow.add(firstButton);
        List<List<InlineKeyboardButton>> keyboardRow = new ArrayList<>();
        keyboardRow.add(firstButtonRow);
        inlineKeyboardMarkup.setKeyboard(keyboardRow);
        return inlineKeyboardMarkup;
    }

}


