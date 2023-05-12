
package com.oasisdrinks.app.model;

import java.util.List;

public class Receta {
    private String idProducto;
    private int cantidad;
    private List<RecetaDetalle> detalles;

    public Receta(String idProducto, int cantidad, List<RecetaDetalle> detalles) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.detalles = detalles;
    }

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
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

    public void agregarDetalle(RecetaDetalle detalle) {
        this.detalles.add(detalle);
    }
}
