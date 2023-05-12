
package com.oasisdrinks.app.model;

public class OrdenPPT {
    private Receta receta;
    private int cantidad;

    public OrdenPPT(Receta receta, int cantidad) {
        this.receta = receta;
        this.cantidad = cantidad;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
