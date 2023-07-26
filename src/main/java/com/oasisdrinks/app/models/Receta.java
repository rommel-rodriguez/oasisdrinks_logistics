
package com.oasisdrinks.app.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Receta implements Serializable  {
    private int codReceta;
    private int codProducto;
    private int cantidad = 1;
    private String observacion = "";
    
    private List<RecetaDetalle> detalles = new ArrayList<>();

    public Receta() {
    }

    public Receta(int codReceta) {
        this.codReceta = codReceta;
    }

    public Receta(int codReceta, int cantidad) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    }

    public Receta(int codReceta, int cantidad, List<RecetaDetalle> detalles) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    this.detalles = detalles;
    }

    
    public int getCodReceta() {return codReceta;}

    public void setCodReceta(int codReceta) {this.codReceta = codReceta;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;    }

    //    public void setRecetaDetalle(List<RecetaDetalle> detalles){
    //    this.detalles= detalles;
    //}    

    public void agregarDetalle (RecetaDetalle detalle){
        detalles.add(detalle);
    }

    public void setDetalles(List<RecetaDetalle> detalles) {
        this.detalles = detalles;
    }



    public List<RecetaDetalle> getDetalles() {
        return detalles;
    }

    public void removerDetalle(RecetaDetalle detalle) {
        detalles.remove(detalle);
    }

    public void updateDetalle(RecetaDetalle detalle) {
       detalles
           .stream()
           .filter( (det) -> det.equals(detalle))
           .findFirst()
           .ifPresent(
               (det) -> {
                   int index = detalles.indexOf(det);
                   detalles.set(index, det);
               }
           );
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }



    @Override
    public String toString() {
        return "Código de receta  : "+codReceta+
               "\nCantidad          : "+cantidad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    
}
