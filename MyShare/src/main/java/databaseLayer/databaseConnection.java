/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databaseLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author satheeskumar
 */
public class databaseConnection {
    private final String URL="jdbc:mysql://localhost:3307/MyShare";
    private final String UName="root";
    private final String Password="";
    private static databaseConnection instance;
    private Connection con;
    
     private databaseConnection()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con= DriverManager.getConnection(URL,UName,Password);
            System.out.println("Database Connection Sucess");
        }catch (ClassNotFoundException ex)
        {
            System.out.println("Driver Class Error "+ex.getMessage());
        }catch (SQLException ex)
        {
            System.out.println("Database Connection Error "+ex.getMessage());
        }
    }
    public static databaseConnection getSingleInstance()//Singleton Design Pattern
    {
        try {
            if (instance == null) {
                instance = new databaseConnection();
            } else if (instance.con.isClosed()) {
                instance = new databaseConnection();
            }else{
                return instance;
            }
            return instance;
        }catch (SQLException ex)
        {
            System.out.println("Database Connection Error "+ex.getMessage());
            return null;
        }
    }
    public boolean ExecuteQuery(String sqlQ)
    {
        try
        {
            Statement st=con.createStatement();
            int result=st.executeUpdate(sqlQ);
            return result>0;
        }catch (SQLException ex)
        {
            System.out.println("SQL Error "+ex.getMessage());
            return false;
        }
    }
    public ResultSet readQuery(String sql){
        try{
            Statement st = con.createStatement();
            ResultSet RS = st.executeQuery(sql);
            return RS;
        }catch(SQLException e){
            System.out.println("SQL Error : "+e.getMessage());
            return null;
        } 
    }
    
}
