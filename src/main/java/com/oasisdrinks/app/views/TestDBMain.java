/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.oasisdrinks.app.views;
import com.oasisdrinks.app.dao.*;
import java.sql.SQLException;

/**
 *
 * @author shadowthrone
 */
public class TestDBMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ConnectionFactory conFactory = new HikariCPConnectionPool();
        TestDAO tdao = new TestDAO(conFactory.getConnection());
        tdao.testSelect();
    }
    
}
