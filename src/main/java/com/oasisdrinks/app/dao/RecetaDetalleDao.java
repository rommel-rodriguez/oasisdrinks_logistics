/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.RecetaDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class RecetaDetalleDao implements OasisCRUDI<RecetaDetalle> {

    private final javax.sql.DataSource ds; // Assume ds is the HikariCP DataSource

    public RecetaDetalleDao(javax.sql.DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(RecetaDetalle recetaDetalle) {
        int rowsAffected = 0;
        String sql = "INSERT INTO RecetaDetalle (codReceta, codInsumo, cantidad) VALUES (?, ?, ?)";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, recetaDetalle.getCodReceta());
            statement.setInt(2, recetaDetalle.getInsumo().getCodInsumo());
            statement.setDouble(3, recetaDetalle.getCantidad());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public List<RecetaDetalle> listar() {
        List<RecetaDetalle> detalles = new ArrayList<>();
        String sql = "SELECT * FROM RecetaDetalle";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    detalles.add(createRecetaDetalleFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return detalles;
    }

    @Override
    public int actualizar(RecetaDetalle recetaDetalle) {
        int rowsAffected = 0;
        String sql = "UPDATE RecetaDetalle SET cantidad = ? WHERE codReceta = ? AND codInsumo = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setDouble(1, recetaDetalle.getCantidad());
            statement.setInt(2, recetaDetalle.getCodReceta());
            statement.setInt(3, recetaDetalle.getInsumo().getCodInsumo());
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public int eliminar(int codRecetaDetalle) {
        int rowsAffected = 0;
        String sql = "DELETE FROM RecetaDetalle WHERE codRecetaDetalle = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codRecetaDetalle);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }
    public int store(RecetaDetalle recetaDetalle) {
        int rowsAffected = 0;
        if (recetaDetalle.getCodReceta() == 0 || recetaDetalle.getInsumo().getCodInsumo() == 0) {
            // If both codReceta and codInsumo are 0, it's a new RecetaDetalle, so insert it.
            rowsAffected = agregar(recetaDetalle);
        } else {
            // If either codReceta or codInsumo is not 0, it already exists, so update it.
            rowsAffected = actualizar(recetaDetalle);
        }
        return rowsAffected;
    }

    public List<RecetaDetalle> buscarPorReceta(int codReceta) {
        List<RecetaDetalle> detalles = new ArrayList<>();
        String sql = "SELECT * FROM RecetaDetalle WHERE codReceta = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codReceta);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    detalles.add(createRecetaDetalleFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return detalles;
    }

    private RecetaDetalle createRecetaDetalleFromResultSet(ResultSet resultSet) throws SQLException {
        int codInsumo = resultSet.getInt("codInsumo");
        double cantidad = resultSet.getDouble("cantidad");
        // Load Insumo using InsumoDAO or InsumoDataSource
        // You should implement InsumoDAO and its implementation to fetch Insumo by codInsumo
        InsumoDao insumoDao = new InsumoDao(ds); // Assuming InsumoDAOImpl implements InsumoDAO
        Insumo insumo = insumoDao.buscarPorID(codInsumo);
        return new RecetaDetalle(insumo, cantidad);
    }

    public int eliminarPorReceta(int codReceta) {
        int rowsAffected = 0;
        String sql = "DELETE FROM RecetaDetalle WHERE codReceta = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codReceta);
            rowsAffected = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public RecetaDetalle buscarPorID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<RecetaDetalle> buscarPorPropiedad(String propiedad, Object valor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
