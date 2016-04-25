/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import com.meet.jsf.basicClasses.Event;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */
@Named
@RequestScoped
public class EventBean {
    private Event event = new Event();

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
    
}
