/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import java.io.Serializable;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public abstract class Persona implements Serializable {
    protected int id = 0;
    protected String nombres = null;
    protected String apellidos = null;
    protected String email = null;

    public Persona() {
    }

    public Persona(int id) {
        this.id = id;
    }


    public Persona( String nombres, String apellidos) {
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public Persona( String nombres, String apellidos, String email) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
}
