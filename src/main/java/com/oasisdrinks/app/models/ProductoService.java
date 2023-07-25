/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.models;

import com.oasisdrinks.app.dao.ProductoDao;
import com.oasisdrinks.app.models.Producto;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class ProductoService {
    private ProductoDao productoDao;

    public ProductoService(ProductoDao productoDao) {
        this.productoDao = productoDao;
    }

    public void add(Producto producto) {
        // Perform validation or other business logic checks
        // before adding the producto to the data store
        productoDao.agregar(producto);
    }

    public void update(Producto producto) {
        // Perform validation or other business logic checks
        // before updating the producto in the data store
        productoDao.actualizar(producto);
    }

    public void delete(int id) {
        // Perform validation or other business logic checks
        // before deleting the producto from the data store
        productoDao.eliminar(id );
    }

    public List<Producto> getAll() {
        // Retrieve all productos from the data store
        return productoDao.listar();
    }

    public List<String> listarTipos() {
        // Retrieve all productos from the data store
        return productoDao.listarTipos();
    }

    public String getTipoProductoFromNombre(String tipoNombre) {
        return productoDao.getTipoProductoFomNombre(tipoNombre);
    }
    public String getNombreTipoFromTipoProducto(String tipoProducto) {
        return productoDao.getNombreTipoFromTipoProducto(tipoProducto);
    }

    public Producto buscarPorID(int codProducto) {
        return productoDao.buscarPorID(codProducto);
    }
    // Other methods for interacting with the data store or performing
    // additional business logic operations on productos
}
