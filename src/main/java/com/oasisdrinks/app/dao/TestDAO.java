/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import java.sql.*;

/**
 *
 * @author shadowthrone
 */
public class TestDAO {
    private Connection con;

    public TestDAO(Connection con) {
        this.con = con;
    }

    public void testSelect() throws SQLException {
        String stmt = "SELECT * FROM person";
        ResultSet rs;    
        PreparedStatement ps;
        ps = con.prepareStatement(stmt);
        rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString("email"));
        }
    }
    
}
