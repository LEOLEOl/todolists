package com.todolists.Dao;

import com.todolists.Entity.ToDoList;
import com.todolists.Entity.TodoItem;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by vietha on 8/23/2017.
 */

@Repository
@Qualifier("fakeToDoLists")
public class TodoListFakeDaoImpl implements TodoListDao {
    private static HashMap<String, ToDoList> toDoLists;

    static {
        toDoLists = new HashMap<>();
    }

    @Override
    public Collection<ToDoList> getAllLists() {
        return this.toDoLists.values();
    }

    @Override
    public ToDoList getListById(String id) {
        return this.toDoLists.get(id);
    }

    @Override
    public void removeListById(String id) {
        this.toDoLists.remove(id);
    }

    @Override
    public void insertList(ToDoList toDoList) {
        this.toDoLists.put(toDoList.getId(), toDoList);
    }

    @Override
    public void updateList(ToDoList toDoList) {
        ToDoList u = toDoLists.get(toDoList.getId());
        if (u != null)
            toDoLists.put(toDoList.getId(), toDoList);
    }

    @Override
    public void insertItemToList(TodoItem todoItem, String listId) {

    }
}
