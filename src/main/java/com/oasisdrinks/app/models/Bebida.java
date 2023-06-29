
package com.oasisdrinks.app.models;


public class Bebida extends Producto{

    public Bebida() { 
        super();
        setTipo("bebida");
    }

    public Bebida(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, Receta receta, double margenGanancia) {
        super(codProducto, nomProducto, cantProducto, diasCaducidad, receta, margenGanancia);
        setTipo("bebida");
    }

    public Bebida(int codProducto, String nomProducto) {
        super(codProducto, nomProducto);
        setTipo("bebida");
    }

    
}
