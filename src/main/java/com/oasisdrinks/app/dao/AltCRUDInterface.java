package com.oasisdrinks.app.dao;
import java.util.*;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.exceptions.DataAccessException;

public interface AltCRUDInterface <T> {
    int agregar (T t);
    List<T> listar();
    int actualizar (T t);
    int eliminar(int id);
    T buscarPorID (int id);
    List<T> buscarPorPropiedad(String propiedad, Object valor);
}
