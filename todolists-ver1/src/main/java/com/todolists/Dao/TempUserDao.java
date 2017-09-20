package com.todolists.Dao;

import com.todolists.Entity.TempUser;

import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */
public interface TempUserDao {
    Collection<TempUser> getAllUsers();

    TempUser getUserById(String id);

    void removeUserById(String id);

    void updateUser(TempUser tempUser);

    void insertUser(TempUser tempUser);
}
