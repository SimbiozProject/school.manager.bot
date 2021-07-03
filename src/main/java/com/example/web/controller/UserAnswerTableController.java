package com.example.web.controller;

import com.example.web.dao.service.UserAnswerTableDaoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAnswerTableController {

    @Autowired
    private UserAnswerTableDaoWebService userAnswerTableDaoWebService;

    @GetMapping(value = "/allUsersTest")
    public ModelAndView getAllUserTest() {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerTableDaoWebService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/searchUserName")
    public ModelAndView searchByUserName(@ModelAttribute(name = "userName") String userName) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerTableDaoWebService.findByUserName(userName));
        return modelAndView;
    }

    @GetMapping(value = "/searchId")
    public ModelAndView searchById(@ModelAttribute(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listUserAnswerTable", userAnswerTableDaoWebService.findById(id));
        return modelAndView;
    }
}
