
package com.oasisdrinks.app.models;

import java.io.Serializable;


public class Bebida extends Producto implements Serializable {

    public Bebida() { 
        super();
        setTipo("bebida");
    }

    public Bebida(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, String tipo, int estado, Medida medida) {
        super(codProducto, nomProducto, cantProducto, diasCaducidad, tipo, estado, medida);
    }


    public Bebida(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, Receta receta, double margenGanancia) {
        super(codProducto, nomProducto, cantProducto, diasCaducidad, receta, margenGanancia);
        setTipo("bebida");
    }

    public Bebida(int codProducto, String nomProducto) {
        super(codProducto, nomProducto);
        setTipo("bebida");
    }

    public Bebida(int codProducto, String nomProducto, int cantProducto, int diasCaducidad, double margenGanancia) {
        super(codProducto, nomProducto, cantProducto, diasCaducidad, margenGanancia);
        setTipo("bebida");
    }



    
}
