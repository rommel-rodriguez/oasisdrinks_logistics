/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import java.util.*;

import com.oasisdrinks.app.models.Usuario;
import com.oasisdrinks.app.dao.UsuarioCacheDao;
import com.oasisdrinks.app.dao.BasicCRUDInterface;


public class UsuarioController {

    private Map<String, List<?>> cache;
    private List<Usuario> usuarios;
    private boolean useCache;


    public Map<String, List<?>> getCache() {
        return cache;
    }

    public void setCache(Map<String, List<?>> cache) {
        this.cache = cache;
        this.usuarios = (List<Usuario>) this.cache.get("usuarios");
    }

    public List<Usuario> listarUsuarios() {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new UsuarioCacheDao(cache);
            return  inDao.listar();
        }
        return null;
        
    }

    public void agregarUsuario(Usuario usuario) {
        if (this.cache != null) {
            BasicCRUDInterface<Usuario> inDao = new UsuarioCacheDao(cache);
            inDao.agregar(usuario);
        }
    }


    public void actualizarUsuario(Usuario usuario) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new UsuarioCacheDao(cache);
            inDao.actualizar(usuario);
        }

    }


    public void borrarUsuario(int codigo) {
        if (this.cache != null) {
            BasicCRUDInterface inDao = new UsuarioCacheDao(cache);
            inDao.eliminar(codigo);
        }

    }

    public Usuario buscarUsuarioPorLogin(String login) {
        Usuario foundUsuario = null;
        if (this.cache != null) {
            UsuarioCacheDao usuarioDao = new UsuarioCacheDao(cache);
            foundUsuario = usuarioDao.buscarUsuarioPorLogin(login);
        }
        return foundUsuario;
    }

    public void setUseCache(boolean useCache) {
        this.useCache = useCache;
    }
    
}
