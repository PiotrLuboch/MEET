/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.dbconnector;

import com.meet.jsf.managedbeans.LoginBean;
import com.meet.jsf.managedbeans.RegistrationBean;
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
public class MockDbConnector implements IDbConnector {

    @Inject
    private LoginBean loginBean;

    @Inject
    private RegistrationBean registrationBean;

    private static ArrayList<User> userDb = new ArrayList<>();

    private class User {

        public String login;
        public String password;
        public String email;

        
        public User(String login, String password) {
            this.login = login;
            this.password = password;            
        }

        public User(String login, String password, String email) {
            this(login, password);
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof User) {
                if (((User) o).login.equals(this.login)) {
                    return true;
                }
            }
            return false;
        }

    }

    public MockDbConnector() {
        if (userDb.isEmpty()) {
            userDb.add(new User("admin", "admin"));
            userDb.add(new User("test", "1234"));
            userDb.add(new User("user", "password"));
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
            if (u.equals(user) && u.password.equals(user.password)) {
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

}
