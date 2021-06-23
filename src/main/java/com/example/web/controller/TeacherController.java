package com.example.web.controller;

import com.example.web.repository.QuestionAnswerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "/")
public class TeacherController {




    @GetMapping(value = "teacher")
    public ModelAndView teacherPage(){
        ModelAndView modelAndView = new ModelAndView("/teacher");
        return modelAndView;
    }



}
