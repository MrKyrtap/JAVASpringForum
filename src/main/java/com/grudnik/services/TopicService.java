package com.grudnik.services;

import com.grudnik.entities.Category;
import com.grudnik.entities.Post;
import com.grudnik.entities.Topic;
import com.grudnik.entities.User;
import com.grudnik.repo.CategoryRepository;
import com.grudnik.repo.PostRepository;
import com.grudnik.repo.TopicRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by PatrykGrudnik on 16/04/2017.
 */
@Service
public class TopicService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;
    private final CategoryRepository categoryRepository ;
    private final PostService postService ;


    public TopicService(PostRepository postRepository, UserRepository userRepository, TopicRepository topicRepository, CategoryRepository categoryRepository, PostService postService) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
        this.categoryRepository = categoryRepository;
        this.postService = postService;
    }

    public List<Post> getAllPosts(int id){
        return postRepository.findByTopicId(id);

    }
    public int addNewTopic(String author, String topic, String text, String catid){

            Topic newt = new Topic();
        User user = userRepository.findByMail(author);
        Category cat = categoryRepository.findOne(Integer.parseInt(catid));
        Date date = new Date();
        newt.setName(topic);
        newt.setAuthor(user);
        newt.setDate(date);
        newt.setCategory(cat);
        topicRepository.save(newt);
        postService.addPost(date,author,text,newt.getId()+"");
        return  newt.getId();

    }
}
