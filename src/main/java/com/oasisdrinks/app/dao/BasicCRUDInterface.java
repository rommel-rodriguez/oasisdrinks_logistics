package com.oasisdrinks.app.dao;
import java.util.*;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.exceptions.DataAccessException;

public interface BasicCRUDInterface <T> {
    void agregar (T t) throws DataAccessException;
    List<T> listar() throws DataAccessException;
    void actualizar (T t) throws DataAccessException;
    void eliminar(int id) throws DataAccessException;
    T buscarPorID (int id) throws DataAccessException;
    List<T> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException;
}
