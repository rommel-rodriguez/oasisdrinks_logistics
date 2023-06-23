/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import java.util.*;

import com.oasisdrinks.app.model.Medida;
import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.dao.MedidaCacheDao;
import com.oasisdrinks.app.dao.BasicCRUDInterface;
import com.oasisdrinks.app.dao.MedidaDaoInterface;


public class MedidaController {

    private Map<String, List<?>> cache;
    private List<Medida> medidas;
    private boolean useCache;


    public Map<String, List<?>> getCache() {
        return cache;
    }

    public void setCache(Map<String, List<?>> cache) {
        this.cache = cache;
        this.medidas = (List<Medida>) this.cache.get("medidas");
    }

    public List<Medida> listarMedidas() {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MedidaCacheDao(cache);
            return  inDao.listar();
        }
        return null;
        
    }

    public void agregarMedida(Medida medida) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MedidaCacheDao(cache);
            inDao.agregar(medida);
        }
    }


    public void actualizarMedida(Medida medida) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MedidaCacheDao(cache);
            inDao.actualizar(medida);
        }

    }


    public void borrarMedida(int codigo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MedidaCacheDao(cache);
            inDao.eliminar(codigo);
        }

    }

    public Medida buscarMedidaPorAbrev(String abrev) {
        Medida foundMedida = null;
        if (this.cache != null) {
            MedidaDaoInterface medidaDao = new MedidaCacheDao(cache);
            foundMedida = medidaDao.buscarMedidaPorAbrev(abrev);
        }
        return foundMedida;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }
    
}
