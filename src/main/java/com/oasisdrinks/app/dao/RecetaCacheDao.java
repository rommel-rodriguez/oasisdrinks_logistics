/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Receta;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;


public class RecetaCacheDao implements BasicCRUDInterface <Receta>{
    Map<String, List<?>> cache;
    List<Receta> recetas;

    public RecetaCacheDao (Map cache){
        this.cache = cache;
        this.recetas = (List<Receta>) this.cache.get("recetas");
    }

    @Override
    public void agregar(Receta t) {
        this.recetas.add(t);
    }

    @Override
    public List<Receta> listar() {
        return recetas;
    }

    @Override
    public void actualizar(Receta t) {
        Receta updatedReceta = t;
        // TODO: Need to update the Receta model before I can test this.
        recetas.stream()
               .filter(
                   insu -> insu.getCodReceta() ==
                       updatedReceta.getCodReceta()
               )
              .findFirst()
              .ifPresent(insu -> {
                  int index = recetas.indexOf(insu);
                  recetas.set(index, updatedReceta);
              }); 

        // List<Object> updatedObjects = new ArrayList<>(recetas);
        // cache.put("recetas", updatedObjects);
    }

    @Override
    public void eliminar(int codReceta) {
        recetas.removeIf(receta -> receta.getCodReceta() == codReceta);
        // List<Object> updatedObjects = new ArrayList<>(recetas);
        // cache.put("recetas", updatedObjects);
    }

    @Override
    public Receta buscarPorID(int idreceta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
