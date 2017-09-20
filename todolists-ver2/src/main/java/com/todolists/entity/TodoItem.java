package com.todolists.entity;

/**
 * Created by vietha on 8/21/2017.
 */

//@Document(collection = "items")
public class TodoItem {

    public enum Status {
        NotStart,
        Processing,
        Completed
    }

    //private String id;

    private String name;
    private Status status;

    public TodoItem() {
    }

    public TodoItem(String name, Status status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
