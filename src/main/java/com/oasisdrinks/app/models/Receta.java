
package com.oasisdrinks.app.models;

import java.util.List;

public class Receta {
    private int codReceta;
    private int cantidad;
    private List<RecetaDetalle> detalles ;

    public Receta(int codReceta, int cantidad, List<RecetaDetalle> detalles) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    this.detalles = detalles;
    }

    public Receta(int codReceta, int cantidad) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    }
    
    public int getCodReceta() {return codReceta;}

    public void setCodReceta(int codReceta) {this.codReceta = codReceta;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;    }

    public List<RecetaDetalle> getdetalles(){
        return detalles;
    }

    //    public void setRecetaDetalle(List<RecetaDetalle> detalles){
    //    this.detalles= detalles;
    //}    

    public void agregarDetalle (RecetaDetalle detalle){
        detalles.add(detalle);
    }

    @Override
    public String toString() {
        return "Código de receta  : "+codReceta+
               "\nCantidad          : "+cantidad;
    }

    
    

    
    
    
}
