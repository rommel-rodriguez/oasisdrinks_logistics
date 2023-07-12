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

public class MyController implements ActionListener {
    private MyView view;

    public MyController(MyView view) {
        this.view = view;
        this.view.addSaveButtonListener(this);
        this.view.addLoadButtonListener(this);
        // Add listeners for other buttons and elements
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getSaveButton()) {
            // Handle save button event
            // Logic to save data or perform related actions
            System.out.println("Save button clicked");
        } else if (e.getSource() == view.getLoadButton()) {
            // Handle load button event
            // Logic to load data or perform related actions
            System.out.println("Load button clicked");
        }
        // Handle events from other buttons and elements
    }
}