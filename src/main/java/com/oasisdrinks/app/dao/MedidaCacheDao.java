/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.model.Medida;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;


/**
 *
 * @author shadowthrone
 */
public class MedidaCacheDao implements BasicCRUDInterface <Medida>, MedidaDaoInterface {
    Map<String, List<?>> cache;
    List<Medida> medidas;

    public MedidaCacheDao (Map cache){
        this.cache = cache;
        this.medidas = (List<Medida>) this.cache.get("medidas");
    }
    @Override
    public void agregar(Medida t) {
        this.medidas.add(t);
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
    }

    @Override
    public void eliminar(int id) {
        medidas.removeIf(medida -> medida.getId() == id);
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
    
}
