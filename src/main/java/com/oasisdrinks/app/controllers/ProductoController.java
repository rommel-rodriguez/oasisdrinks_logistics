package com.oasisdrinks.app.controllers;

import java.util.*;

import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.dao.ProductoDao;
import com.oasisdrinks.app.dao.ProductoCacheDao;
import com.oasisdrinks.app.dao.BasicCRUDInterface;



public class ProductoController {

    private Map<String, List<?>> cache;
    private List<Producto> productos;
    private boolean useCache;


    public Map<String, List<?>> getCache() {
        return cache;
    }

    public void setCache(Map<String, List<?>> cache) {
        this.cache = cache;
        this.productos = (List<Producto>) this.cache.get("productos");
    }



    public List<Producto> listarProductos() {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new ProductoCacheDao(cache);
            return  inDao.listar();
        }
        return null;
    }

    public void agregarProducto(Producto producto) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new ProductoCacheDao(cache);
            inDao.agregar(producto);
        }
    }


    public void actualizarProducto(Producto producto) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new ProductoCacheDao(cache);
            inDao.actualizar(producto);
        }

    }


    public void borrarProducto(int codigo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new ProductoCacheDao(cache);
            inDao.eliminar(codigo);
        }

    }

    public List<String> listarTipos() {
        // TODO: Need to add the actual logic here
        if (this.cache != null) {
            ProductoCacheDao inDao = new ProductoCacheDao(cache);
            return  inDao.listarTipos();
        }
        return null;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }


    public Producto buscarPorId(int id) {
        BasicCRUDInterface<Producto> dao = new ProductoCacheDao(cache);
        
        return dao.buscarPorID(id);

    }
    
}
