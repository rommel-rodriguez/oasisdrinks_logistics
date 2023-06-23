
package com.oasisdrinks.app.models;
import java.util.Vector;

public class OrdenPPT {
    private int cantidad;
    private Vector<Receta> recetas = new Vector();
    
    public OrdenPPT(){    }

    public int getCantidad() {return cantidad;}
    public void setCantidad(int cantidad) {this.cantidad = cantidad;}
    
    public void AgregarReceta(Receta r){
        recetas.add(r);}
            
    public void MostrarListaReceta(){
            for(int pos=0; pos<recetas.size();pos++){
            System.out.println("Orden "+(pos+1));
            System.out.println(recetas.get(pos));}
    }
    
    
}

