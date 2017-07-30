package com.grudnik.services;

import com.grudnik.dto.ProfileDTO;
import com.grudnik.entities.User;
import com.grudnik.repo.PostRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by PatrykGrudnik on 30/07/2017.
 */
@Service
public class ProfileService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    public ProfileService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public ProfileDTO getProfileDetails(int id){
        ProfileDTO p = new ProfileDTO();
        User u = userRepository.findOne(id);
        p.setUser(u);
        p.setPostsCount(postRepository.countByAutorId(id));
        p.setTopicCount(3);
        LocalDate ld  =LocalDate.now();
     //   int age =ld.getYear() - u.getBirthDate().;
        p.setUserAge(20);
        return p ;

    }
}
