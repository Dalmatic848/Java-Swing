package com.example;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;



import java.sql.SQLException;
import java.sql.Statement;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;


import net.sf.jasperreports.engine.JRException;

import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;


public class ReportGenerator {
    public void generateReport(String reportPath, String outputFilePath) throws JRException, SQLException{
        Connection connect = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/kurs", "root", "988830");
            statement = connect.createStatement();
            
            if (reportPath.charAt(0) == 'G') {
                String sqlQuery = "SELECT * FROM kurs.games";
                resultSet = statement.executeQuery(sqlQuery);
            }
            else {
                String sqlQuery = "SELECT * FROM kurs.players";
                resultSet = statement.executeQuery(sqlQuery);
            }
            
            // Создание источника данных на основе ResultSet
            JRResultSetDataSource dataSource = new JRResultSetDataSource(resultSet);

            // Компиляция JRXML в JasperReport
            File file = new File(reportPath);
            if (!file.exists()) {
                throw new RuntimeException("Файл отчета не найден: " + reportPath);
            }
            JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

            // Заполнение отчета данными
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, new HashMap<>(), dataSource);

            // Экспорт отчета в PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, outputFilePath);

        } finally {
            // Закрытие ресурсов
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        }
    }
} 

