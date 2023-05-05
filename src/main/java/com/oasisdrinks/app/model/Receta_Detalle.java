
package com.oasisdrinks.app.model;

public class Receta_Detalle {
    private Insumo insumo;
    private int cantidad;

    public Receta_Detalle(Insumo insumo, int cantidad) {
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
}
