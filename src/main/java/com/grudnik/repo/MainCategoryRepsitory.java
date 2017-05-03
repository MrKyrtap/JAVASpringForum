package com.grudnik.repo;

import com.grudnik.entities.MainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PatrykGrudnik on 09/04/2017.
 */
@Repository
public interface MainCategoryRepsitory extends JpaRepository<MainCategory,Integer> {
}
