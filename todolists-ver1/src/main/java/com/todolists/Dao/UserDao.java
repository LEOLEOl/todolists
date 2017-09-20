package com.todolists.Dao;

import com.todolists.Entity.User;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */
public interface UserDao {
    Collection<User> getAllUsers();

    User getUserByUsername(String username);

    void removeUserByUsername(String username);

    void updateUser(User user);

    void insertUser(User user);
}
