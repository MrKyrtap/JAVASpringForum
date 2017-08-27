package com.grudnik.services;

import com.grudnik.entities.Conversation;
import com.grudnik.entities.Message;
import com.grudnik.entities.User;
import com.grudnik.repo.ConversationRepository;
import com.grudnik.repo.MsgRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by PatrykGrudnik on 03/05/2017.
 */
@Service
public class MsgService {
    private final UserRepository userRepository;
    private final MsgRepository msgRepository;
    private final ConversationRepository conversationRepository;

    public MsgService(UserRepository userRepository, MsgRepository msgRepository, ConversationRepository conversationRepository) {
        this.userRepository = userRepository;
        this.msgRepository = msgRepository;
        this.conversationRepository = conversationRepository;
    }

    public List<Message> getAllMessages(int c){

        return  msgRepository.findByConversationId(c);
    }

    public List<Conversation> getAllConversation(String user){
        User u = userRepository.findByMail(user);
        List<Conversation> convs = conversationRepository.findByToId(u.getId());
        return  convs;
    }
    public boolean checkUserAndConversation(String user, int conv){
        User u = userRepository.findByMail(user);
        Conversation c = conversationRepository.findOne(conv);
        if(u.getName()==c.getTo().getName())
            return true;
        else return false;
    }

}
