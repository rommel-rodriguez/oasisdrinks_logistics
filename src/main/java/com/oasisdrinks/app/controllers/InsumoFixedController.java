/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.service.InsumoService;
import com.oasisdrinks.app.views.InsumoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class InsumoFixedController implements ActionListener, ListSelectionListener {

    private InsumoService insumoService;
    private InsumoView view;

    public InsumoFixedController(InsumoService insumoService, InsumoView view) {
        this.insumoService = insumoService;
        this.view = view;
        // Set up event listeners and other initialization
        // ...
    }

    public void addInsumo(Insumo insumo) {
        insumoService.addInsumo(insumo);
    }

    public void updateInsumo(Insumo insumo) {
        insumoService.updateInsumo(insumo);
    }

    public void deleteInsumo(int id) {
        insumoService.deleteInsumo(id);
    }

    // Other methods for interacting with the service layer

    public void refreshView() {
        List<Insumo> insumos = insumoService.getAllInsumos();
        view.displayInsumos(insumos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
