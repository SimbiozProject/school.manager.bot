package com.example.telegramBot.repository;

import com.example.telegramBot.bean.QuestionAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionAnswerRepository extends JpaRepository<QuestionAnswerTable, Long> {
}
