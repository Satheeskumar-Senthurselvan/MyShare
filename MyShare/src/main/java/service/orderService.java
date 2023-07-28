/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import databaseLayer.databaseConnection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.order;
/**
 *
 * @author satheeskumar
 */
public class orderService {
    private final databaseConnection  singleConn;
    public orderService(){
        singleConn=databaseConnection.getSingleInstance();
    }
    public boolean addOrder(order order1){
        try{
           String query = "INSERT INTO orderData VALUES ('" + order1.ordID + "','" + order1.cusName + "'," + order1.amount + ",'" + order1.dDate + "'," + order1.contactNO + ",'" + order1.email + "','" + order1.empID +"','"+ order1.proID+ "','"+ order1.supID +"')";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot insert a order");
            return false;
        }
    }
    public boolean updateOrder(order order1){
        try{
           String query = "update orderData set CusName ='" + order1.cusName + "',amount =" + order1.amount + ",dDate ='" + order1.dDate + "',cusContactNo =" + order1.contactNO + ",cusEmail ='" + order1.email + "',empID ='" + order1.empID +"',proID ='"+ order1.proID+ "',supID ='"+ order1.supID +"' where ordID ='" +order1.ordID+"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot insert a order");
            return false;
        }
    }
    public boolean deleteOrder(String orderID){
        try{
           String query = "delete from orderData where ordID ='" + orderID +"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot delete order");
            return false;
        }
    }
    public boolean addCount(String query){
        try{
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot insert a order");
            return false;
        }
    }
    public void setOrderData(DefaultTableModel DTM){
        ResultSet RS = singleConn.readQuery("select * from orderData");
        try{
            //ResultSetMetaData RSMD = RS.getMetaData();
            //int c = RSMD.getColumnCount();
            int a = 0;
            while(RS.next()){
                JButton JB = new JButton("Edit");
                DTM.setValueAt(RS.getString(1), a, 0);
                DTM.setValueAt(RS.getString(2), a, 1);
                DTM.setValueAt(RS.getString(3), a, 2);
                DTM.setValueAt(RS.getString(4), a, 3);
                DTM.setValueAt(RS.getString(5), a, 4);
                DTM.setValueAt(RS.getString(6), a, 5);
                DTM.setValueAt(RS.getString(7), a, 6);
                DTM.setValueAt(RS.getString(8), a, 7);
                DTM.setValueAt(RS.getString(9), a, 8);
                a++;
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    public void setEmpoyeeData(DefaultTableModel DTM){
        ResultSet RS = singleConn.readQuery("select * from employeeData");
        try{
            int a = 0;
            while(RS.next()){
                DTM.setValueAt(RS.getString(1), a, 0);
                DTM.setValueAt(RS.getString(2), a, 1);
                DTM.setValueAt(RS.getString(5), a, 2);
                a++;
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
}
