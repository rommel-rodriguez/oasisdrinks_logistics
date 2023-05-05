package com.oasisdrinks.app.model;

public class Insumo extends SKU_Item {
    private String unidadCompra;
    
    public Insumo(String codigoItem, String nombre, double precioCosto, String unidadCompra) {
        super(codigoItem, nombre, precioCosto);
        this.unidadCompra = unidadCompra;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }
    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }
}

