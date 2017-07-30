package com.grudnik.controllers;

import com.grudnik.dto.ProfileDTO;
import com.grudnik.services.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 30/07/2017.
 */
@Controller
@RequestMapping(value = "profile")
public class ProfileController {
    private final ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/show/{id}")
    public String showProfile(Model model, @PathVariable int id) {
        ProfileDTO p = profileService.getProfileDetails(id);
        model.addAttribute("profile", p);
        return "profile";
    }

}
