package com.example.telegramBot.model.id;

import com.example.telegramBot.model.enums.Role;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

public class User {

    private Integer id;

    private Long chatId;

    private String firstname;

    private String lastname;

    private String username;

    private Role role;

    private Integer botLastMessageId;

    private Integer botLastMessageDate;

    private Boolean botLastMessageEditable;

    private Boolean banned;

    private Integer currentPage;

    public Boolean hasLastBotMessage() {
        return botLastMessageId != null;
    }

}
