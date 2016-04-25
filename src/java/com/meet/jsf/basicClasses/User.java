/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.basicClasses;

/**
 *
 * @author Piotr
 */
public class User {

    private String login;
    private String password;
    private String email;

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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
