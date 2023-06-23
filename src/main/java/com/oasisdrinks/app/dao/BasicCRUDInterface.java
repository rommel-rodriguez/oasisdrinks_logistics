package com.oasisdrinks.app.dao;
import java.util.*;
import com.oasisdrinks.app.model.Insumo;

public interface BasicCRUDInterface <T> {
    void agregar (T t);
    List<T> listar();
    void actualizar (T t);
    void eliminar(int id);
    T buscarPorID (int id);
}
