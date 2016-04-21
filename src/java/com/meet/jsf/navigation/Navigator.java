/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.navigation;


/**
 *
 * @author Piotr
 */
public class Navigator {
    private Navigator(){}
    
    public static String toIndex(){
        return "index";
    }
    
    public static String toLogin(){
        return "login";
    }
    
    public static String toRegister(){
        return "register";
    }
    
    public static String toAccount(){
        return "account";
    }
}
