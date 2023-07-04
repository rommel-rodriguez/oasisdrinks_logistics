/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import java.io.Serializable;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class InsumoSolido extends Insumo  implements Serializable {

    public InsumoSolido(int codInsumo, String nomInsumo, int cantInsumo, Medida medidaCompra, double precioCosto) {
        super(codInsumo, nomInsumo, cantInsumo, medidaCompra, precioCosto);
    }
    
}
