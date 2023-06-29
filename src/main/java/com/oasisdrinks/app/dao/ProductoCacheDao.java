package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;


public class ProductoCacheDao implements BasicCRUDInterface <Producto>{
    Map<String, List<?>> cache;
    List<Producto> productos;

    public ProductoCacheDao (Map cache){
        this.cache = cache;
        this.productos = (List<Producto>) this.cache.get("productos");
    }

    @Override
    public void agregar(Producto t) {
        this.productos.add(t);
    }

    @Override
    public List<Producto> listar() {
        return productos;
    }

    @Override
    public void actualizar(Producto t) {
        Producto updatedProducto = t;
        // TODO: Need to update the Producto model before I can test this.
        productos.stream()
               .filter(
                   insu -> insu.getCodProducto() ==
                       updatedProducto.getCodProducto()
               )
              .findFirst()
              .ifPresent(insu -> {
                  int index = productos.indexOf(insu);
                  productos.set(index, updatedProducto);
              }); 

        // List<Object> updatedObjects = new ArrayList<>(productos);
        // cache.put("productos", updatedObjects);
    }

    @Override
    public void eliminar(int codProducto) {
        productos.removeIf(producto -> producto.getCodProducto() == codProducto);
        // List<Object> updatedObjects = new ArrayList<>(productos);
        // cache.put("productos", updatedObjects);
    }

    @Override
    public Producto buscarPorID(int idproducto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}