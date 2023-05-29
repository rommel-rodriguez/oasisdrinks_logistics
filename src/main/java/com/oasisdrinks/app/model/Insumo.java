package com.oasisdrinks.app.model;

public abstract class Insumo{
    //private String codigoIndumo;
    //private String nombre;
    int codInsumo;
    protected String nomInsumo;
    protected int cantInsumo;
    protected String unidadCompra;
    protected double precioCosto;

    //public Insumo(int codInsumo, String nomInsumo, int cantInsumo, String unidadCompra) {
    public Insumo(int codInsumo, String nomInsumo, int cantInsumo, String unidadCompra, 
            double precioCosto) {
        this.codInsumo = codInsumo;
        this.nomInsumo = nomInsumo;
        this.cantInsumo = cantInsumo;
        this.unidadCompra = unidadCompra;
        this.precioCosto = precioCosto;
    }
    
    public Insumo(int cantInsumo) {
        this.cantInsumo = cantInsumo;
    }

    public int getCodInsumo() {
        return codInsumo;
    }

    public void setCodInsumo(int codInsumo) {
        this.codInsumo = codInsumo;
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
    
    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }
}
