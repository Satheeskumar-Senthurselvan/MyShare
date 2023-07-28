/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.table.DefaultTableModel;
import model.employee;
import service.employeeService;

/**
 *
 * @author satheeskumar
 */
public class employeeController {
    employee employeeObj;
    employeeService service;
    
    public employeeController(){
        service = new employeeService();
    }
    public employee addEmployee(String empID, String empName, int ContactNo, String email, int MOCount){
        employeeObj = new employee(empID, empName, ContactNo, email, MOCount);
        return employeeObj;
    }
    public boolean addEmployeeToDatabase(){
        return service.addEmployee(employeeObj);
    }
    
    public employee updateEmployee(String empID, String empName, int ContactNo, String email, int MOCount){
        employeeObj = new employee(empID, empName, ContactNo, email, MOCount);
        return employeeObj;
    }
    public boolean updateEmployeeToDatabase(){
        return service.updateEmployee(employeeObj);
    }
    public void getEmployeeData(DefaultTableModel DTM){
        service.setEmployeeData(DTM);
    }
    

    
}
