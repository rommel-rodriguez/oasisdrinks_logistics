package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Producto;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

import com.oasisdrinks.app.utils.general.CacheUtils;


public class ProductoCacheDao implements BasicCRUDInterface <Producto>{
    Map<String, List<?>> cache;
    List<Producto> productos;
    CacheUtils cu = null;

    public ProductoCacheDao (Map cache){
        this.cache = cache;
        this.productos = (List<Producto>) this.cache.get("productos");
        this.cu = new CacheUtils();
    }

    @Override
    public void agregar(Producto t) {
        this.productos.add(t);
        cu.storeCache(cache);
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

        cu.storeCache(cache);

        // List<Object> updatedObjects = new ArrayList<>(productos);
        // cache.put("productos", updatedObjects);
    }

    @Override
    public void eliminar(int codProducto) {
        productos.removeIf(producto -> producto.getCodProducto() == codProducto);
        // List<Object> updatedObjects = new ArrayList<>(productos);
        // cache.put("productos", updatedObjects);
        cu.storeCache(cache);
    }

    @Override
    public Producto buscarPorID(int idProducto) {
        Optional<Producto> foundProducto = productos.stream()
               .filter(
                   producto -> producto.getCodProducto() == idProducto 
               ).findFirst();

        return foundProducto.orElse(null);
    }

    public List<String> listarTipos() {
        Set<String> uniqueTypes = new HashSet<>();
        List<String> tipos;

        this.productos.forEach(
           producto -> uniqueTypes.add(producto.getTipo())
        );
        
        tipos = new ArrayList<>(uniqueTypes);

        return tipos;
    }

}
