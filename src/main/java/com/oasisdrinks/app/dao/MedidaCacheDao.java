/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Medida;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

import com.oasisdrinks.app.utils.general.CacheUtils;


public class MedidaCacheDao implements BasicCRUDInterface <Medida>, MedidaDaoInterface {
    Map<String, List<?>> cache;
    List<Medida> medidas;
    CacheUtils cu = null;

    public MedidaCacheDao (Map cache){
        this.cache = cache;
        this.medidas = (List<Medida>) this.cache.get("medidas");
        this.cu = new CacheUtils();
    }
    @Override
    public void agregar(Medida t) {
        this.medidas.add(t);
        cu.storeCache(cache);
    }

    @Override
    public List<Medida> listar() {
        return medidas;
    }

    @Override
    public void actualizar(Medida t) {
        Medida updatedMedida = t;
        medidas.stream()
               .filter(
                   medida -> medida.getId() == updatedMedida.getId()
               )
              .findFirst()
              .ifPresent(medida -> {
                  int index = medidas.indexOf(medida);
                  medidas.set(index, updatedMedida);
              }); 
        cu.storeCache(cache);
    }

    @Override
    public void eliminar(int id) {
        medidas.removeIf(medida -> medida.getId() == id);
        cu.storeCache(cache);
    }

    @Override
    public Medida buscarPorID(int id) {
        Optional<Medida> foundMedida = medidas.stream()
               .filter(
                   medida -> medida.getId() == id 
               ).findFirst();

        return foundMedida.orElse(null);
    }

    @Override
    public Medida buscarMedidaPorAbrev(String abrev) {
        Optional<Medida> foundMedida = medidas.stream()
               .filter(
                   medida -> medida.getAbrev().equals(abrev)
               ).findFirst();

        return foundMedida.orElse(null);
    }

    @Override
    public List<Medida> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
