package com.oasisdrinks.app.model;

public class Medida {
    private int id;
    private String nombre;
    private String abrev;

    public Medida() {

    }

    public Medida(int id, String nombre, String abrev) {
        this.id = id;
        this.nombre = nombre;
        this.abrev = abrev;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAbrev() {
        return abrev;
    }

    public void setAbrev(String abrev) {
        this.abrev = abrev;
    }

    @Override
    public String toString() {
        return "Medida{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
