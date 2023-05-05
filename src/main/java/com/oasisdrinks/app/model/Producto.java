
package com.oasisdrinks.app.model;

public class Producto extends SKU_Item {
    private int diasCaducidad;
    private double precioCosto;
    
    public Producto(String codigoItem, String nombre, double precioCosto,  int diasCaducidad) {
        super(codigoItem, nombre, precioCosto);
        this.precioCosto = precioCosto;
        this.diasCaducidad = diasCaducidad;
    }

    // Getters and setters for Producto
    public double getprecioCosto() {
        return precioCosto;
    }
    public void setprecioCosto(int precioCosto) {
        this.precioCosto = precioCosto;
    }
    public int getDiasCaducidad() {
        return diasCaducidad;
    }
    public void setDiasCaducidad(int diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }
}
