package com.todolists.Service;

import com.todolists.Dao.TodoListDao;
import com.todolists.Entity.ToDoList;
import com.todolists.Entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Created by vietha on 8/23/2017.
 */

@Service
public class TodoListService {

    @Autowired
    @Qualifier("mongoDBToDoLists")
    private TodoListDao todoListDao;

    public Collection<ToDoList> getAllLists() {
        return this.todoListDao.getAllLists();
    }

    public ToDoList getListById(String id) {
        return this.todoListDao.getListById(id);
    }

    public void removeListById(String id) {
        this.todoListDao.removeListById(id);
    }

    public void insertList(ToDoList toDoList) {
        this.todoListDao.insertList(toDoList);
    }

    public  void updateList(ToDoList toDoList) {
        this.todoListDao.updateList(toDoList);
    }

    public void insertItemToList(TodoItem todoItem, String listId) {
        this.todoListDao.insertItemToList(todoItem, listId);
    }
}
