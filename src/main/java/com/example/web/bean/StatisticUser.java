package com.example.web.bean;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "statistic_user")
public class StatisticUser {
    @Id
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "active")
    private boolean active;


}
