package com.example.telegramBot.user.command.commands;

import org.junit.jupiter.api.Test;

import static com.example.telegramBot.user.repositiry.TestAnswerOptions.numberOfQuestion;

class TestCommTest {

    @Test
    void increment() {
        System.out.println(numberOfQuestion);
        numberOfQuestion++;
        System.out.println(numberOfQuestion);
    }

}