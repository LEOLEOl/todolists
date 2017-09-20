package com.todolists.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Set;

/**
 * Created by vietha on 8/21/2017.
 */

@Document(collection = "lists")
public class ToDoList {

    @Id
    private String id;
    private String name;
    private String creator;
    Set<TodoItem> items;

    public ToDoList() {
    }

    public ToDoList(String id, String name, String creator, Set<TodoItem> items) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Set<TodoItem> getItems() {
        return items;
    }

    public void setItems(Set<TodoItem> items) {
        this.items = items;
    }

    public void addItem(TodoItem todoItem) {
        items.add((todoItem));
    }
}
