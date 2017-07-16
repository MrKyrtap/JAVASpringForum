package com.grudnik.controllers;

import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import com.grudnik.services.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrykGrudnik on 08/04/2017.
 */
@Controller
public class IndexController {

   private final IndexService indexService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(value = "/")
    public String index(Model model){

        HashMap<MainCategory, List<Category>> categories = indexService.getCategory();
        List<MainCategory> maincategories = indexService.getMainCategory();

        model.addAttribute("categories",categories);
        model.addAttribute("maincategories",maincategories);


        return "index";
    }



}
