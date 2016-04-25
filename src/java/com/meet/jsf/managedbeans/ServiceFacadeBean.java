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

    @Inject
    private MockDbConnector mockDbConnector;
    @Inject
    private UserBean userBean;
    
    private Event event = new Event();

    public Event getEvent() {
        return event;  
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String addEvent() {
        mockDbConnector.addEvent(event);
        userBean.joinEvent(event);
        event = new Event();
        return "index";
    }
}
