/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.dbconnector;

import com.meet.jsf.basicClasses.Event;
import com.meet.jsf.basicClasses.User;
import com.meet.jsf.managedbeans.LoginBean;
import com.meet.jsf.managedbeans.RegistrationBean;
import com.meet.jsf.managedbeans.ServiceFacadeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */
@Named
@ApplicationScoped
public class MockDbConnector implements IDbConnector {

    @Inject
    private LoginBean loginBean;

    @Inject
    private RegistrationBean registrationBean;
    
    private static ArrayList<User> userDb = new ArrayList<>();
    private static ArrayList<Event> eventDb = new ArrayList<>();

    public MockDbConnector() {
        if (userDb.isEmpty()) {
            userDb.add(new User("admin", "admin"));
            userDb.add(new User("test", "1234"));
            userDb.add(new User("user", "password"));
        }
        
        if(eventDb.isEmpty()){
            eventDb.add(new Event("Football match",null,22,new Date(98, 0, 21), "Zidane will play with us"));
            eventDb.add(new Event("Performance in theater",null,300,new Date(114, 5, 2),"Master and Margaret"));
            eventDb.add(new Event("JSF training",null,7, new Date(116, 7, 5),"Laptop required"));
            
        }
    }

    @Override
    public boolean connect() {
        return true;
    }

    @Override
    public boolean disconnect() {
        return true;
    }

    @Override
    public boolean validateUser() {
        User user = new User(loginBean.getUsername(), loginBean.getPassword());
        for (User u : userDb) {
            if (u.equals(user) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registerUser() {
        User user = new User(registrationBean.getLogin(), registrationBean.getPassword(), registrationBean.getEmail());
        if (!userDb.stream().noneMatch((u) -> (u.equals(user)))) {
            return false;
        }
        userDb.add(user);
        return true;
    }

    public ArrayList<Event> findEvents(String name) {
        if (name.equals("")) {
            return eventDb;
        }
        ArrayList<Event> events = new ArrayList<>();
        Event event = new Event(name, null, 0);
        for(Event e: eventDb){
            if(e.equals(event))
                events.add(e);
        }
        return events;
    }
    
    public boolean addEvent(Event event){
        if(event == null)
            return false;
        if(eventDb.contains(event))
            return false;
        eventDb.add(event);        
        return true;
    }
    
    public User getUser(String username)
    {
        int index = userDb.indexOf(new User(username,""));
        return userDb.get(index);
    }

}
