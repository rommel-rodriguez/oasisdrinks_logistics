
package com.oasisdrinks.app.models;

import java.io.Serializable;


public class InsumoLiquido extends Insumo implements Serializable {
    private double densidad;

    public InsumoLiquido() {
    }
    

    public InsumoLiquido(double densidad, int codInsumo, String nomInsumo, 
            int cantInsumo, Medida medidaCompra, double precioCosto) {
        super(codInsumo, nomInsumo, cantInsumo, medidaCompra, precioCosto);
        this.densidad = densidad;
    } 

    public InsumoLiquido(int codInsumo, String nomInsumo, int cantInsumo, Medida medidaCompra, double precioCosto) {
        super(codInsumo, nomInsumo, cantInsumo, medidaCompra, precioCosto);
    }



    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }
    
    public double getDensidad() {
        return densidad;
    }  

    @Override
    public String toString() {
        return "InsumoLiquido: " + super.toString() + "densidad=" + densidad + '}';
    }

}



