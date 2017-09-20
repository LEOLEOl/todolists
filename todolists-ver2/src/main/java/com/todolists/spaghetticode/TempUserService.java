package com.todolists.spaghetticode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */
@Service
public class TempUserService {

    @Autowired
    @Qualifier("fakeTempUsers")
    private TempUserDao tempUserDao;

    public Collection<TempUser> getAllUsers() {
        return this.tempUserDao.getAllUsers();
    }

    public TempUser getUserById(String id) {
        return this.tempUserDao.getUserById(id);
    }

    public void removeUserById(String id) {
        this.tempUserDao.removeUserById(id);
    }

    public void updateUser(TempUser tempUser) {
        this.tempUserDao.updateUser(tempUser);
    }

    public void insertUser(TempUser tempUser) {
        this.tempUserDao.insertUser(tempUser);
    }
}
