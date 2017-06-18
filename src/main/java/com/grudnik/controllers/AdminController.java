package com.grudnik.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 18/06/2017.
 */
@Controller
public class AdminController {
    @RequestMapping(value = "/admin")
    public String admin(){
        return "admin";
    }
}
