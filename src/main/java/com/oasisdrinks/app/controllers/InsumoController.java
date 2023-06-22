/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import java.util.*;

import com.oasisdrinks.app.model.Insumo;
import com.oasisdrinks.app.dao.InsumoDAO;
import com.oasisdrinks.app.dao.MockInsumoDAO;
import com.oasisdrinks.app.utils.dbconnection.BasicCRUDInterface;



/**
 *
 * @author shadowthrone
 */
public class InsumoController {

    private Map<String, List<?>> cache;
    private List<Insumo> insumos;


    public Map<String, List<?>> getCache() {
        return cache;
    }

    public void setCache(Map<String, List<?>> cache) {
        this.cache = cache;
        // List<Object> objects = this.cache.get("insumos");
        // this.insumos = new ArrayList<>();
        this.insumos = (List<Insumo>) this.cache.get("insumos");
        // for (Object obj : objects) {
        //     if (obj instanceof Insumo) {
        //         this.insumos.add((Insumo) obj);
        //     }
        // }
    }

    public List<Insumo> listarInsumos() {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MockInsumoDAO(cache);
            return  inDao.listar();
        }
        return null;
        
    }

    public void agregarInsumo(Insumo insumo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MockInsumoDAO(cache);
            inDao.agregar(insumo);
        }
    }


    public void actualizarInsumo(Insumo insumo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MockInsumoDAO(cache);
            inDao.actualizar(insumo);
        }

    }


    public void borrarInsumo(int codigo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new MockInsumoDAO(cache);
            inDao.eliminar(codigo);
        }

    }
    
}
