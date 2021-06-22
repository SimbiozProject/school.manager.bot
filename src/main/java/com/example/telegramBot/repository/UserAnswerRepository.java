package com.example.telegramBot.repository;

import com.example.telegramBot.bean.UserAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswerTable, Long> {
}
