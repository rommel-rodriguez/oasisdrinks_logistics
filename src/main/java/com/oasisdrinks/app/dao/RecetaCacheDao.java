/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.models.Receta;
import com.oasisdrinks.app.models.RecetaDetalle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toCollection;

import com.oasisdrinks.app.utils.general.CacheUtils;


public class RecetaCacheDao implements BasicCRUDInterface <Receta>{
    Map<String, List<?>> cache;
    List<Receta> recetas = new ArrayList<>();
    List<Producto> productos;
    CacheUtils cu = null;

    public RecetaCacheDao (Map cache){
        this.cache = cache;
        // this.recetas = (List<Receta>) this.cache.get("recetas");
        this.productos = (List<Producto>) this.cache.get("productos");
        // Add all "Linked " Recetas to the recetas list
        // this.productos.forEach( ( prod ) -> {
        //         if (prod.getReceta() != null)
        //             recetas.add(prod.getReceta());
        //         });
        this.recetas = (List<Receta>) this.cache.get("recetas");

        this.cu = new CacheUtils();
        System.out.println("[INFO] Inside RecetaCacheDao const. recetas: " + this.recetas);
    }

    @Override
    public void agregar(Receta t) {
        this.recetas.add(t);
        cu.storeCache(cache);
    }

    @Override
    public List<Receta> listar() {
        return recetas;
    }

    @Override
    public void actualizar(Receta t) {
        Receta updatedReceta = t;
        // TODO: Need to update the Receta model before I can test this.
        // TODO: Need to Mock the database changes, like the connection breaks between Receta
        // and each individual detail.
        List<RecetaDetalle> detalles = updatedReceta.getDetalles();

        recetas.stream()
               .filter(
                   rec -> rec.getCodReceta() ==
                       updatedReceta.getCodReceta()
               )
              .findFirst()
              .ifPresent(rec -> {
                  int index = recetas.indexOf(rec);
                  recetas.set(index, updatedReceta);
              }); 

        cu.storeCache(cache);

    }

    @Override
    public void eliminar(int codReceta) {
        recetas.removeIf(receta -> receta.getCodReceta() == codReceta);
        // List<Object> updatedObjects = new ArrayList<>(recetas);
        // cache.put("recetas", updatedObjects);
        cu.storeCache(cache);
    }

    @Override
    public Receta buscarPorID(int idReceta) {
        Optional<Receta> foundReceta = recetas.stream()
               .filter(
                   receta -> receta.getCodReceta() == idReceta
               ).findFirst();

        return foundReceta.orElse(null);
    }
    
}
