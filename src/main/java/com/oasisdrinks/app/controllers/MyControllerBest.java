/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class MyControllerBest implements ActionListener, ListSelectionListener {
    private Model model;
    private View view;
    
    public MyControllerBest(Model model, View view) {
        this.model = model;
        this.view = view;
        
        // Add action listeners to GUI components
        this.view.getSaveButton().addActionListener(this);
        this.view.getLoadButton().addActionListener(this);
        this.view.getTable().getSelectionModel().addListSelectionListener(e -> handleTableSelection());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSaveButton()) {
            // Handle save button event
            // Access model and view to perform necessary operations
        } else if (e.getSource() == view.getLoadButton()) {
            // Handle load button event
            // Access model and view to perform necessary operations
        }
    }
    
    private void handleTableSelection() {
        // Handle table selection event
        // Access model and view to perform necessary operations
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
