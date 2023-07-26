/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import com.oasisdrinks.app.dao.RecetaDao;
import com.oasisdrinks.app.dao.RecetaDao;
import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Receta;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class RecetaService {
    private RecetaDao recetaDao;

    public RecetaService(RecetaDao recetaDao) {
        this.recetaDao = recetaDao;
    }

    public void add(Receta receta) {
        // Perform validation or other business logic checks
        // before adding the receta to the data store
        recetaDao.agregar(receta);
    }

    public void update(Receta receta) {
        // Perform validation or other business logic checks
        // before updating the receta in the data store
        recetaDao.actualizar(receta);
    }

    public void delete(int id) {
        // Perform validation or other business logic checks
        // before deleting the receta from the data store
        recetaDao.eliminar(id );
    }

    public List<Receta> getAll() {
        // Retrieve all recetas from the data store
        return recetaDao.listar();
    }

    public Receta buscarPorID(int codReceta) {
        return recetaDao.buscarPorID(codReceta);
    }

    public Receta buscarPorCodProducto(int codProducto) throws DataAccessException {
        return recetaDao.buscarPorCodProducto(codProducto);
    }
    // Other methods for interacting with the data store or performing
    // additional business logic operations on recetas
}
