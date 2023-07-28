/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.supplier;
import service.supplerService;//

/**
 *
 * @author satheeskumar
 */
public class supplierController {
    supplier supplierObj;
    supplerService service;
    
    public supplierController(){
        service = new supplerService();
    }
    
    public supplier addSupplier(String supplierID, String supplierName, double peyment, int NumOfProduct, int contactNo, String email, String productID){
        supplierObj = new supplier(supplierID, supplierName, peyment, NumOfProduct, contactNo, email, productID);
        return supplierObj;
    }
    public boolean addSupplierToDatabase(){
        return service.addSupplier(supplierObj);
    }
    
    public supplier updateSupplier(String supplierID, String supplierName, double peyment, int NumOfProduct, int contactNo, String email, String productID){
        supplierObj = new supplier(supplierID, supplierName, peyment, NumOfProduct, contactNo, email, productID);
        return supplierObj;
    }
    public boolean updateSupplierToDatabase(){
        return service.updateSupplier(supplierObj);
    }
    
    public void getSupplierData(DefaultTableModel DTM){
        service.setSupplierData(DTM);
    }
    
}
