/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.*;

import com.oasisdrinks.app.utils.general.CacheUtils;


public class UsuarioCacheDao implements BasicCRUDInterface <Usuario> {
    Map<String, List<?>> cache;
    List<Usuario> usuarios;
    CacheUtils cu = null;

    public UsuarioCacheDao (Map cache){
        this.cache = cache;
        this.usuarios = (List<Usuario>) this.cache.get("usuarios");
        if (this.usuarios == null) {
            this.usuarios = new ArrayList<Usuario>();
            this.cache.put("usuarios", this.usuarios);
        }

        this.cu = new CacheUtils();
    }
    @Override
    public void agregar(Usuario t) {
        this.usuarios.add(t);
        cu.storeCache(cache);
    }

    @Override
    public List<Usuario> listar() {
        return usuarios;
    }

    @Override
    public void actualizar(Usuario t) {
        Usuario updatedUsuario = t;
        usuarios.stream()
               .filter(
                   usuario -> usuario.getId() == updatedUsuario.getId()
               )
              .findFirst()
              .ifPresent(usuario -> {
                  int index = usuarios.indexOf(usuario);
                  usuarios.set(index, updatedUsuario);
              }); 
        cu.storeCache(cache);
    }

    @Override
    public void eliminar(int id) {
        usuarios.removeIf(usuario -> usuario.getId() == id);
        cu.storeCache(cache);
    }

    @Override
    public Usuario buscarPorID(int id) {
        Optional<Usuario> foundUsuario = usuarios.stream()
               .filter(
                   usuario -> usuario.getId() == id 
               ).findFirst();

        return foundUsuario.orElse(null);
    }


    public Usuario buscarUsuarioPorLogin(String login) {
        Optional<Usuario> foundUsuario = usuarios.stream()
               .filter(
                   usuario -> usuario.getLogin().equals(login)
               ).findFirst();

        return foundUsuario.orElse(null);
    }

    @Override
    public List<Usuario> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
