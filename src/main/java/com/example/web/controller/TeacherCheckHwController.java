package com.example.web.controller;

import com.example.web.dao.service.HwFromStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherCheckHwController {

    @Autowired
    HwFromStudentService hwFromStudentService;

    @GetMapping(value = "teacherCheckHw")
    public ModelAndView checkingHwPage() {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "deleteHwFromStudent" + "/{id}")
    public ModelAndView deleteHwFrom(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteHwFromStudent");
        modelAndView.addObject("hw", hwFromStudentService.findById(id));
        return modelAndView;
    }

    @PostMapping(value = "deleteHwFromStudent" + "/{id}")
    public ModelAndView deleteHw(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteHwFromStudent");
        hwFromStudentService.deleteById(id);
        modelAndView.setViewName("redirect:/teacherCheckHw");
        return modelAndView;
    }

    @GetMapping(value = "searchFirstname")
    public ModelAndView searchFirstname(@ModelAttribute(name = "firstname") String name) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByFirstName(name));
        return modelAndView;
    }

    @GetMapping(value = "searchLastname")
    public ModelAndView searchLastName(@ModelAttribute(name = "lastname") String name) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByLastName(name));
        return modelAndView;
    }


    @GetMapping(value = "searchLesson")
    public ModelAndView searchLesson(@ModelAttribute(name = "lesson") Integer lesson) {
        ModelAndView modelAndView = new ModelAndView("/teacherCheckHw");
        modelAndView.addObject("hwFromStudentList", hwFromStudentService.findByLesson(lesson));
        return modelAndView;
    }

}
