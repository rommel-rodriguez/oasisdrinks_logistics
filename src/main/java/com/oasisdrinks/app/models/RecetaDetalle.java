package com.oasisdrinks.app.models;

import java.io.Serializable;


public class RecetaDetalle  implements Serializable {
    private Insumo insumo;
    private double cantidad;
    private int codReceta;

    public RecetaDetalle() {
    }

    public RecetaDetalle(Insumo insumo, double cantidad, int codReceta) {
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.codReceta = codReceta;
    }

    public RecetaDetalle(Insumo insumo, double cantidad) {
        this.insumo = insumo;
        this.cantidad = cantidad;
    }


    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }
    
    public void Preparacion(){
        System.out.println("Mostrar preparacion");
    }

    @Override
    public boolean equals(Object obj) {
        if ( !(obj.getClass() == getClass()) )
            return false;
        RecetaDetalle other = (RecetaDetalle) obj;
        // NOTE: This might need to be changed to include some product identifier
        if (other.getInsumo().getNomInsumo() == getInsumo().getNomInsumo())
            return true;

        return false;
    }

    public int getCodReceta() {
        return codReceta;
    }

    public void setCodReceta(int codReceta) {
        this.codReceta = codReceta;
    }

}