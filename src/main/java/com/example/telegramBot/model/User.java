package com.example.telegramBot.model;

import com.example.telegramBot.bot.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = "chat_id", name = "users_unique_chatid_idx")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User extends AbstractBaseEntity {
    @Column(name = "chat_id", unique = true, nullable = false)
    @NotNull
    private Integer chatId;

    @Column(name = "name", unique = true, nullable = false)
    @NotBlank
    private String name;

    @Column(name = "score", nullable = false)
    @NotNull
    private Integer score;

    @Column(name = "high_score", nullable = false)
    @NotNull
    private Integer highScore;

    @Column(name = "bot_state", nullable = false)
    @NotBlank
    private State botState;

    public User(int chatId){
        this.chatId = chatId;
        this.name = String.valueOf(chatId);
        this.score = 0;
        this.highScore = 0;
        this.botState = State.START;
    }
}
