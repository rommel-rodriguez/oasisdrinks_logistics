/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.intellijthemes.FlatMaterialDesignDarkIJTheme;
import javax.swing.*;

import com.oasisdrinks.app.controllers.InsumoController;
import com.oasisdrinks.app.controllers.InsumoFixedController;
import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.ErrorView;
import com.oasisdrinks.app.views.InsumoView;
import javax.naming.CommunicationException;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class Main {
    public static void main(String[] args) {

        setTheme();
        InsumoDao insumoDao = null;
        try{
            insumoDao = new InsumoDao( new MySQLPool());
        } catch (Exception e) {
            // NOTE: I am assuming tthis will be a MySQL communications exception
            new ErrorView("Database Conexion", "No se pudo establecer connection con la Base de Datos");
            return;
        }
        InsumoService insumoSrv = new InsumoService(insumoDao);
        InsumoView view = new InsumoView();
        InsumoFixedController controller = new InsumoFixedController(insumoSrv, view);

        view.setVisible(true);
    }

    private static void init () {

    }

    private static void setTheme () {
        try {
            // UIManager.setLookAndFeel(new FlatDarkLaf());
            // UIManager.setLookAndFeel(new FlatDarculaLaf());
            UIManager.setLookAndFeel(new FlatMaterialDesignDarkIJTheme());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}