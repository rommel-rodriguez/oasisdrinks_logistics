
package com.oasisdrinks.app.models;

import java.util.Scanner;

public class InsumoLiquido extends Insumo{
    private double densidad;
    

    public InsumoLiquido(double densidad, int codInsumo, String nomInsumo, 
            int cantInsumo, Medida medidaCompra, double precioCosto) {
        super(codInsumo, nomInsumo, cantInsumo, medidaCompra, precioCosto);
        this.densidad = densidad;
    } 

    public void setDensidad(double densidad) {
        this.densidad = densidad;
    }
    
    public double getDensidad() {
        return densidad;
    }  

}


