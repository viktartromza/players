package com.aston.players.repository;

import com.aston.players.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

   public User getUserByID (int id){
        User user = new User();
        return user;
    }
}
