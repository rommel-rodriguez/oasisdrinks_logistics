
package com.oasisdrinks.app.model;

public class SKU_Item {
    private String codigoItem;
    private String nombre;
    private double precioCosto;
    
    public SKU_Item(String codigoItem, String nombre, double precioCosto) {
        this.codigoItem = codigoItem;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
    }

    // Just boilerplate
    public String getCodigoItem() {
        return codigoItem;
    }
    public void setCodigoItem(String codigoItem) {
        this.codigoItem = codigoItem;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioCosto() {
        return precioCosto;
    }
    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
}
