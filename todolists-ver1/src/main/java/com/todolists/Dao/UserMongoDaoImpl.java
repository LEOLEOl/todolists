package com.todolists.Dao;

import com.todolists.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */

@Repository
@Qualifier("mongoDBUsers")
@Import(AppConfig.class)
public class UserMongoDaoImpl implements UserDao {

    @Autowired
    MongoOperations mongoOperations;

    @Override
    public Collection<User> getAllUsers() {
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return (User)this.mongoOperations.findOne(query, User.class);
    }

    @Override
    public void removeUserByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        this.mongoOperations.remove(query, User.class);
    }

    @Override
    public void updateUser(User user) {
        Query query = new Query(Criteria.where("username").is(user.getUsername()));
        User u = (User)this.mongoOperations.findOne(query, User.class);
        if (u != null) {
            this.mongoOperations.save(user);
        }
    }

    @Override
    public void insertUser(User user) {
        this.mongoOperations.save(user);
    }
}
