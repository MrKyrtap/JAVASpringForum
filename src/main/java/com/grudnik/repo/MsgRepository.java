package com.grudnik.repo;

import com.grudnik.entities.Message;
import com.grudnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 30/04/2017.
 */
@Repository
public interface MsgRepository extends JpaRepository<Message, Integer> {

     List<Message> findByConversationId(int id);
}
