package com.todolists.Service;

import com.todolists.Dao.UserDao;
import com.todolists.Entity.ToDoList;
import com.todolists.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */

@Service
public class UserService {
    
    @Autowired
    @Qualifier("mongoDBUsers")
    private UserDao userDao;

    public Collection<User> getAllUsers() {
        return this.userDao.getAllUsers();
    }

    public User getUserByUsername(String username) {
        return this.userDao.getUserByUsername(username);
    }

    public void removeUserByUsername(String username) {
        this.userDao.removeUserByUsername(username);
    }

    public void insertUser(User user) {
        this.userDao.insertUser(user);
    }

    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }
    
}
