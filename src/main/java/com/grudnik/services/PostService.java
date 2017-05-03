package com.grudnik.services;

import com.grudnik.entities.Post;
import com.grudnik.entities.Topic;
import com.grudnik.entities.User;
import com.grudnik.repo.PostRepository;
import com.grudnik.repo.TopicRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by PatrykGrudnik on 03/05/2017.
 */
@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final TopicRepository topicRepository;


    public PostService(PostRepository postRepository, UserRepository userRepository, TopicRepository topicRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.topicRepository = topicRepository;
    }

    public void addPost(Date date, String usermail, String text, String topic){
        Post post = new Post();
        User user = userRepository.findByMail(usermail);
        Topic t = topicRepository.findOne(Integer.parseInt(topic));
        post.setDate(date);
        post.setAutor(user);
        post.setText(text);
        post.setTopic(t);

        postRepository.save(post);




    }
}
