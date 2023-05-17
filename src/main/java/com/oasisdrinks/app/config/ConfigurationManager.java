/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author shadowthrone
 */
public class ConfigurationManager {
    private static final String CONFIG_FILE = "database.properties";
    private Properties properties;

    public ConfigurationManager() {
        properties = new Properties();
        try (InputStream inputStream = ConfigurationManager.class.getResourceAsStream(CONFIG_FILE)) {
            properties.load(inputStream);
        } catch (IOException e) {
            // Handle the exception appropriately
        }
    }

    public String getProperty(String key) {
        return getProperties().getProperty(key);
    }

    /**
     * @return the properties
     */
    public Properties getProperties() {
        return properties;
    }

    
}
