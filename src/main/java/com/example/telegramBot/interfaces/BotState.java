package com.example.telegramBot.interfaces;

import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public interface BotState<E extends Enum<E>, T> {
    /*public void handleInput(T t);
    public void handleCallbackQuery(T t);
    public void handleContact(T t);
    public void handlePhoto(T t);
    public void handleVoice(T t);
    public void handleVideo(T t);
    public void handleVideoNote(T t);
    public void handleDocument(T t);*/

    public abstract void enter(T t) throws TelegramApiException;
    public abstract E nextState();
}
