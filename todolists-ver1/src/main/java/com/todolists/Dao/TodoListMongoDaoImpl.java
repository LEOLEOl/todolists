package com.todolists.Dao;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.todolists.Entity.ToDoList;
import com.todolists.Entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * Created by vietha on 8/23/2017.
 */

@Repository
@Import(AppConfig.class)
@Qualifier("mongoDBToDoLists")
public class TodoListMongoDaoImpl implements TodoListDao {
    @Autowired
    MongoOperations mongoOperations;

    @Override
    public Collection<ToDoList> getAllLists() {
        //return (Collection<ToDoList>)this.mongoOperations.getCollection("todoLists").getDB();

        List<ToDoList> toDoLists = new ArrayList<>();

        DBCollection dbCollection = this.mongoOperations.getCollection("lists");
        DBCursor cursor = dbCollection.find();

        while (cursor.hasNext()) {
            DBObject object = cursor.next();

            ToDoList toDoList = mongoOperations.getConverter().read(ToDoList.class, object);
            toDoLists.add((ToDoList) toDoList);
        }
        return toDoLists;
    }

    @Override
    public ToDoList getListById(String id) {
        // return this.toDoLists.get(id);
        Query query = new Query(Criteria.where("id").is(id));
        return (ToDoList)this.mongoOperations.findOne(query, ToDoList.class);
    }

    @Override
    public void removeListById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        this.mongoOperations.remove(query, ToDoList.class);
    }

    @Override
    public void insertList(ToDoList toDoList) {
        this.mongoOperations.save(toDoList);
    }

    @Override
    public void updateList(ToDoList toDoList) {
        Query query = new Query(Criteria.where("id").is(toDoList.getId()));
        ToDoList todoList = (ToDoList)this.mongoOperations.findOne(query, ToDoList.class);
        if (todoList != null)
            this.mongoOperations.save(toDoList);
    }

    @Override
    public void insertItemToList(TodoItem todoItem, String listId) {
        Query query = new Query(Criteria.where("id").is(listId));
        ToDoList todoList = (ToDoList)this.mongoOperations.findOne(query, ToDoList.class);
        if (todoList != null) {
            todoList.addItem(todoItem);
            this.mongoOperations.save(todoList);
        }
        else return;

    }
}
