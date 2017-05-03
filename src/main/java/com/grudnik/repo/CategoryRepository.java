package com.grudnik.repo;

import com.grudnik.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 09/04/2017.
 */
@Repository

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    List<Category> findByCategoryId (int id);
}
