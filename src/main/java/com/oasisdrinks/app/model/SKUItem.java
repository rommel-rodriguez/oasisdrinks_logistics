
package com.oasisdrinks.app.model;
public class SKUItem {
    private String codigoItem;
    private String nombre;
    private Double precioCosto;
    
    public SKUItem(String codigoItem, String nombre, Double precioCosto) {
        this.codigoItem = codigoItem;
        this.nombre = nombre;
        this.precioCosto = precioCosto;
    }

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

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }
}

