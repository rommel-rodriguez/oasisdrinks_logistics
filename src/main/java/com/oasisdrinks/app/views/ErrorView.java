/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.views;

import javax.swing.JOptionPane;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class ErrorView {
    private String title = null;
    private String message = null;

    public ErrorView() {
    }

    public ErrorView(String title, String message) {
        this.title = title;
        this.title = "ERROR: " + title;
        this.message = message;
        show();
    }

    public void show() {
        JOptionPane.showMessageDialog(
            null,
                        this.message,
                        this.title,
               JOptionPane.ERROR_MESSAGE 
        );
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
