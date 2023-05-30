
package com.oasisdrinks.app.model;

public class Receta {
    private String codReceta;
    private int cantidad;
    //private RecetaDetalle detalles ;

    /*public Receta(String codReceta, int cantidad, RecetaDetalle detalles) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    this.detalles = detalles;
    }*/
    public Receta(String codReceta, int cantidad) {
    this.codReceta = codReceta;    
    this.cantidad = cantidad;
    }
    
    public String getCodReceta() {return codReceta;}
    public void setCodReceta(String codReceta) {this.codReceta = codReceta;}

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;    }

    /*public RecetaDetalle getdetalles(){
        return detalles;
    }
        public void setRecetaDetalle(RecetaDetalle detalles){
        this.detalles= detalles;
    }    
    public void agregarDetalle (RecetaDetalle x){
        detalles.add(x);
    }*/

    @Override
    public String toString() {
        return "Código de receta  : "+codReceta+
               "\nCantidad          : "+cantidad;
    }

    
    

    
    
    
}
