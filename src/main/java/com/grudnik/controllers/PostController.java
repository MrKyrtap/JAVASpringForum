package com.grudnik.controllers;

import com.grudnik.entities.User;
import com.grudnik.repo.UserRepository;
import com.grudnik.services.PostService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * Created by PatrykGrudnik on 03/05/2017.
 */
@Controller
public class PostController {
    private final PostService postService;
    private final UserRepository userRepository;

    public PostController(PostService postService, UserRepository userRepository) {
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "post/new", method = RequestMethod.POST)
    public String addNewPost(Model model, HttpServletRequest request) {
        String topicid = request.getParameter("topicid");
        String text = request.getParameter("text");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String author = auth.getName();
        postService.addPost(new Date(), author, text, topicid);
        return "redirect:" + new String("/topic/" + topicid);
    }
}
