package com.todolists.repository;

import com.todolists.entity.ToDoList;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */
public interface TodoListRepository extends MongoRepository<ToDoList, String> {

    Collection<ToDoList> findByCreator(String creator);
    ToDoList findByIdAndCreator(String id, String creator);
}
