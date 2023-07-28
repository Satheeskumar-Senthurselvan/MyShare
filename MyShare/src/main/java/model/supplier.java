/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author satheeskumar
 */
public class supplier {
    public String supplierID;
    public String supplierName;
    public double peyment;
    public int NumOfProduct;
    public int contactNo;
    public String email;
    public String productID;
    
    public supplier(String supplierID, String supplierName, double peyment, int NumOfProduct, int contactNo, String email, String productID){
        this.supplierID =  supplierID;
        this.supplierName =   supplierName;
        this.peyment = peyment;
        this.NumOfProduct =  NumOfProduct; 
        this.contactNo = contactNo;
        this.email = email;
        this.productID = productID;
        
    }
    
}
