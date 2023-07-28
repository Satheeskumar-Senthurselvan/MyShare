/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;


import databaseLayer.databaseConnection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.supplier;

/**
 *
 * @author satheeskumar
 */
public class supplerService {
    private final databaseConnection  singleConn;
    
    public supplerService(){
        singleConn=databaseConnection.getSingleInstance();
    }
    
    public boolean addSupplier(supplier supplier1){
        try{
            String query = "insert into supplierData values ('" +supplier1.supplierID+ "','" +supplier1.supplierName+ "'," +supplier1.peyment+ "," +supplier1.NumOfProduct+ "," +supplier1.contactNo+ ",'" +supplier1.email+"','" +supplier1.productID+ "')";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot insert a supplier");
            return false;
        }
    }
    public boolean updateSupplier(supplier supplier1){
        try{
            String query = "update supplierData set supName ='"+supplier1.supplierName+ "',payment =" +supplier1.peyment+ ",quantity =" +supplier1.NumOfProduct+ ",empContactNo =" +supplier1.contactNo+ ",email ='" +supplier1.email+"',proID ='" +supplier1.productID+ "' where supID ='"+supplier1.supplierID+"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot update supplierData");
            return false;
        }
    }
    public boolean deleteSupplier(String supID){
        try{
           String query = "delete from supplierData where supID ='" + supID +"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot delete Supplier");
            return false;
        }
    }
    public void setSupplierData(DefaultTableModel DTM){
        ResultSet RS = singleConn.readQuery("select * from supplierData");
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
                a++;
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    
}
