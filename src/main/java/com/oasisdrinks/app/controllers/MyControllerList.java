/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyControllerList implements ActionListener, ListSelectionListener {
    private MyView view;

    public MyControllerList(MyView view) {
        this.view = view;
        this.view.addActionListener(this);
        this.view.addTableSelectionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSaveButton()) {
            // Handle save button event
            System.out.println("Save button clicked");
        } else if (e.getSource() == view.getLoadButton()) {
            // Handle load button event
            System.out.println("Load button clicked");
        }
        // Handle events from other buttons and elements in the view
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && e.getSource() == view.getTable().getSelectionModel()) {
            // Handle table selection event
            int selectedRow = view.getTable().getSelectedRow();
            if (selectedRow >= 0) {
                // Perform actions based on the selected row
                System.out.println("Selected row: " + selectedRow);
            }
        }
    }
}
