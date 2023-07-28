/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import databaseLayer.databaseConnection;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author satheeskumar
 */
public class salesReportService {
    
    private final databaseConnection  singleConn;
     
    public salesReportService(){
        singleConn=databaseConnection.getSingleInstance();
    }
    public void setSalesReportData(DefaultTableModel DTM) {
        ResultSet RS = singleConn.readQuery("SELECT orderData.ordID, productData.proID, employeeData.empID, supplierData.supID, supplierData.payment, orderData.amount FROM orderData JOIN employeeData ON orderData.empId = employeeData.empID JOIN productData ON orderData.proID = productData.proID JOIN supplierData ON orderData.supID = supplierData.supID");
        try {
            int a = 0;
            while (RS.next()) {
                String ordID = RS.getString(1);
                String proID = RS.getString(2);
                String empID = RS.getString(3);
                String supID = RS.getString(4);
                String payment = RS.getString(5);
                String amount = RS.getString(6);
            
                double profit = Double.parseDouble(amount) - Double.parseDouble(payment);
                String profit1 = Double.toString(profit);
            
                DTM.setValueAt(ordID, a, 0);
                DTM.setValueAt(proID, a, 1);
                DTM.setValueAt(empID, a, 2);
                DTM.setValueAt(supID, a, 3);
                DTM.setValueAt(payment, a, 4);
                DTM.setValueAt(amount, a, 5);
                DTM.setValueAt(profit1, a, 6);
            
                a++;
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    }

    
}
