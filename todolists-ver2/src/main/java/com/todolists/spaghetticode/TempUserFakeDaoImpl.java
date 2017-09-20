package com.todolists.spaghetticode;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by vietha on 8/21/2017.
 */

//@Component
@Repository
@Qualifier("fakeTempUsers")
public class TempUserFakeDaoImpl implements TempUserDao {
    private static HashMap<String, TempUser> users;

    static {
        users = new HashMap<String, TempUser>() {
            {
                put("user1", new TempUser("user1", "user1", "USER1"));
                put("user2", new TempUser("user2", "user2", "USER2"));
                put("user3", new TempUser("user3", "user3", "USER3"));
            }
        };
    }

    @Override
    public Collection<TempUser> getAllUsers() {
        return this.users.values();
    }

    @Override
    public TempUser getUserById(String id) {
        return this.users.get(id);
    }

    @Override
    public void removeUserById(String id) {
        this.users.remove(id);
    }

    @Override
    public void updateUser(TempUser tempUser) {
        TempUser u = users.get(tempUser.getUsername());
        if (u != null)
            users.put(tempUser.getUsername(), tempUser);
        //users.put(tempUser.getUsername(), tempUser);
    }

    @Override
    public void insertUser(TempUser tempUser) {
        users.put(tempUser.getUsername(), tempUser);
    }
}
