package com.example.telegramBot.repository;

import com.example.telegramBot.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)

public interface JpaQuestionRepository extends JpaRepository<Question, Integer>{
    // А здесь мы написали SQL Query, которая будет выбирать 1 случайный вопрос из таблицы вопросов
    @Query(nativeQuery = true, value = "SELECT *  FROM english_quiz ORDER BY random() LIMIT 1")
    Question getQuestion();
}
//ORDER BY random() LIMIT 1
