package com.oasisdrinks.app.model;

public class Insumo extends SKUItem {
    private String nomInsumo;
    private int cantInsumo;
    private String unidadCompra;
    
    public Insumo(String codigoItem, String nombre, Double precioCosto, String nomInsumo, int cantInsumo, String unidadCompra) {
        super(codigoItem, nombre, precioCosto);
        this.nomInsumo = nomInsumo;
        this.cantInsumo = cantInsumo;
        this.unidadCompra = unidadCompra;
    }

    public String getNomInsumo() {
        return nomInsumo;
    }

    public void setNomInsumo(String nomInsumo) {
        this.nomInsumo = nomInsumo;
    }

    public int getCantInsumo() {
        return cantInsumo;
    }

    public void setCantInsumo(int cantInsumo) {
        this.cantInsumo = cantInsumo;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }
}
