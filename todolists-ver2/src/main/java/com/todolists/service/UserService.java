package com.todolists.service;

import com.todolists.repository.UserRepository;
import com.todolists.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public Collection<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserByUsername(String username) {
        return userRepository.findOne(username);
    }

    public void removeUserByUsername(String username) {
        userRepository.delete(username);
    }

    public void insertUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        if (userRepository.exists(user.getUsername()))
            userRepository.save(user);
    }
    
}
