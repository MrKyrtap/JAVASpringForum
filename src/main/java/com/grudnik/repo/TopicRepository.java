package com.grudnik.repo;

import com.grudnik.entities.Category;
import com.grudnik.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 14/04/2017.
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findByCategoryId (int id);
}
