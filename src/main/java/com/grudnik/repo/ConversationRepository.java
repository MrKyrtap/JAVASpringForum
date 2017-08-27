package com.grudnik.repo;

import com.grudnik.entities.Conversation;
import com.grudnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 27/08/2017.
 */
@Repository
public interface ConversationRepository extends JpaRepository<Conversation, Integer>{
    List<Conversation> findByToId(int id);
}
