/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.utils.dbconnection;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class ConnectionFactory {
    boolean initialized;
    

    protected abstract void init();
    public abstract Connection getNewConnection() throws SQLException;
    // public abstract Connection getConnection() throws SQLException;

    public Connection getConnection() throws SQLException {

        Connection con = getNewConnection();

        return con;
    }
}
