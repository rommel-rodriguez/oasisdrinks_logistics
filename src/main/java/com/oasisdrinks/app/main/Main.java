/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.main;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import javax.swing.*;

import com.oasisdrinks.app.controllers.InsumoController;
import com.oasisdrinks.app.controllers.InsumoController;
import com.oasisdrinks.app.controllers.MainController;
import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.ErrorView;
import com.oasisdrinks.app.views.InsumoView;
import com.oasisdrinks.app.views.MainView;
import java.awt.Color;
import javax.naming.CommunicationException;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class Main {
    public static void main(String[] args) {

        setTheme();
        MainView mainView = new MainView();
        MainController mainCtrl = new MainController(mainView);
        mainView.setVisible(true);
    }

    private static void init () {

    }

    private static void setTheme () {
        try {

            UIManager.setLookAndFeel(new FlatMaterialDesignDarkIJTheme());
            int fontSize = 20; // Set your desired font size here
            int buttonFontSize= 16; // Set your desired font size here
            int tableFontSize = 16; // Set your desired font size here
            int inputFontSize = 16; // Set your desired font size here
            UIManager.put("Label.font", UIManager.getFont("Label.font").deriveFont((float) fontSize));
            UIManager.put("Button.font", UIManager.getFont("Button.font").deriveFont((float) buttonFontSize));
            UIManager.put("TextField.font", UIManager.getFont("TextField.font").deriveFont((float) inputFontSize));
            UIManager.put("Table.font", UIManager.getFont("Table.font").deriveFont((float) tableFontSize));
            UIManager.put("TableHeader.font", UIManager.getFont("TableHeader.font").deriveFont((float) tableFontSize));
            UIManager.put("Button.select", Color.YELLOW);
            UIManager.put("TableHeader.background", Color.DARK_GRAY); // Set background color
            UIManager.put("TableHeader.foreground", Color.WHITE); 
            Color hoverColor = new Color(92, 99, 106);
            UIManager.put("TableHeader.hoverBackground", hoverColor);
            Color alternateRowColor = new Color(50, 50, 50); // Custom color
            UIManager.put("Table.alternateRowColor", alternateRowColor);

            // Set the color for labels
            UIManager.put("Label.foreground", Color.GREEN);

            // Set the color for text fields
            UIManager.put("TextField.background", Color.LIGHT_GRAY);
            UIManager.put("TextField.foreground", Color.BLACK);
   

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}