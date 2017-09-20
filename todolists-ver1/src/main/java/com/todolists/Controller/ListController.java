package com.todolists.Controller;

import com.todolists.Entity.ToDoList;
import com.todolists.Entity.TodoItem;
import com.todolists.Service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */

@RestController
@RequestMapping("/todolists")
public class ListController {

    @Autowired
    private TodoListService todoListService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<ToDoList> getAllLists() {
        return this.todoListService.getAllLists();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ToDoList getListById(@PathVariable("id") String id) {
        return this.todoListService.getListById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteListById(@PathVariable("id") String id) {
        todoListService.removeListById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateList(@RequestBody ToDoList toDoList) {
        todoListService.updateList(toDoList);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertList(@RequestBody ToDoList toDoList) {
        todoListService.insertList(toDoList);
    }


    // Add item to list
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertItemToList(@RequestBody TodoItem todoItem, String id) { todoListService.insertItemToList(todoItem, id); }


}
