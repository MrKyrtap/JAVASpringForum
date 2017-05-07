package com.grudnik.controllers;

import com.grudnik.entities.User;
import com.grudnik.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by PatrykGrudnik on 06/05/2017.
 */
@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String register(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String createNewUser(Model model, @Valid User user, BindingResult bindingResult) {

        User userExists = userService.findUserByEmail(user.getMail());
        User userExistsName = userService.findUserByName(user.getName());
        if (userExists != null) {
            bindingResult
                    .rejectValue("mail", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (userExistsName != null) {
            bindingResult
                    .rejectValue("name", "error.user",
                            "There is already a user registered with the name provided");
        }
        if (bindingResult.hasErrors()) {

        } else {
            userService.saveUser(user);
            model.addAttribute("successMessage", "User has been registered successfully");
         //   model.addAttribute("user", new User());


        }
        return "registration";
    }
}
