package com.example.web.controller;

import com.example.web.dao.service.TgUserTableDaoWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserAnswerTableController {

    @Autowired
    private TgUserTableDaoWebService tgUserTableDaoWebService;

    @GetMapping(value = "/allUsersTest")
    public ModelAndView getAllUserTest() {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listTgUserTable", tgUserTableDaoWebService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/searchUserName")
    public ModelAndView searchByUserName(@ModelAttribute(name = "userName") String userName) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listTgUserTable", tgUserTableDaoWebService.findByUserName(userName));
        return modelAndView;
    }
    //seaarchById=12&searchByName=Anton
    @GetMapping(value = "/searchId")
    public ModelAndView searchById(@ModelAttribute(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/allUsersTest");
        modelAndView.addObject("listTgUserTable", tgUserTableDaoWebService.findById(id));
        return modelAndView;
    }
}
