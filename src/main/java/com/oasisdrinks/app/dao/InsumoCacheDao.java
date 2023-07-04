/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.utils.general.CacheUtils;


public class InsumoCacheDao implements BasicCRUDInterface <Insumo>{
    Map<String, List<?>> cache;
    List<Insumo> insumos;
    CacheUtils cu = null;

    public InsumoCacheDao (Map cache){
        this.cache = cache;
        // List<Object> objects = this.cache.get("insumos");
        this.insumos = (List<Insumo>) this.cache.get("insumos");
        this.cu = new CacheUtils();
    }
    @Override
    public void agregar(Insumo t) {
        this.insumos.add(t);
        cu.storeCache(cache);
    }

    @Override
    public List<Insumo> listar() {
        return insumos;
    }

    @Override
    public void actualizar(Insumo t) {
        Insumo updatedInsumo = t;
        // TODO: Need to update the Insumo model before I can test this.
        insumos.stream()
               .filter(
                   insu -> insu.getCodInsumo() ==
                       updatedInsumo.getCodInsumo()
               )
              .findFirst()
              .ifPresent(insu -> {
                  int index = insumos.indexOf(insu);
                  insumos.set(index, updatedInsumo);
              }); 

        cu.storeCache(cache);
        // List<Object> updatedObjects = new ArrayList<>(insumos);
        // cache.put("insumos", updatedObjects);
    }

    @Override
    public void eliminar(int codInsumo) {
        insumos.removeIf(insumo -> insumo.getCodInsumo() == codInsumo);
        // List<Object> updatedObjects = new ArrayList<>(insumos);
        // cache.put("insumos", updatedObjects);
        cu.storeCache(cache);
    }

    @Override
    public Insumo buscarPorID(int idinsumo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public Insumo buscarPorNombre(String nombre) {
        Optional<Insumo> foundInsumo = insumos.stream()
               .filter(
                   insumo -> insumo.getNomInsumo().equals(nombre)
               ).findFirst();

        return foundInsumo.orElse(null);
    }
    
}
