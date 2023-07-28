/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author satheeskumar
 */
public class employee {
    public String empID;
    public String empName; 
    public int ContactNo; 
    public String email;
    public int MOCount;
    
    public employee(String empID, String empName, int ContactNo, String email, int MOCount){
        this.empID =  empID;
        this.empName =   empName;
        this.ContactNo = ContactNo;
        this.email =  email; 
        this.MOCount = MOCount;
    }
    
}
