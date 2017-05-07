package com.grudnik.services;

import com.grudnik.entities.Role;
import com.grudnik.entities.User;
import com.grudnik.repo.RoleRepository;
import com.grudnik.repo.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by PatrykGrudnik on 06/05/2017.
 */
@Service
public class UserService {
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        Role userRole = roleRepository.findByRole("USER");
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(user);

    }
    public User findUserByEmail(String email) {
        return userRepository.findByMail(email);
    }
    public User findUserByName(String name){
        return  userRepository.findByName(name);
    }


}

