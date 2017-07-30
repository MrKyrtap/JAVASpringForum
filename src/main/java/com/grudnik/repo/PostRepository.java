package com.grudnik.repo;

import com.grudnik.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 16/04/2017.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTopicId(int id);
    int countByAutorId(int id);

}
