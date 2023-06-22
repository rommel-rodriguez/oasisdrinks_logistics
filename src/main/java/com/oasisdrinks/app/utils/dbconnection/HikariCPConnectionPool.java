/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.utils.dbconnection;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import com.oasisdrinks.app.config.ConfigurationManager;

/**
 *
 * @author shadowthrone
 */


public class HikariCPConnectionPool extends ConnectionFactory {

    private static Properties dbProperties = new ConfigurationManager().getProperties();
    private static HikariConfig config = new HikariConfig(dbProperties);

    private DataSource dataSource;

    public HikariCPConnectionPool() {
        init();
    }

    @Override
    protected void init() {
        this.initialized = true;
        dataSource = new HikariDataSource(config);
    }


    @Override
    public Connection getNewConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(HikariCPConnectionPool.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

