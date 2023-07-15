/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.exceptions.BusinessException;
import com.oasisdrinks.app.models.Insumo;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class InsumoService {
    // TODO: Add the Business Layer validation inside the service
    private InsumoDao insumoDao;

    public InsumoService(InsumoDao insumoDao) {
        this.insumoDao = insumoDao;
    }

    public void add(Insumo insumo) throws BusinessException.DensidadRangoNoPermitido {
        // Perform validation or other business logic checks
        // before adding the insumo to the data store
        InsumoLiquido insu = (InsumoLiquido) insumo;
        if ( insu.getDensidad() < 0)
            throw new BusinessException.DensidadRangoNoPermitido("La densidad ingresadda es menor a 0");
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

    public List<Insumo> getAll() {
        // Retrieve all insumos from the data store
        return insumoDao.listar();
    }

    // Other methods for interacting with the data store or performing
    // additional business logic operations on insumos
}
