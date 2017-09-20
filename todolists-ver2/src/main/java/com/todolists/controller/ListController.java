package com.todolists.controller;

import com.todolists.entity.ToDoList;
import com.todolists.entity.TodoItem;
import com.todolists.service.MyUserPrincipal;
import com.todolists.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Collection;

/**
 * Created by vietha on 8/21/2017.
 */

@RestController
@RequestMapping("/todolists")
public class ListController {

    @Autowired
    private TodoListService todoListService;

    // get all list
    @GetMapping
    public Collection<ToDoList> getAllListsOfCreator() {
        //return todoListService.getAllLists();
        MyUserPrincipal user = (MyUserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return todoListService.getAllListsOfCreator(user.getUsername());
    }

    // get a specific list
    @GetMapping(value = "/{id}")
    public ToDoList getListById(@PathVariable("id") String id, Principal principal) {
        // return todoListService.getListById(id);
        return todoListService.getListByIdAndCreator(id, principal.getName());
    }

    // create a new list
    @PostMapping
    public void insertList(@RequestBody ToDoList toDoList, Principal principal) {
        if (principal.getName().equals(toDoList.getCreator()))
            todoListService.insertList(toDoList);
    }

    // edit a list
    @PutMapping
    public void updateList(@RequestBody ToDoList toDoList, Principal principal) {
        if (principal.getName().equals(toDoList.getCreator()))
            todoListService.updateList(toDoList);
    }

    // Add an item to list
    @PutMapping(value = "/{id}")
    public void insertItemToList(@RequestBody TodoItem todoItem, @PathVariable("id") String id, Principal principal) { todoListService.insertItemToListOfCreator(todoItem, id, principal.getName()); }

    // change status of an item in a list
    @PatchMapping(value = "/{id}/{item_name}")
    public void changeItemStatus(@PathVariable("id") String listId, @PathVariable("item_name") String itemName,
                                 @RequestParam("change") TodoItem.Status newStatus, Principal principal) {
        todoListService.changeItemStatusOfCreator(listId, itemName, newStatus, principal.getName());
    }

    // Delete completed items in a list
    @DeleteMapping("/{id}")
    public void deleteCompletedItems(@PathVariable("id") String listId, @RequestParam("status") TodoItem.Status status, Principal principal) {
        if (status.equals(TodoItem.Status.Completed))
            todoListService.deleteCompletedItemsOfCreator(listId, principal.getName());
    }
}
