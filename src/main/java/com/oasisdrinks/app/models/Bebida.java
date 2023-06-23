
package com.oasisdrinks.app.models;


public class Bebida extends Producto{
    private  String typoProducto;
//constructor
    public Bebida() {    }

//get y set
    public String getTypoProducto() {return typoProducto;}
    public void setTypoProducto(String typoProducto) {this.typoProducto = typoProducto;}
    
    public double Costo(){
        return(cantProducto*precioVenta);
        
    }
    public String MostrarCosto() {
        return "El precio de la bebida es : "+Costo();
    }

    
    
    
    
}
