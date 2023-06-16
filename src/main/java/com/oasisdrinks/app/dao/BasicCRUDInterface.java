/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oasisdrinks.app.dao;
import java.util.*;
import com.oasisdrinks.app.model.Insumo;

/**
 *
 * @author shadowthrone
 */
public interface BasicCRUDInterface {
    void agregar (Insumo insumo);
    List<Insumo> listar();
    void actualizar (Insumo insumo);
    void eliminar(int idInsumo);
    Insumo buscarPorID (int idinsumo);
}
