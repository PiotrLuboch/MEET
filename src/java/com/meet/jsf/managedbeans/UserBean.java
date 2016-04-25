/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import com.meet.jsf.basicClasses.User;
import com.meet.jsf.dbconnector.MockDbConnector;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
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
    
    public UserBean(){
        user = mockDbConnector.getUser(loginBean.getUsername());
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
}
