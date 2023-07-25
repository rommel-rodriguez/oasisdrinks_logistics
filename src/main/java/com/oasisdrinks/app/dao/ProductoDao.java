/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Producto;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class ProductoDao implements OasisCRUDI<Producto>{
    private DataSource ds = null;

    public ProductoDao(DataSource ds) {
        this.ds = ds;
    }


    @Override
    public int agregar(Producto t) {
        Producto producto = (Producto) t;
        String sql = "INSERT INTO Producto (nomProducto, cantProducto, diasCaducidad, tipoProducto, estado, idMedida) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, producto.getNomProducto());
            statement.setInt(2, producto.getCantProducto());
            statement.setInt(3, producto.getDiasCaducidad());
            statement.setString(4, producto.getTipo());
            statement.setInt(5, producto.getEstado());
            statement.setInt(6, producto.getMedida().getId());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating Producto failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating Producto failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return -1; // Indicates failure.
    }

    @Override
    public List<Producto> listar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int actualizar(Producto t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Producto buscarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Producto> buscarPorPropiedad(String propiedad, Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
