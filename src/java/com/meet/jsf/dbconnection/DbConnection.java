package com.meet.jsf.dbconnection;

import java.sql.*;

public class DbConnection
{
    private static final String user = "letscodewro05";
    private static final String pass = "admin123";
    private static final String dbClass = "com.mysql.jdbc.Driver";
    private static final String dbDriver = "jdbc:mysql://www.db4free.net:3306/letscodewro05";
    
    static private Connection conn = null;  
    
    public static Connection connect() 
    {
    //load driver
        try 
        {
             Class.forName(dbClass).newInstance();
            //System.out.println("driver loaded"); // THIS IS BEING RETURNED
        } 
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) 
        {
            System.err.println(ex);
        }
    // Connection
          try 
          {
            conn = DriverManager.getConnection(dbDriver, user, pass);
            //System.out.println("connected"); // THIS IS NOT BEING RETURNED
          } 
           catch (SQLException ex) 
           {
             System.out.println("SQLException: " + ex.getMessage());
           }
        return conn;
    }
    public static void disconnect() {
    if (conn != null) {
        try {
            conn.close();
            conn = null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
    
}
