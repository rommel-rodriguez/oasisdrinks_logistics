/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.model.Insumo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;


/**
 *
 * @author shadowthrone
 */
public class MockInsumoDAO implements IInsumoDAO {
    Map<String, List<?>> cache;
    List<Insumo> insumos;

    public MockInsumoDAO (Map cache){
        this.cache = cache;
        // List<Object> objects = this.cache.get("insumos");
        List<Insumo> insumos = (List<Insumo>) this.cache.get("insumos");
        // for (Object obj : objects) {
        //     if (obj instanceof Insumo) {
        //         insumos.add((Insumo) obj);
        //     }
        // }
    }
    @Override
    public void agregarInsumo(Insumo insumo) {
        this.insumos.add(insumo);
    }

    @Override
    public List<Insumo> listarInsumos() {
        return insumos;
    }

    @Override
    public void actualizarInsumo(Insumo insumo) {
        Insumo updatedInsumo = insumo;
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

        // List<Object> updatedObjects = new ArrayList<>(insumos);
        // cache.put("insumos", updatedObjects);
    }

    @Override
    public void borrarInsumo(int codInsumo) {
        insumos.removeIf(insumo -> insumo.getCodInsumo() == codInsumo);
        // List<Object> updatedObjects = new ArrayList<>(insumos);
        // cache.put("insumos", updatedObjects);
    }

    @Override
    public Insumo buscarInsumoPorID(int idinsumo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
