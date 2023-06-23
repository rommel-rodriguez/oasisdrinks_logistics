package com.oasisdrinks.app.models;

public abstract class Insumo{
    //private String codigoIndumo;
    //private String nombre;
    int codInsumo;
    protected String nomInsumo;
    protected int cantInsumo;
    private Medida medidaCompra;
    protected double precioCosto;

    public Insumo(int codInsumo, String nomInsumo, int cantInsumo, Medida medidaCompra, 
            double precioCosto) {
        this.codInsumo = codInsumo;
        this.nomInsumo = nomInsumo;
        this.cantInsumo = cantInsumo;
        this.medidaCompra = medidaCompra;
        this.precioCosto = precioCosto;
    }
    
    public Insumo(int cantInsumo) {
        this.cantInsumo = cantInsumo;
    }

    public Insumo() {

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

    
    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Medida getMedidaCompra() {
        return medidaCompra;
    }

    public void setMedidaCompra(Medida medidaCompra) {
        this.medidaCompra = medidaCompra;
    }
}
