package com.example.web.controller;

import com.example.web.dao.service.HwFromStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherCheckHwController {

    @Autowired
    HwFromStudentService hwFromStudentService;

    @GetMapping(value = "teacherCheckHw")
    public ModelAndView testPage() {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findAll());
        return modelAndView;
    }

}
