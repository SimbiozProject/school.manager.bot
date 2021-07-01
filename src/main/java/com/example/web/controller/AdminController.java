package com.example.web.controller;

import com.example.web.bean.CourseTable;
import com.example.web.bean.GroupTable;
import com.example.web.bean.TgUserTable;
import com.example.web.bean.UserRoles;
import com.example.web.dao.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Date;
import java.util.List;

@Controller
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping(value = "admin")
    public ModelAndView adminPage(){
        ModelAndView modelAndView = new ModelAndView("/admin.html");
        return modelAndView;
    }

    @GetMapping(value = "/admin/schedule")
    public ModelAndView schedulePage(){
        ModelAndView modelAndView = new ModelAndView("/schedule.html");
        return modelAndView;
    }

    @GetMapping(value = "/admin/userBlock")
    public ModelAndView blackListPage(){
        ModelAndView modelAndView = new ModelAndView("/userBlock.html");
        modelAndView.addObject("listBlockUser", adminService.findAllBlockUser());
        return modelAndView;
    }

    @GetMapping(value = "/searchUserForBlock")
    public ModelAndView searchUserForBlock(@ModelAttribute(name = "userName") String userName){
        ModelAndView modelAndView = new ModelAndView("/listUsersForBlock.html");
        modelAndView.addObject("searchForBlockUser", adminService.searchTgUserForBlockList(userName));
        return modelAndView;
    }



    @GetMapping(value = "deleteBlockUser" + "/{id}")
    public ModelAndView deleteTgUserById(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers.html");
        modelAndView.addObject("blockUserDel", adminService.findBlockUserById(id));
        return modelAndView;
    }
    @PostMapping(value = "deleteBlockUser" + "/{id}")
    public ModelAndView deleteAndReturnToBlackList(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteBlockUsers.html");
        adminService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }

    @GetMapping(value = "updateBlockUser" + "/{id}")
    public ModelAndView updateStatusBlock(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
        modelAndView.addObject("listBlockUser", adminService.findBlockUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "updateBlockUser" + "/{id}")
    public ModelAndView updateStatusBlockUser(@PathVariable(name = "id") Long id,
                                              @RequestParam(value = "blockUser") Boolean blockUser){
        ModelAndView modelAndView = new ModelAndView("/updateBlockStatus.html");
        adminService.updateBlockStatusUser(id, blockUser);
        modelAndView.setViewName("redirect:/admin/userBlock");
        return modelAndView;
    }

    @GetMapping(value = "/admin/statistic")
    public ModelAndView findAllTgUsers(){
        ModelAndView modelAndView = new ModelAndView("/statistic.html");
        modelAndView.addObject("statisticList", adminService.findAllUsers());
        return modelAndView;
    }
    @GetMapping(value = "deleteUser" + "/{id}")
    public ModelAndView deleteUserById(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        modelAndView.addObject("listUser", adminService.findBlockUserById(id));
        return modelAndView;
    }
    @PostMapping(value = "deleteUser" + "/{id}")
    public ModelAndView deleteAndReturnToUserList(@PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("/deleteUser.html");
        adminService.deleteUserById(id);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }
    @GetMapping(value = "updateUser" + "/{id}")
    public ModelAndView updateDataUser(@PathVariable(name = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        modelAndView.addObject("listUserForUpdate", adminService.findBlockUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "updateUser" + "/{id}")
    public ModelAndView updateAllDataOfUsers(@PathVariable(name = "id") Long id,
                                              @RequestParam(value = "userName") String userName,
                                              @RequestParam(value = "firstName") String firstName,
                                             @RequestParam(value = "lastName") String lastName,
                                              @RequestParam(value = "email") String email,
                                              @RequestParam(value = "dateOfBirthday") Date dateOfBirthday,
                                              @RequestParam(value = "active") Boolean active,
                                              @RequestParam(value = "blockUser") Boolean blockUser,
                                              @RequestParam(value = "payment") Boolean payment,
                                              @RequestParam(value = "roles") UserRoles roles,
                                              @RequestParam(value = "courseUser") CourseTable courseUser,
                                              @RequestParam(value = "groupUser") GroupTable groupUser){
        ModelAndView modelAndView = new ModelAndView("/updateUserInfo.html");
        adminService.updateDataOfUser(id, userName, firstName, lastName, email, dateOfBirthday,
                active, blockUser, payment, roles, courseUser, groupUser);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }

    @GetMapping(value = "/admin/addUser")
    public ModelAndView addUserToTable(){
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        return modelAndView;
    }

    @PostMapping(value = "/admin/addUser")
    public ModelAndView addTgUserToTable(//@RequestParam(name = "id") Long id,
                                         @RequestParam(value = "userName") String userName,
                                         @RequestParam(value = "firstName") String firstName,
                                         @RequestParam(value = "lastName") String lastName,
                                         @RequestParam(value = "email") String email,
                                         @RequestParam(value = "dateOfBirthday") Date dateOfBirthday,
                                         @RequestParam(value = "active") Boolean active,
                                         @RequestParam(value = "blockUser") Boolean blockUser,
                                         @RequestParam(value = "payment") Boolean payment,
                                         @RequestParam(value = "roles") UserRoles roles,
                                         @RequestParam(value = "courseUser") CourseTable courseUser,
                                         @RequestParam(value = "groupUser") GroupTable groupUser){
        ModelAndView modelAndView = new ModelAndView("/addUser.html");
        TgUserTable newTgUser = TgUserTable.builder()
                .userName(userName)
                .firstName(firstName)
                .lastName(lastName)
                .email(email)
                .dateOfBirthday(dateOfBirthday)
                .active(active)
                .blockUser(blockUser)
                .payment(payment)
                .roles(roles)
                .courseUser(courseUser)
                .groupUser(groupUser)
                .build();
        adminService.addUserToDB(newTgUser);
        modelAndView.setViewName("redirect:/admin/statistic");
        return modelAndView;
    }

    /*
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
     */
}
