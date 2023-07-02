package com.oasisdrinks.app.controllers;

import java.util.*;

import com.oasisdrinks.app.models.Receta;
//import com.oasisdrinks.app.dao.RecetaDao;
import com.oasisdrinks.app.dao.RecetaCacheDao;
import com.oasisdrinks.app.dao.BasicCRUDInterface;



public class RecetaController {

    private Map<String, List<?>> cache;
    private List<Receta> recetas;
    private boolean useCache;


    public Map<String, List<?>> getCache() {
        return cache;
    }

    public void setCache(Map<String, List<?>> cache) {
        this.cache = cache;
        this.recetas = (List<Receta>) this.cache.get("recetas");
    }



    public List<Receta> listarRecetas() {
        if (this.cache != null) {
            BasicCRUDInterface<Receta> inDao = new RecetaCacheDao(cache);
            return  inDao.listar();
        }
        return null;
        
    }

    public void agregarReceta(Receta receta) {
        if (this.cache != null) {
            BasicCRUDInterface<Receta> inDao = new RecetaCacheDao(cache);
            inDao.agregar(receta);
        }
    }


    public void actualizarReceta(Receta receta) {
        if (this.cache != null) {
            BasicCRUDInterface<Receta> inDao = new RecetaCacheDao(cache);
            inDao.actualizar(receta);
        }

    }


    public void borrarReceta(int codigo) {
        if (this.cache != null) {
            BasicCRUDInterface<Receta> inDao = new RecetaCacheDao(cache);
            inDao.eliminar(codigo);
        }

    }


    public Receta buscarPorId(int id) {

        BasicCRUDInterface<Receta> daoObj = new RecetaCacheDao(cache);

        return daoObj.buscarPorID(id);
    }



    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }


    
}
