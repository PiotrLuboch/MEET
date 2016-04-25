/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import com.meet.jsf.basicClasses.Event;
import com.meet.jsf.dbconnector.MockDbConnector;
import java.util.ArrayList;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */
@Named
@ApplicationScoped
public class ServiceFacadeBean {

    private String searchEventName;

    private Event event = new Event();

    public Event getEvent() {
        return event;  
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Inject
    private MockDbConnector mockDbConnector;

    public String getSearchEventName() {
        return searchEventName;
    }

    public void setSearchEventName(String searchEventName) {
        this.searchEventName = searchEventName;
    }

    public String addEvent() {
        mockDbConnector.addEvent(event);
        event = new Event();
        return "index";
    }

    public ArrayList<Event> findEvents() {
        return mockDbConnector.findEvents(searchEventName);
    }
}
