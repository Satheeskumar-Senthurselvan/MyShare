/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.swing.table.DefaultTableModel;
import service.salesReportService;

/**
 *
 * @author satheeskumar
 */
public class salesReportController {
    salesReportService service;
    
    public salesReportController(){
        service = new salesReportService();
    }
    public void getSalesReportData(DefaultTableModel DTM){
        service.setSalesReportData(DTM);
    }
    
}
