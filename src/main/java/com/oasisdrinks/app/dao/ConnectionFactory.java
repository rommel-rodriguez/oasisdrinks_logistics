/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author shadowthrone
 */
public abstract class ConnectionFactory {
    boolean initialized;
    

    protected abstract void init();
    public abstract Connection getNewConnection();
    // public abstract Connection getConnection() throws SQLException;

    public Connection getConnection() throws SQLException {

        if (!this.initialized)
            this.init();

        // NOTE: Maybe surround this with try/catch
        Connection con = getNewConnection();

        return con;
    }
}
