package com.todolists.repository;

import com.todolists.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */
public interface UserRepository extends MongoRepository<User, String> {

    User findByUsername(String username);
}
