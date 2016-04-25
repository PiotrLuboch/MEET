/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import com.meet.jsf.basicClasses.Event;
import com.meet.jsf.basicClasses.User;
import com.meet.jsf.dbconnector.MockDbConnector;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Piotr
 */
@Named
@SessionScoped
public class UserBean implements Serializable {

    private User user;

    @Inject
    private LoginBean loginBean;

    @Inject
    private MockDbConnector mockDbConnector;

    public User getUser() {
        if (user == null) {
            user = mockDbConnector.getUser(loginBean.getUsername());
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void joinEvent(Event event) {
        user = mockDbConnector.getUser(loginBean.getUsername());
        if (event != null && user != null && !user.getEvents().contains(event) && event.getCapacity() != event.getUserList().size()) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Succesfully joined event!",
                            "You have succesfully joined the event. Have a nice time during it!"));
            user.getEvents().add(event);
            event.addUser(user);
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Something went wrong!",
                            "You haven't joined the event. Propably the capacity is full, the event is off or you hava already joinde the event."));
        }
    }

    public static void main(String[] argv) {
        UserBean ub = new UserBean();
        User u = ub.mockDbConnector.getUser("admin");
        System.out.println(u.getName());
    }
}
