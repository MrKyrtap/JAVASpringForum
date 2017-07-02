package com.grudnik.controllers;

import com.grudnik.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 18/06/2017.
 */
@Controller
public class AdminController {
    private final UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin";
    }

    @RequestMapping(value = "/admin/users")
    public String showUsers(Model model){
        model.addAttribute("page","users");
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }
    @RequestMapping(value = "/admin/category")
    public String showCategories(Model model){
        model.addAttribute("page","category");

        return "admin";
    }
}
