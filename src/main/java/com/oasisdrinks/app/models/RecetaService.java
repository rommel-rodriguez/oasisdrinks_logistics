/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.models.Insumo;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class RecetaService {
    private InsumoDao insumoDao;

    public RecetaService(InsumoDao insumoDao) {
        this.insumoDao = insumoDao;
    }

    public void add(Insumo insumo) {
        // Perform validation or other business logic checks
        // before adding the insumo to the data store
        insumoDao.agregar(insumo);
    }

    public void update(Insumo insumo) {
        // Perform validation or other business logic checks
        // before updating the insumo in the data store
        insumoDao.actualizar(insumo);
    }

    public void delete(int id) {
        // Perform validation or other business logic checks
        // before deleting the insumo from the data store
        insumoDao.eliminar(id );
    }

    public List<Insumo> getAllInsumos() {
        // Retrieve all insumos from the data store
        return insumoDao.listar();
    }

    // Other methods for interacting with the data store or performing
    // additional business logic operations on insumos
}
