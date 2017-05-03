package com.grudnik.services;

import com.grudnik.entities.Topic;
import com.grudnik.repo.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PatrykGrudnik on 14/04/2017.
 */
@Service
public class CategoryService {
    private final TopicRepository topicRepository;

    public CategoryService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public List<Topic> getAllTopics(int category_id){

        List<Topic> topics  = topicRepository.findByCategoryId(category_id);
        return  topics;
    };
}
