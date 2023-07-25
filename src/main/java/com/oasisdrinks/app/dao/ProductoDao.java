/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Bebida;
import com.oasisdrinks.app.models.Medida;
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
        String sql = "INSERT INTO Producto (nomProducto, cantProducto, diasCaducidad, tipoProducto, flagEstado, idMedida) VALUES (?, ?, ?, ?, ?, ?)";
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
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                productos.add(createProductoFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return productos;
    }

    @Override
    public int actualizar(Producto producto) {
        String sql = "UPDATE Producto SET nomProducto=?, cantProducto=?, diasCaducidad=?, tipoProducto=?, estado=?, idMedida=? WHERE codProducto=?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, producto.getNomProducto());
            statement.setInt(2, producto.getCantProducto());
            statement.setInt(3, producto.getDiasCaducidad());
            statement.setString(4, producto.getTipo());
            statement.setInt(5, producto.getEstado());
            statement.setInt(6, producto.getMedida().getId());
            statement.setInt(7, producto.getCodProducto());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return -1; // Indicates failure.
    }

    @Override
    public int eliminar(int codProducto) {
        String sql = "DELETE FROM Producto WHERE codProducto=?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codProducto);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return -1; // Indicates failure.
    }

    @Override
    public Producto buscarPorID(int codProducto) {
        String sql = "SELECT * FROM Producto WHERE codProducto=?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, codProducto);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return createProductoFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return null; // Indicates no record found.
    }


    @Override
    public List<Producto> buscarPorPropiedad(String propiedad, Object valor) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM Producto WHERE " + propiedad + " = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            if (valor instanceof String) {
                statement.setString(1, (String) valor);
            } else if (valor instanceof Integer) {
                statement.setInt(1, (Integer) valor);
            } else if (valor instanceof Double) {
                statement.setDouble(1, (Double) valor);
            } else {
                // Handle other data types if needed
                // For example, if the property is a date, you can use statement.setDate()
                // Or, if the property is a boolean, you can use statement.setBoolean()
                throw new IllegalArgumentException("Unsupported data type for property: " + propiedad);
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    productos.add(createProductoFromResultSet(resultSet));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return productos;
    }

    private Producto createProductoFromResultSet(ResultSet resultSet) throws SQLException {
        int codProducto = resultSet.getInt("codProducto");
        String nomProducto = resultSet.getString("nomProducto");
        int cantProducto = resultSet.getInt("cantProducto");
        int diasCaducidad = resultSet.getInt("diasCaducidad");
        String tipo = resultSet.getString("tipoProducto");
        int estado = resultSet.getInt("flagEstado");
        int idMedida = resultSet.getInt("idMedida");
        // Get the Medida object using idMedida from the MedidaDAO or MedidaDataSource
        MedidaDao medidaDao = new MedidaDao(ds); // Assuming MedidaDAOImpl implements MedidaDAO
        Medida medida = medidaDao.buscarPorID(idMedida);
        return new Bebida(codProducto, nomProducto, cantProducto, diasCaducidad, tipo, estado, medida);
    }

    public List<String> listarTipos() {
        List<String> tipos = new ArrayList<>();
        String sql = "SELECT nomTipoProducto FROM ProductoTipo";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    tipos.add(resultSet.getString("nomTipoProducto"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return tipos;
    }

    public String getTipoProductoFomNombre(String tipoNombre) {
        String tipoProducto = null;
        String sql = "SELECT tipoProducto FROM ProductoTipo WHERE nomTipoProducto=?";
        try (Connection connection = ds.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, tipoNombre);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tipoProducto = resultSet.getString("tipoProducto");
                    return tipoProducto;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return null; // Indicates no record found.
    }
}
