package com.grudnik.services;

import com.grudnik.dto.InfoDTO;
import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import com.grudnik.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


/**
 * Created by PatrykGrudnik on 09/04/2017.
 */
@Service
public class IndexService  {

    private final CategoryRepository catrepo;
    private final MainCategoryRepsitory maincatrepo;
    private final UserRepository userrepo;
    private final TopicRepository topicRepository;
    private final PostRepository postRepository;




    @Autowired
    public IndexService(CategoryRepository catrepo, MainCategoryRepsitory maincatrepo, UserRepository userrepo, TopicRepository topicRepository, PostRepository postRepository) {
        this.catrepo = catrepo;
        this.maincatrepo = maincatrepo;
        this.userrepo = userrepo;
        this.topicRepository = topicRepository;
        this.postRepository = postRepository;
    }

    public HashMap<MainCategory, List<Category>> getCategory() {
        HashMap<MainCategory, List<Category>> hashmap = new HashMap<MainCategory, List<Category>>();

        List<Category> list;
        List<MainCategory> mcat = maincatrepo.findAllByOrderByIdAsc();
        for (MainCategory maincategory : mcat) {

            list = catrepo.findByCategoryId(maincategory.getId());
            hashmap.put(maincategory, list);
            System.out.println(maincategory.getName());
        }
        return hashmap;
    }

    public List<MainCategory> getMainCategory() {
        return maincatrepo.findAllByOrderByIdAsc();
    }

    public void renameMainCategory(String oldName, String newName){
        MainCategory cat = maincatrepo.findOne(Integer.parseInt(oldName));
        cat.setName(newName);
        maincatrepo.save(cat);
    }

    public void renameCategory(String category, String newname) {
        Category cat  = catrepo.findOne(Integer.parseInt(category));
        cat.setName(newname);
        catrepo.save(cat);
    }

    public InfoDTO getInformation() {
        InfoDTO info = new InfoDTO();
        info.setLastUser(userrepo.findFirstByOrderByIdDesc().getName());
        info.setUsersCount((int) userrepo.count());
        info.setTopicsCount((int) topicRepository.count());
        info.setPostsCount((int) postRepository.count());
        return  info;
    }





}
