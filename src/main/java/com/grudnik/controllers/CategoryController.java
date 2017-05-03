package com.grudnik.controllers;

import com.grudnik.entities.Topic;
import com.grudnik.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by PatrykGrudnik on 14/04/2017.
 */
@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping(value = "/category/{name}-{id}")
    public String index(Model model, @PathVariable("name") String name, @PathVariable("id") int id) {
        List<Topic> topics = categoryService.getAllTopics(id);
        model.addAttribute("name", name);
        model.addAttribute("id", id);
        model.addAttribute("topics", topics);
        return "category";
    }

    @RequestMapping(value = "/category/newtopic/{id}")
    public String newtopic(Model model, @PathVariable("id") int id) {
        List<Topic> topics = categoryService.getAllTopics(id);

        model.addAttribute("id", id);
        model.addAttribute("topics", topics);
        return "newtopic";
    }

}
