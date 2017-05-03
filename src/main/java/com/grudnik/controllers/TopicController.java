package com.grudnik.controllers;

import com.grudnik.entities.Post;
import com.grudnik.services.TopicService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by PatrykGrudnik on 16/04/2017.
 */
@Controller
public class TopicController {
    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "topic/{id}")
    public String index(Model model, @PathVariable("id") int id) {
        List<Post> posts = topicService.getAllPosts(id);
        model.addAttribute("posts", posts);
        model.addAttribute("id", id);
        return "topic";
    }
    @RequestMapping(value = "topic/new", method = RequestMethod.POST)
    public String newtopic(Model model, HttpServletRequest request){
        String txt = request.getParameter("text");
        String topic = request.getParameter("topic");
        String catid = request.getParameter("catid");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String author = auth.getName();
        int x  = topicService.addNewTopic(author,topic,txt, catid);
        return "redirect:" + new String("/topic/"+x);
    }
}
