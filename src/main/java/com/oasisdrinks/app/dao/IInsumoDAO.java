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
public interface IInsumoDAO {
    void agregarInsumo (Insumo insumo);
    List<Insumo> listarInsumos();
    void actualizarInsumo (Insumo insumo);
    void borrarInsumo(int idInsumo);
    Insumo buscarInsumoPorID (int idinsumo);
}
