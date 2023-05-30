package com.oasisdrinks.app.model;


public class RecetaDetalle {
    private Insumo insumo;
    private int cantidad;

    public RecetaDetalle(Insumo insumo, int cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void Preparacion(){
        System.out.println("Mostrar preparacion");
    }
}