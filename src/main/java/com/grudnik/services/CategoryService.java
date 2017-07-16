package com.grudnik.services;

import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import com.grudnik.entities.Topic;
import com.grudnik.repo.CategoryRepository;
import com.grudnik.repo.MainCategoryRepsitory;
import com.grudnik.repo.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PatrykGrudnik on 14/04/2017.
 */
@Service
public class CategoryService {
    private final TopicRepository topicRepository;
    private final CategoryRepository categoryRepository;
    private final MainCategoryRepsitory mainCategoryRepsitory;

    public CategoryService(TopicRepository topicRepository, CategoryRepository categoryRepository,  MainCategoryRepsitory mainCategoryRepsitory) {
        this.topicRepository = topicRepository;
        this.categoryRepository = categoryRepository;
        this.mainCategoryRepsitory = mainCategoryRepsitory;
    }

    public List<Topic> getAllTopics(int category_id){

        List<Topic> topics  = topicRepository.findByCategoryId(category_id);
        return  topics;
    };

    public void add(Integer maincat, String catToAdd) {
        Category cat = new Category();
        cat.setName(catToAdd);
        cat.setCategory(mainCategoryRepsitory.findOne(maincat));
        categoryRepository.save(cat);
    }
}
