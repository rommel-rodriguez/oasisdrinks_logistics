/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.ErrorView;
import com.oasisdrinks.app.views.InsumoView;
import com.oasisdrinks.app.views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class MainController implements ActionListener {
    private MainView view = null;

    public MainController(MainView view) {
        this.view = view;
        this.view.getInsumosBtn().addActionListener(this);
        this.view.getMedidasBtn().addActionListener(this);
        this.view.getUsuariosBtn().addActionListener(this);
        this.view.getProductosBtn().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if ( source == view.getInsumosBtn()) {
            showInsumosView();
        } else if ( source == this.view.getMedidasBtn() ) {
            System.out.println("[DEBUG]  Delete button pressed");
        } else if ( source ==  view.getUsuariosBtn()) {
            System.out.println("[DEBUG]  Update button pressed");
        } else if ( source ==  view.getProductosBtn()) {
            System.out.println("[DEBUG]  Filter button pressed");
        } 
    }

    public void showInsumosView() {
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
        InsumoController controller = new InsumoController(insumoSrv, view);

        view.setLocationRelativeTo(null); // Center the frame
        view.setVisible(true);
    }

}
