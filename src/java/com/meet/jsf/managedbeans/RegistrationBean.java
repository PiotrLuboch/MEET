/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author Piotr
 */
@ManagedBean
@RequestScoped
public class RegistrationBean {

    @Pattern(regexp = "^\\w*$", message = "Login can contain only letters and numbers")
    @Size(min = 4, max = 16, message = "Login length must be in range from 4 to 16")
    private String login;
    
    @Size(min = 4, max = 16, message = "Password length must be in range from 4 to 16")
    private String password;
    
    @Pattern(regexp = "^.+@.+$", message = "Email should match pattern: user@domain")
    private String email;

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
    public String register(){
        return "index";
    }
}
