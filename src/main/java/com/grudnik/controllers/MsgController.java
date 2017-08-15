package com.grudnik.controllers;

import com.grudnik.services.MsgService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 15/08/2017.
 */
@Controller
public class MsgController {
    private final MsgService msgService;

    public MsgController(MsgService msgService) {
        this.msgService = msgService;
    }

    @RequestMapping(value = "/msg")
    public String msg(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String user = auth.getName();
        model.addAttribute("who",user);
        msgService.getAllMessage(user);
        return "msg";
    }
}
