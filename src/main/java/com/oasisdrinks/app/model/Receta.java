
package com.oasisdrinks.app.model;

import java.util.List;
//import java.util.ArrayList;

public class Receta {
    private int codReceta;
    private Producto codProducto; //Sino, como se sabe a que producto terminado corresponde?
    private int cantidad;
    private List<RecetaDetalle> detalles;

    public Receta(int codReceta, Producto codProducto, int cantidad, List<RecetaDetalle> detalles) {
        this.codReceta = codReceta;
        this.codProducto = codProducto;
        this.cantidad = cantidad;
        this.detalles = detalles;
    }

    public void agregarDetalle(RecetaDetalle detalle) {
        this.detalles.add(detalle);
    }

    public int getCodReceta() {
        return codReceta;
    }

    public void setCodReceta(int codReceta) {
        this.codReceta = codReceta;
    }

    public Producto getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(Producto codProducto) {
        this.codProducto = codProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public List<RecetaDetalle> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<RecetaDetalle> detalles) {
        this.detalles = detalles;
    }

    public void calcularCosto(){
        
    }
    

}
