
package com.oasisdrinks.app.model;
public class Producto extends SKUItem {
    private Double precioVenta;
    private String nomProducto;
    private int cantProducto;
    private int diasCaducidad;
    
    public Producto(String codigoItem, String nombre, Double precioCosto, Double precioVenta, String nomProducto, int cantProducto, int diasCaducidad) {
        super(codigoItem, nombre, precioCosto);
        this.precioVenta = precioVenta;
        this.nomProducto = nomProducto;
        this.cantProducto = cantProducto;
        this.diasCaducidad = diasCaducidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public int getCantProducto() {
        return cantProducto;
    }

    public void setCantProducto(int cantProducto) {
        this.cantProducto = cantProducto;
    }

    public int getDiasCaducidad() {
        return diasCaducidad;
    }

    public void setDiasCaducidad(int diasCaducidad) {
        this.diasCaducidad = diasCaducidad;
    }
}
