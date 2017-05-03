package com.grudnik.services;

import com.grudnik.entities.Post;
import com.grudnik.entities.Topic;
import com.grudnik.entities.User;
import com.grudnik.repo.PostRepository;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by PatrykGrudnik on 03/05/2017.
 */
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public void addPost(Date date, User user, String text, Topic topic){
        Post post = new Post();
        post.setDate(date);
        post.setAutor(user);
        post.setText(text);
        post.setTopic(topic);

        postRepository.save(post);




    }
}
