package com.oasisdrinks.app.dao;
import java.util.*;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.exceptions.DataAccessException;

public interface BasicCRUDInterface <T> {
    void agregar (T t);
    List<T> listar();
    void actualizar (T t);
    void eliminar(int id);
    T buscarPorID (int id);
    List<T> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException;
}
