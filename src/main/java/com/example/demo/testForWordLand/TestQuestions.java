package com.example.demo.testForWordLand;

import java.util.ArrayList;
import java.util.function.Consumer;

public class TestQuestions {

    ArrayList<String> questionsForTest = new ArrayList<>();

    public void addsQuestionsToTest(){
        questionsForTest.add(0, "1. My favorite color _____ green.");
        questionsForTest.add(1, "2. We get up _____ 7 o’clock.");
        questionsForTest.add(2, "3. There is _____ milk in the fridge.");
        questionsForTest.add(3, "4. Are you _____ Italy?");
        questionsForTest.add(4, "5. London is the _____ of England.");
        questionsForTest.add(5, "6. Last Sunday I _____ football with my friends.");
        questionsForTest.add(6, "7. This is _____ film I have ever seen.");
        questionsForTest.add(7, "8. _____ I have a ticket to London? ");
        questionsForTest.add(8, "9. How _____ friends do you have?");
        questionsForTest.add(9, "10. Excuse me, _____ my hat.");
        questionsForTest.add(10, "11. _____ elephants are very beautiful animals.");
        questionsForTest.add(11, "12. How about going to the cinema? _____ ");
        questionsForTest.add(12, "13. She is a woman _____ helped me with a job.");
        questionsForTest.add(13, "14. They _____ me they would come the next day. ");
        questionsForTest.add(14, "15. I hate _____ up early in the morning.");
        questionsForTest.add(15, "16. If I were you, I _____ buy this car.");
        questionsForTest.add(16, "17. He didn’t go to school, _____ ");
        questionsForTest.add(17, "18. It’s not a good idea to leave electrical appliance _____ standby.");
        questionsForTest.add(18, "19. When I want to relax I put my feet _____ ");
        questionsForTest.add(19, "20. They are usually punished for _____ a teacher. ");
        questionsForTest.add(20, "21. I _____ her since we were teenagers.");
        questionsForTest.add(21, "22. _____ we came, train had already departed.");
        questionsForTest.add(22, "23. I remember _____ him at work and he was tired.");
        questionsForTest.add(23, "24. You _____ Jack in the gym, because he had gone to France.");
        questionsForTest.add(24, "25. I was frustrated at not having news _____ the interview I had had before.");


            questionsForTest.forEach(new Consumer<String>() {
                @Override
                public void accept(String s) {
                    System.out.println(s);
                }
            });
        }

}
