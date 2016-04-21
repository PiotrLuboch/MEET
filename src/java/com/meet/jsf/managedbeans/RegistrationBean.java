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
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
=======
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Piotr
 */
@Named
@RequestScoped
public class RegistrationBean {

    @Pattern(regexp = "^\\w*$", message = "Login can contain only letters and numbers")
    @Size(min = 4, max = 16, message = "Login length must be in range from 4 to 16")
    private String login;
<<<<<<< HEAD

    @Size(min = 4, max = 16, message = "Password length must be in range from 4 to 16")
    private String password;

=======
    
    @Size(min = 4, max = 16, message = "Password length must be in range from 4 to 16")
    private String password;
    
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
    @Pattern(regexp = "^.+@.+$", message = "Email should match pattern: user@domain")
    private String email;

    @Inject
    private MockDbConnector dbConnector;

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
<<<<<<< HEAD

    public String register() {
        if (dbConnector.registerUser()) {
            return Navigator.toIndex();
        }
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "User with this login already exists",
                        "Please choose another login"));
        return Navigator.toRegister();
=======
    public String register(){
        return "index";
>>>>>>> 1681fdae748a980611fd8b7fe5e51cde39d89517
    }
}
