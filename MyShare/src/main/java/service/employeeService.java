/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import databaseLayer.databaseConnection;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.employee;

/**
 *
 * @author satheeskumar
 */
public class employeeService {
    private final databaseConnection  singleConn;
    
    public employeeService(){
        singleConn=databaseConnection.getSingleInstance();
    }
    
    public boolean addEmployee(employee employee1){
        try{
            String query = "insert into EmployeeData values ('" +employee1.empID+ "','" +employee1.empName+ "'," +employee1.ContactNo+ ",'" +employee1.email+ "'," +employee1.MOCount+")";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot insert a Employee");
            return false;
        }
    }
    public boolean updateEmployee(employee employee1){
        try{
            String query = "update EmployeeData set empName ='"+employee1.empName+ "',empContactNo =" +employee1.ContactNo+ ",email ='" +employee1.email+ "',MOCount =" +employee1.MOCount+" where empID = '"+employee1.empID+"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot update  Employee");
            return false;
        }
    }
    public boolean deleteEmployee(String empID){
        try{
           String query = "delete from employeeData where empID ='" + empID +"'";
            boolean result = singleConn.ExecuteQuery(query);
            return result;
        }catch(Exception e){
            System.out.println("Cannot delete Employee");
            return false;
        }
    }
    public void setEmployeeData(DefaultTableModel DTM){
        ResultSet RS = singleConn.readQuery("select * from employeeData");
        try{
            int a = 0;
            while(RS.next()){
                JButton JB = new JButton("Edit");
                DTM.setValueAt(RS.getString(1), a, 0);
                DTM.setValueAt(RS.getString(2), a, 1);
                DTM.setValueAt(RS.getString(3), a, 2);
                DTM.setValueAt(RS.getString(4), a, 3);
                DTM.setValueAt(RS.getString(5), a, 4);
                a++;
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    
}
