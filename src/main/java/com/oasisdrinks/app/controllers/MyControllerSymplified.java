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

public class MyControllerSymplified implements ActionListener {
    private MyView view;

    public MyControllerSymplified(MyView view) {
        this.view = view;
        this.view.addActionListener(this);
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
}
