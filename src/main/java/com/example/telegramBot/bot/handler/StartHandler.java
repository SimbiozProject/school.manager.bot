package com.example.telegramBot.bot.handler;

import com.example.telegramBot.model.User;
import com.example.telegramBot.repository.JpaUserRepository;
import com.example.telegramBot.bot.State;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.PartialBotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static com.example.telegramBot.util.TelegramUtil.createMessageTemplate;


@Component
public class StartHandler implements Handler {
    @Value("${bot.name}")
    private String botUsername;

    private final JpaUserRepository userRepository;

    public StartHandler(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<PartialBotApiMethod<? extends Serializable>> handle(User user, String message) {
        // Приветствуем пользователя
        SendMessage welcomeMessage = createMessageTemplate(user)
                .setText(String.format(
                        "Hola! I'm *%s*%nI am here to help you learn English", botUsername
                ));
        // Asking to input name
        SendMessage registrationMessage = createMessageTemplate(user)
                .setText("In order to start our journey tell me your name");
        user.setBotState(State.ENTER_NAME);
        userRepository.save(user);

        return List.of(welcomeMessage, registrationMessage);
    }

    @Override
    public State operatedBotState() {
        return State.START;
    }

    @Override
    public List<String> operatedCallBackQuery() {
        return Collections.emptyList();
    }
}
