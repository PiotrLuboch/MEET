/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.basicClasses;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Piotr
 */
public class Event {

    private static int currentId;
    private int id;
    private String name;
    private int capacity;
    private User organiser;
    private Date date;
    private String comment;

    private ArrayList<User> userList = new ArrayList<>();

    public Event() {
        id=currentId;
        ++currentId;
    }

    public Event(String name, User organiser, int capacity) {
        this();
        this.organiser = organiser;
        this.name = name;
        this.capacity = capacity;
    }

    public Event(String name, User organiser, int capacity, Date date, String comment) {
        this(name, organiser, capacity);
        this.date = date;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public User getOrganiser() {
        return organiser;
    }

    public void setOrganiser(User organiser) {
        this.organiser = organiser;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public boolean addUser(User user) {
        if (userList.size() == capacity) {
            return false;
        }
        userList.add(user);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Event) {
            Event e = (Event)o;
            if (e.name.equals(this.name) && e.capacity == this.capacity && e.date.equals(this.date)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return name + " " + capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
