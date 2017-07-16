package com.grudnik.controllers;

import com.grudnik.services.CategoryService;
import com.grudnik.services.IndexService;
import com.grudnik.services.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PatrykGrudnik on 18/06/2017.
 */
@Controller
public class AdminController {
    private final UserService userService;
    private final IndexService indexService;
    private final CategoryService categoryService;

    public AdminController(UserService userService, IndexService indexService, CategoryService categoryService) {
        this.userService = userService;
        this.indexService = indexService;
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/admin/users")
    public String showUsers(Model model) {
        model.addAttribute("page", "users");
        model.addAttribute("users", userService.getAllUsers());

        return "admin";
    }

    @RequestMapping(value = "/admin/category")
    public String showCategories(Model model) {
        model.addAttribute("page", "category");
        model.addAttribute("categories", indexService.getCategory());

        return "admin";
    }

    @RequestMapping(value = "/admin/editmaincategory/{category}")
    public String editMainCategory(Model model, @PathVariable String category, HttpServletRequest request) {
        String newname = request.getParameter("categoryname");
        indexService.renameMainCategory(category, newname);
        model.addAttribute("page", "category");
        model.addAttribute("categories", indexService.getCategory());

        return "redirect:" + new String("/admin/category");
    }

    @RequestMapping(value = "/admin/editcategory/{category}")
    public String editCategory(Model model, @PathVariable String category, HttpServletRequest request) {
        String newname = request.getParameter("categoryname");
        indexService.renameCategory(category, newname);
        model.addAttribute("page", "category");
        model.addAttribute("categories", indexService.getCategory());
        return "redirect:" + new String("/admin/category");
    }

    @RequestMapping(value = "/admin/addcategory")
    public String addCategory(Model model, HttpServletRequest request) {
        Integer maincat = Integer.valueOf(request.getParameter("maincatid"));
        String catToAdd = request.getParameter("categoryname");
        categoryService.add(maincat, catToAdd);
        return "redirect:" + new String("/admin/category");
    }

}
