package com.grudnik.services;

import com.grudnik.entities.Category;
import com.grudnik.entities.MainCategory;
import com.grudnik.repo.CategoryRepository;
import com.grudnik.repo.MainCategoryRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrykGrudnik on 09/04/2017.
 */
@Service
public class IndexService {
   private final CategoryRepository catrepo ;
   private final MainCategoryRepsitory maincatrepo ;



    @Autowired
    public IndexService(CategoryRepository catrepo, MainCategoryRepsitory maincatrepo) {
        this.catrepo = catrepo;
        this.maincatrepo = maincatrepo;
    }

    public  HashMap<String, List<Category>> getcategory(){
        HashMap<String, List<Category>> hashmap =
                new HashMap<String, List<Category>>();
        
        List<Category> list ;
        List<MainCategory> mcat = maincatrepo.findAll();
        for (MainCategory maincategory:mcat) {
            list = catrepo.findByCategoryId(maincategory.getId());

            hashmap.put(maincategory.getName(),list);
            
        }
        
         return hashmap;
    }
    public List<MainCategory> getmaincategory(){
         return maincatrepo.findAll();
    }

}
