package com.grudnik.controllers;

import com.grudnik.entities.User;
import com.grudnik.repo.UserRepository;
import com.grudnik.services.PostService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
    @RequestMapping(value = "post/edit/{id}", method = RequestMethod.GET)
    public String editPost(Model model, HttpServletRequest request, @PathVariable("id") int id) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String author = auth.getName();
        String text = postService.getText(id);
        if(postService.editPost(id,author)){
            model.addAttribute("text",text);
            model.addAttribute("id",id);
            return "reply";
        }else{
            model.addAttribute("message", new String("Not your post!"));
            return "message" ;
        }
    }
    @RequestMapping(value = "post/edit/save", method = RequestMethod.POST)
    public String saveEdited(Model model, HttpServletRequest request) {
        int postid = Integer.parseInt(request.getParameter("postid"));
        String text = request.getParameter("text");

        return "redirect:" + new String("/topic/"+postService.saveEdited(text, postid));
    }

    @RequestMapping (value = "post/delete", method = RequestMethod.POST)
        public String deletePost(Model model, HttpServletRequest request){
            int postid = Integer.parseInt(request.getParameter("postid"));
            int topicid =  postService.deletePost(postid);
            return "redirect:" + new String("/topic/" + topicid);
    }
}
