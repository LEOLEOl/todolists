package com.todolists.service;

import com.todolists.repository.TodoListRepository;
import com.todolists.entity.ToDoList;
import com.todolists.entity.TodoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by vietha on 8/23/2017.
 */

@Service
public class TodoListService {

    @Autowired
    private TodoListRepository todoListRepository;

    public Collection<ToDoList> getAllLists() {
        return todoListRepository.findAll();
    }

    public Collection<ToDoList> getAllListsOfCreator(String creator) {return todoListRepository.findByCreator(creator); }

    public ToDoList getListById(String id) {
        return todoListRepository.findOne(id);
    }

    public ToDoList getListByIdAndCreator(String id, String creator) { return todoListRepository.findByIdAndCreator(id, creator); }

    public void removeListById(String id) {
        todoListRepository.delete(id);
    }

    public void insertList(ToDoList toDoList) {
        todoListRepository.save(toDoList);
    }

    public  void updateList(ToDoList toDoList) {
        if (todoListRepository.exists(toDoList.getId()))
            todoListRepository.save(toDoList);
    }

    public void insertItemToListOfCreator(TodoItem todoItem, String listId, String creator) {
        ToDoList toDoList = getListByIdAndCreator(listId, creator);
        if (toDoList != null) {
            Set<TodoItem> items = toDoList.getItems();
            for (TodoItem item : items)
                if (item.getName().equals(todoItem.getName())) return;
            saveItemToList(todoItem, toDoList);
        }
    }

    public void changeItemStatusOfCreator(String listId, String itemName, TodoItem.Status newStatus, String creator) {
        ToDoList toDoList = getListByIdAndCreator(listId, creator);
        if (toDoList != null) {
            Set<TodoItem> items = toDoList.getItems();
            for (TodoItem item : items) {
                if (item.getName().equals(itemName)) {
                    item.setStatus(newStatus);
                    saveItemToList(item, toDoList);
                    break;
                }
            }
        }
    }

    public void deleteCompletedItemsOfCreator(String listId, String creator) {
        ToDoList toDoList = getListByIdAndCreator(listId, creator);
        if (toDoList != null) {
            Set<TodoItem> items = toDoList.getItems();

            for (Iterator<TodoItem> itemIterator = items.iterator(); itemIterator.hasNext(); )
                if (itemIterator.next().getStatus().equals(TodoItem.Status.Completed))
                    itemIterator.remove();

            toDoList.setItems(items);
            this.todoListRepository.save(toDoList);
        }
    }


    // private function used in this class
    private void saveItemToList(TodoItem todoItem, ToDoList toDoList) {
        toDoList.addItem(todoItem);
        this.todoListRepository.save(toDoList);
    }
}
