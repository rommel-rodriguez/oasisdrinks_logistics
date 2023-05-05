
package com.oasisdrinks.app.model;

import java.util.List;

public class Receta {
    private String idProducto;
    private int cantidad;
    

    public Receta(String idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        
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
}
