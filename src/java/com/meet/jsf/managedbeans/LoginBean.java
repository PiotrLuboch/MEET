/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

<<<<<<< HEAD
import com.meet.jsf.dbconnector.IDbConnector;
import com.meet.jsf.dbconnector.MockDbConnector;
import com.meet.jsf.navigation.Navigator;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedProperty;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
=======
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Piotr
 */
<<<<<<< HEAD
@Named
@SessionScoped
public class LoginBean implements Serializable {
=======
@ManagedBean
@SessionScoped
public class LoginBean {
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517

    @Pattern(regexp = "^\\w*$", message = "Login can contain only letters and numbers")
    @Size(min = 4, max = 16, message = "Login length must be in range from 4 to 16")
    private String username;
    @Size(min = 4, max = 16, message = "Password length must be in range from 4 to 16")
    private String password;
    private boolean isLoggedIn = false;

<<<<<<< HEAD
    @Inject
    private MockDbConnector dbConnector;

=======
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIsLoggedIn() {
<<<<<<< HEAD
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
        if (session != null && session.getAttribute("username") == null) {
            isLoggedIn = false;
        }

=======
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
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

<<<<<<< HEAD
    public String login() {
        dbConnector.connect();
        if (dbConnector.validateUser()) {
            isLoggedIn = true;
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            HttpSession session = (HttpSession) context.getSession(false);
            session.setAttribute("username", username);            
            try {                
                FacesContext.getCurrentInstance().addMessage(
                        "myForm:indexMessages",
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Login successful",
                                "Logged in as " + username));
                context.getFlash().setKeepMessages(true);
                context.redirect(context.getRequestContextPath() + "/faces/index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect username or password",
                            "Please enter valid username and password"));
            return Navigator.toLogin();
        }
        return Navigator.toIndex();
    }

    public String logout() {
        isLoggedIn = false;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) context.getSession(false);
        session.invalidate();
        FacesContext.getCurrentInstance().addMessage(
                "myForm:indexMessages",
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "You have logged out",
                        "Have a nice meeting :)"));
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        try {
            context.redirect(context.getRequestContextPath() + "/faces/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Navigator.toIndex();
=======
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
        
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
    }
}
