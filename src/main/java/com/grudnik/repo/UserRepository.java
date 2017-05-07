package com.grudnik.repo;

import com.grudnik.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PatrykGrudnik on 30/04/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByMail(String mail);
    User findByName(String name);
}
