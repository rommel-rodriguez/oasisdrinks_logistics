/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Receta;
import com.oasisdrinks.app.models.RecetaDetalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */

public class RecetaDao implements OasisCRUDI<Receta> {
    private final javax.sql.DataSource ds; // Assume ds is the HikariCP DataSource

    public RecetaDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(Receta receta) {
        int rowsAffected = 0;
        String sql = "INSERT INTO Receta (cantidad,codProducto) VALUES (?, ?)";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, receta.getCantidad());
            statement.setInt(1, receta.getCodProducto());
            rowsAffected = statement.executeUpdate();
            int codReceta = getGeneratedKey(statement);
            receta.setCodReceta(codReceta);
            RecetaDetalleDao recetaDetalleDao = new RecetaDetalleDao(ds);
            for (RecetaDetalle detalle : receta.getDetalles()) {
                detalle.setCodReceta(codReceta);
                recetaDetalleDao.agregar(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public List<Receta> listar() {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM Receta";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Receta receta = new Receta();
                    receta.setCodReceta(resultSet.getInt("codReceta"));
                    receta.setCantidad(resultSet.getInt("cantidad"));
                    recetas.add(receta);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return recetas;
    }

    @Override
    public int actualizar(Receta receta) {
        int rowsAffected = 0;
        String sql = "UPDATE Receta SET observacion= ? WHERE codReceta = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, receta.getObservacion());
            statement.setInt(2, receta.getCodReceta());
            rowsAffected = statement.executeUpdate();
                // Update RecetaDetalle objects associated with this Receta in the database
            RecetaDetalleDao recetaDetalleDAO = new RecetaDetalleDao(ds);
            for (RecetaDetalle detalle : receta.getDetalles()) {
                //recetaDetalleDAO.actualizar(detalle);
                recetaDetalleDAO.store(detalle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public int eliminar(int codReceta) {
        int rowsAffected = 0;
        String sql = "DELETE FROM Receta WHERE codReceta = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codReceta);
            rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                // Delete associated RecetaDetalle objects from the database
                RecetaDetalleDao recetaDetalleDao = new RecetaDetalleDao(ds);
                recetaDetalleDao.eliminarPorReceta(codReceta);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return rowsAffected;
    }

    @Override
    public Receta buscarPorID(int codReceta) {
        Receta receta = null;
        String sql = "SELECT * FROM Receta WHERE codReceta = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codReceta);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    receta = new Receta();
                    receta.setCodReceta(resultSet.getInt("codReceta"));
                    //receta.setCantidad(resultSet.getInt("cantidad"));
                    // Load RecetaDetalle objects using RecetaDetalleDAO
                    RecetaDetalleDao recetaDetalleDao = new RecetaDetalleDao(ds);
                    List<RecetaDetalle> detalles = recetaDetalleDao.buscarPorReceta(codReceta);
                    receta.setDetalles(detalles);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return receta;
    }

    @Override
    public List<Receta> buscarPorPropiedad(String propiedad, Object valor) {
        List<Receta> recetas = new ArrayList<>();
        String sql = "SELECT * FROM Receta WHERE " + propiedad + " = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (valor instanceof String) {
                statement.setString(1, (String) valor);
            } else if (valor instanceof Integer) {
                statement.setInt(1, (Integer) valor);
            } else {
                throw new IllegalArgumentException("Unsupported data type for property: " + propiedad);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    recetas.add(createRecetaFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return recetas;
    }

    private Receta createRecetaFromResultSet(ResultSet resultSet) throws SQLException {
        int codReceta = resultSet.getInt("codReceta");
        ///int cantidad = resultSet.getInt("cantidad");
        Receta receta = new Receta(codReceta);
        // Load RecetaDetalle objects using RecetaDetalleDAO
        RecetaDetalleDao recetaDetalleDAO = new RecetaDetalleDao(ds);
        List<RecetaDetalle> detalles = recetaDetalleDAO.buscarPorReceta(codReceta);
        receta.setDetalles(detalles);
        return receta;
    }

    private int getGeneratedKey(PreparedStatement statement) throws SQLException {
        try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                return generatedKeys.getInt(1);
            }
        }
        throw new SQLException("Failed to get generated key for Receta.");
    }

    public Receta buscarPorCodProducto(int codProducto) throws DataAccessException {
        Receta receta = null;
        String sql = "SELECT * FROM Receta WHERE codProducto = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codProducto);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    receta = new Receta();
                    receta.setCodReceta(resultSet.getInt("codReceta"));
                    //receta.setCantidad(resultSet.getInt("cantidad"));
                    receta.setCodProducto(resultSet.getInt("codProducto"));
                    //receta.setFlagEstado(resultSet.getString("flagEstado"));
                    // If needed, you can set additional fields of Receta from the ResultSet
                    // For example, you can use resultSet.getString("observacion") to get the observacion field.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error while fetching Receta by codProducto: " + e.getMessage(), e);
        }
        return receta;
    }
}