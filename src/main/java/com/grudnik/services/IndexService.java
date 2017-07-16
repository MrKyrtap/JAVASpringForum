package com.grudnik.services;

import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import com.grudnik.repo.CategoryRepository;
import com.grudnik.repo.MainCategoryRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrykGrudnik on 09/04/2017.
 */
@Service
public class IndexService {
    private final CategoryRepository catrepo;
    private final MainCategoryRepsitory maincatrepo;


    @Autowired
    public IndexService(CategoryRepository catrepo, MainCategoryRepsitory maincatrepo) {
        this.catrepo = catrepo;
        this.maincatrepo = maincatrepo;
    }

    public HashMap<MainCategory, List<Category>> getCategory() {
        HashMap<MainCategory, List<Category>> hashmap = new HashMap<MainCategory, List<Category>>();

        List<Category> list;
        HashMap<Integer , Category> list2;
        List<MainCategory> mcat = maincatrepo.findAll();
        for (MainCategory maincategory : mcat) {
            list = catrepo.findByCategoryId(maincategory.getId());
            hashmap.put(maincategory, list);
        }
        return hashmap;
    }

    public List<MainCategory> getMainCategory() {
        return maincatrepo.findAll();
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
}
