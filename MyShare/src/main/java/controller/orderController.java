/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import javax.swing.table.DefaultTableModel;
import model.order;
import service.orderService;

/**
 *
 * @author satheeskumar
 */
public class orderController {
    
    order orderObj;
    orderService service;
    
    public orderController(){
        service = new orderService();
    }
    
    public order addOrder(String ordID, String cusName, double amount, String dDate, int contactNO, String email, String empID, String proID, String supID){
        orderObj = new order(ordID, cusName, amount, dDate, contactNO, email, empID, proID, supID);
        return orderObj;
    }
    
    public order updateOrder(String ordID, String cusName, double amount, String dDate, int contactNO, String email, String empID, String proID, String supID){
        orderObj = new order(ordID, cusName, amount, dDate, contactNO, email, empID, proID, supID);
        return orderObj;
    }
    public boolean addOrderToDatabase(){
        return service.addOrder(orderObj);
    }
    
    public void getOrderData(DefaultTableModel DTM){
        service.setOrderData(DTM);
    }
    public boolean updateOrderToDatabase(){
        return service.updateOrder(orderObj);
    }
     
    public void getEmployeeData(DefaultTableModel DTM){
        service.setEmpoyeeData(DTM);
    }
    
}
