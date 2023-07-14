/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.service.InsumoService;
import com.oasisdrinks.app.views.InsumoView;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class ControllerWithService {
    private InsumoService insumoService;
    private InsumoView view;

    public ControllerWithService (InsumoService insumoService, InsumoView view) {
        this.insumoService = insumoService;
        this.view = view;
        // Set up event listeners and other initialization
        // ...
    }

    public void addInsumo(Insumo insumo) {
        insumoService.add(insumo);
    }

    public void updateInsumo(Insumo insumo) {
        insumoService.update(insumo);
    }

    public void deleteInsumo(Insumo insumo) {
        insumoService.delete(insumo);
    }

    // Other methods for interacting with the service layer

    public void refreshView() {
        List<Insumo> insumos = insumoService.getAllInsumos();
        view.displayInsumos(insumos);
    }
    
}
