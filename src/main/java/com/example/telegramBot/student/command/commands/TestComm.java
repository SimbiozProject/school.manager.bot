package com.example.telegramBot.student.command.commands;

import com.example.telegramBot.student.service.SendBotMessageService;
import com.example.telegramBot.student.keyboard.inline.StudentInlineKeyboardSource;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;

import static com.example.telegramBot.student.repositiry.TestAnswerOptions.answers;
import static com.example.telegramBot.student.repositiry.TestAnswerOptions.numberOfQuestion;
import static com.example.telegramBot.student.repositiry.TestQuestions.TEST_QUESTIONS;


public class TestComm implements Command {

    public static final String RESULT = "Тест пройден";

    private final SendBotMessageService sendBotMessageService;

    StudentInlineKeyboardSource studentInlineKeyboardSource = new StudentInlineKeyboardSource();

    public TestComm(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {

        String chatId = update.getCallbackQuery().getMessage().getChatId().toString();

        answers.add(update.getCallbackQuery().getInlineMessageId());//записываем ответы ? НО нет. Как?

        if (numberOfQuestion < 25) {

            ReplyKeyboard answers = studentInlineKeyboardSource.getAnswerOptionsInlineMarkup(numberOfQuestion);
            String question = TEST_QUESTIONS.get(numberOfQuestion);
            sendBotMessageService.sendMessage(chatId, question, answers);
            numberOfQuestion += 1;

        } else {
            //какой-то метод, который считает процент
            sendBotMessageService.sendMessage(chatId, RESULT);
        }

    }
//todo 1. добавить верям на выполение теста,
// 2. записать куда-то выбранные ответы (как?), сравнить их с базой правильных,
// 3. посчитать процент и вывести его на экран вместе с RESALT и отправить на e-mail или в бот преподавателю.
// 4. ДОбавить кнопку Reply "ВЕрнуться в гланое меню"
// (вылетает вместе с RESULT)



}
