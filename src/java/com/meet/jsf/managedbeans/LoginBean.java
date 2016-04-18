/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Piotr
 */
@ManagedBean
@SessionScoped
public class LoginBean {

    @Pattern(regexp = "^\\w*$", message = "Login can contain only letters and numbers")
    @Size(min = 4, max = 16, message = "Login length must be in range from 4 to 16")
    private String username;
    @Size(min = 4, max = 16, message = "Password length must be in range from 4 to 16")
    private String password;
    private boolean isLoggedIn = false;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public void setIsLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public void login() {
        if (username.equals("admin") && password.equals("admin")) 
            isLoggedIn = true;
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,
                    "Incorrect username or password",
                    "Please enter valid username and password"));
           
    }
    public void setIsLoggedInFalse(){
        isLoggedIn=false;
    }
    
    public String logout() {
        isLoggedIn = false;
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false)).invalidate();
        return "login";
        
    }
}
