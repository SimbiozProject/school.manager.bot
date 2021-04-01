package com.example.demo.testForWordLand;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestAnswersOnQuestions {

    ArrayList<String> answersOnQuestions = new ArrayList<>();

    public void addsAnswersOnQuestions(){
        answersOnQuestions.add(0, "is");
        answersOnQuestions.add(1, "at");
        answersOnQuestions.add(2, "some");
        answersOnQuestions.add(3, "is");
        answersOnQuestions.add(4, "at");
        answersOnQuestions.add(5, "some");
        answersOnQuestions.add(6, "is");
        answersOnQuestions.add(7, "at");
        answersOnQuestions.add(8, "some");
        answersOnQuestions.add(9, "is");
        answersOnQuestions.add(10, "at");
        answersOnQuestions.add(11, "some");
        answersOnQuestions.add(12, "is");
        answersOnQuestions.add(13, "at");
        answersOnQuestions.add(14, "some");
        answersOnQuestions.add(15, "is");
        answersOnQuestions.add(16, "at");
        answersOnQuestions.add(17, "some");
        answersOnQuestions.add(18, "is");
        answersOnQuestions.add(19, "at");
        answersOnQuestions.add(20, "some");
        answersOnQuestions.add(21, "is");
        answersOnQuestions.add(22, "at");
        answersOnQuestions.add(23, "some");
        answersOnQuestions.add(24, "some");

        answersOnQuestions.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

    }
}
