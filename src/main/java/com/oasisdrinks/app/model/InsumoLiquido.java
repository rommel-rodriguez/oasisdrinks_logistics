
package com.oasisdrinks.app.model;

import java.util.Scanner;

public class InsumoLiquido extends Insumo{
    private double densidad;
    

    public InsumoLiquido(double densidad, int codInsumo, String nomInsumo, 
            int cantInsumo, String unidadCompra, double precioCosto) {
        super(codInsumo, nomInsumo, cantInsumo, unidadCompra, precioCosto);
        this.densidad = densidad;
    } 

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }
    
    public double getDensidad() {
        return densidad;
    }  

}



