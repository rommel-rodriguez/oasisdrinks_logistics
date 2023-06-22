/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oasisdrinks.app.utils.dbconnection;
import java.util.*;
import com.oasisdrinks.app.model.Insumo;

/**
 *
 * @author shadowthrone
 */
public interface BasicCRUDInterface <T> {
    void agregar (T t);
    List<T> listar();
    void actualizar (T t);
    void eliminar(int id);
    Insumo buscarPorID (int id);
}
