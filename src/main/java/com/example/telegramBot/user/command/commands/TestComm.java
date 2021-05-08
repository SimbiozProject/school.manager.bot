package com.example.telegramBot.user.command.commands;

import com.example.telegramBot.service.SendBotMessageService;
import com.example.telegramBot.user.keyboard.inline.UserInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static com.example.telegramBot.user.repositiry.TestAnswerOptions.answers;
import static com.example.telegramBot.user.repositiry.TestAnswerOptions.numberOfQuestion;
import static com.example.telegramBot.user.repositiry.TestCorrectAnswers.ANSWERS_ON_QUESTIONS;
import static com.example.telegramBot.user.repositiry.TestQuestions.TEST_QUESTIONS;


public class TestComm implements Command {

    private final SendBotMessageService sendBotMessageService;


    UserInlineKeyboardSource userInlineKeyboardSource = new UserInlineKeyboardSource();

    public TestComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();
        Integer message_id = update.getCallbackQuery().getMessage().getMessageId();

        if (numberOfQuestion > 0) {
            sendBotMessageService.deleteMessage(chatId, message_id);
        }


        addTheAnswerIntoList(update);

        if (numberOfQuestion < TEST_QUESTIONS.size()) {
            createAndSendNextQuestion(chatId);
        } else {
            createAndSendResult(chatId);
        }

    }

    private void createAndSendNextQuestion(String chatId) {
        ReplyKeyboard answers = userInlineKeyboardSource.getAnswerOptionsInlineMarkup(numberOfQuestion);
        String question = TEST_QUESTIONS.get(numberOfQuestion);
        sendBotMessageService.sendMessage(chatId, question, answers);
        numberOfQuestion++;
    }

    private void createAndSendResult(String chatId) {
        int count = 0;
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).equals(ANSWERS_ON_QUESTIONS.get(i))) {
                count++;
            }
        }
        int result = count * 100 / TEST_QUESTIONS.size();
        sendBotMessageService.sendMessage(chatId, String.format("Тест пройден. Ваш результат %d %%", result));
    }

    private void addTheAnswerIntoList(Update update) {
        if (update.getCallbackQuery().getData().startsWith("english")) {
            answers.add(update.getCallbackQuery().getData().replace("english", ""));
        }
    }


//todo
// 1. добавить верям на выполение теста,
// 2. записать куда-то выбранные ответы, сравнить их с базой правильных - выполнено, но без БД.
// 3. посчитать процент и вывести его на экран вместе с RESALT - выполнено
// 4. отправить на e-mail
// 5. отправить в бот преподавателю.
// 6. добавить кнопку Reply "Вернуться в гланое меню" (вылетает вместе с RESULT)
// 7. убрать баг когда можно нажать на ответ из другого вопоса - выполнено (предыдущие исчезают)
// 8. отредактировать правильные ответы - выполнено


}
