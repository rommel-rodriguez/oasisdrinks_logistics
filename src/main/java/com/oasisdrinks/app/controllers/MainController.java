/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.ErrorView;
import com.oasisdrinks.app.views.InsumoView;
import com.oasisdrinks.app.views.MainView;
import com.oasisdrinks.app.views.MedidaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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
            //System.out.println("[DEBUG]  Delete button pressed");
            showMedidasView();
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
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        InsumoController controller = new InsumoController(insumoSrv, view);


        view.setLocationRelativeTo(null); // Center the frame
        view.setVisible(true);
    }

    public void showMedidasView() {
        MedidaDao medidaDao = null;
        try{
            medidaDao = new MedidaDao( new MySQLPool());
        } catch (Exception e) {
            // NOTE: I am assuming tthis will be a MySQL communications exception
            new ErrorView("Database Conexion", "No se pudo establecer connection con la Base de Datos");
            System.out.println("[DEBUG] What is happening here 0");
            return;
        }

        System.out.println("[DEBUG] What is happening here 1");
        MedidaService medidaSrv = new MedidaService(medidaDao);
        MedidaView view = new MedidaView();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        MedidaController controller = new MedidaController(medidaSrv, view);

        view.setLocationRelativeTo(null); // Center the frame
        view.setVisible(true);
    }

}
