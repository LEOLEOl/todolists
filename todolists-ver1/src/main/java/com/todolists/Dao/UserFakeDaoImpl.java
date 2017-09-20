package com.todolists.Dao;

import com.todolists.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by vietha on 8/23/2017.
 */

@Repository
@Qualifier("fakeUsers")
public class UserFakeDaoImpl implements UserDao {
    private HashMap<String, User> users;

    {
        users = new HashMap<String, User>() {
            {
                put("user1", new User("user1", "user1", "USER1"));
                put("user2", new User("user2", "user2", "USER2"));
                put("user3", new User("user3", "user3", "USER3"));
            }
        };
    }
    
    @Override
    public Collection<User> getAllUsers() {
        return this.users.values();
    }

    
    @Override
    public User getUserByUsername(String username) {
        return this.users.get(username);
    }

    
    @Override
    public void removeUserByUsername(String username) {
        this.users.remove(username);
    }

    
    @Override
    public void updateUser(User user) {
        User u = users.get(user.getUsername());
        if (u != null)
            users.put(user.getUsername(), user);
        //users.put(tempUser.getUsername(), tempUser);
    }

    
    @Override
    public void insertUser(User user) {
        users.put(user.getUsername(), user);
    }
}
