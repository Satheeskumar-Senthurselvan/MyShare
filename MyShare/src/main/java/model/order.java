/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author satheeskumar
 */
public class order {
    public String ordID;
    public String cusName;
    public double amount;
    public String dDate;
    public int contactNO;
    public String  email;
    public String empID;
    public String proID;
    public String supID;
    
    public order(String ordID, String cusName, double amount, String dDate, int contactNO, String email, String empID, String proID, String supID){
        this.ordID =  ordID;
        this.cusName =  cusName;
        this.amount = amount;
        this.dDate = dDate;
        this.contactNO = contactNO; 
        this.email = email;
        this.empID = empID;
        this.proID = proID;
        this.supID = supID;
    }
    
}
