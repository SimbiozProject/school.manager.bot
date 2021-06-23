package com.example.web.controller;

import com.example.web.repository.QuestionAnswerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @Autowired
    QuestionAnswerTableRepository questionAnswerTableRepository;

    @GetMapping(value = "test")
    public ModelAndView testPage(){
        ModelAndView modelAndView = new ModelAndView("/test");
        modelAndView.addObject("testList", questionAnswerTableRepository.findAll());
        return modelAndView;
    }

}
