package com.grudnik.services;

import com.grudnik.entities.Message;
import com.grudnik.entities.User;
import com.grudnik.repo.MsgRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Created by PatrykGrudnik on 03/05/2017.
 */
@Service
public class MsgService {
    private final UserRepository userRepository;
    private final MsgRepository msgRepository;

    public MsgService(UserRepository userRepository, MsgRepository msgRepository) {
        this.userRepository = userRepository;
        this.msgRepository = msgRepository;
    }

    public void getAllMessage(String user){
        User u = userRepository.findByMail(user);
        //to be continued




}
}
