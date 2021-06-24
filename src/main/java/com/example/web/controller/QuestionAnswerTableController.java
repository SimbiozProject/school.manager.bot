package com.example.web.controller;

import com.example.web.bean.QuestionAnswerTable;
import com.example.web.dao.repository.QuestionAnswerTableRepository;
import com.example.web.dao.service.QuestionAnswerTableDaoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuestionAnswerTableController {

    @Autowired
    QuestionAnswerTableDaoWebService questionAnswerTableDaoWebService;

    @GetMapping(value = "test")
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testList", questionAnswerTableDaoWebService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "addTest")
    public ModelAndView addTestPage() {
        ModelAndView modelAndView = new ModelAndView("/addTest");
        return modelAndView;
    }

    @PostMapping(value = "addTest")
    public ModelAndView addTest(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "firstAnswer", required = false) String firstAnswer,
                                @RequestParam(value = "secondAnswer", required = false) String secondAnswer,
                                @RequestParam(value = "thirdAnswer", required = false) String thirdAnswer,
                                @RequestParam(value = "fourthAnswer", required = false) String fourthAnswer,
                                @RequestParam(value = "rightAnswer", required = false) String rightAnswer) {
    ModelAndView modelAndView = new ModelAndView("/addTest");
        QuestionAnswerTable newQuestion = QuestionAnswerTable.builder()
                .question(question)
                .firstAnswer(firstAnswer)
                .secondAnswer(secondAnswer)
                .thirdAnswer(thirdAnswer)
                .fourthAnswer(fourthAnswer)
                .rightAnswer(rightAnswer)
                .build();
        questionAnswerTableDaoWebService.addToDb(newQuestion);
        modelAndView.setViewName("redirect:/test");
        return modelAndView;

    }

}
