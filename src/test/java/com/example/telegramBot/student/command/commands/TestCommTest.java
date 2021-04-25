package com.example.telegramBot.student.command.commands;

import org.junit.jupiter.api.Test;

import static com.example.telegramBot.student.repositiry.TestAnswerOptions.numberOfQuestion;

class TestCommTest {

    @Test
    void increment() {
        System.out.println(numberOfQuestion);
        numberOfQuestion++;
        System.out.println(numberOfQuestion);
    }

}