/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.meet.jsf.dbconnector;

/**
 *
 * @author Piotr
 */
public interface IDbConnector {
    boolean connect();
    boolean disconnect();
    boolean validateUser();
    boolean registerUser();
    
}
