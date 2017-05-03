package com.grudnik.controllers;

import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrykGrudnik on 02/05/2017.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }


}
