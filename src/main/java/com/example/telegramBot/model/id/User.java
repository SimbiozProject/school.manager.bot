package com.example.telegramBot.model.id;

import com.example.telegramBot.model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
