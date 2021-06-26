package com.example.web.controller;

import com.example.web.bean.QuestionAnswerTable;

import com.example.web.dao.service.QuestionAnswerTableDaoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class
QuestionAnswerTableController {

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
    public ModelAndView addTest(@RequestParam(value = "question") String question,
                                @RequestParam(value = "firstAnswer") String firstAnswer,
                                @RequestParam(value = "secondAnswer") String secondAnswer,
                                @RequestParam(value = "thirdAnswer") String thirdAnswer,
                                @RequestParam(value = "fourthAnswer") String fourthAnswer,
                                @RequestParam(value = "rightAnswer") String rightAnswer) {
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

    @GetMapping(value = "update" + "/{id}")
    public ModelAndView updateTestPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        modelAndView.addObject("testList", questionAnswerTableDaoWebService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "update" + "/{id}")
    public ModelAndView updateTest(@PathVariable(name = "id") Long id,
                                   @RequestParam(value = "question") String question,
                                   @RequestParam(value = "firstAnswer") String firstAnswer,
                                   @RequestParam(value = "secondAnswer") String secondAnswer,
                                   @RequestParam(value = "thirdAnswer") String thirdAnswer,
                                   @RequestParam(value = "fourthAnswer") String fourthAnswer,
                                   @RequestParam(value = "rightAnswer") String rightAnswer) {
        ModelAndView modelAndView = new ModelAndView("/updateTest");
        questionAnswerTableDaoWebService.updateDataInTest(id, question, firstAnswer, secondAnswer, thirdAnswer,
                fourthAnswer, rightAnswer);
        modelAndView.setViewName("redirect:/test");
        return modelAndView;

    }

    @GetMapping(value = "delete" + "/{id}")
    public ModelAndView deleteTestPage(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteTest");
        modelAndView.addObject("test", questionAnswerTableDaoWebService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "delete" + "/{id}")
    public ModelAndView deleteTest(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteTest");
        questionAnswerTableDaoWebService.deleteById(id);
        modelAndView.setViewName("redirect:/test");
        return modelAndView;
    }
}
