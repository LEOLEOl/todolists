package com.todolists.Dao;

import com.todolists.Entity.ToDoList;
import com.todolists.Entity.TodoItem;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */
public interface TodoListDao {
    Collection<ToDoList> getAllLists();

    ToDoList getListById(String id);

    void removeListById(String id);

    void insertList(ToDoList toDoList);

    void updateList(ToDoList toDoList);

    void insertItemToList(TodoItem todoItem, String listId);
}
