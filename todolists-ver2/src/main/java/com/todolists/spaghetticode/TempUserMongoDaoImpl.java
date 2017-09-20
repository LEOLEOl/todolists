package com.todolists.spaghetticode;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */

@Repository
@Qualifier("mongoDBTempUsers")
public class TempUserMongoDaoImpl implements TempUserDao {


    @Override
    public Collection<TempUser> getAllUsers() {
        return null;
    }

    @Override
    public TempUser getUserById(String id) {
        return null;
    }

    @Override
    public void removeUserById(String id) {

    }

    @Override
    public void updateUser(TempUser tempUser) {

    }

    @Override
    public void insertUser(TempUser tempUser) {

    }
}
