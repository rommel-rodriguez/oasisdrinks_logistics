/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.InsumoLiquido;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import javax.sql.DataSource;
import java.util.List;
import java.util.*;
import java.sql.*;

/**
 *
 * @author shadowthrone
 */
public class InsumoDao implements AltCRUDInterface<Insumo> {
    private DataSource ds = null;

    public InsumoDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(Insumo t) throws DataAccessException {
        String query = "INSERT INTO Insumo (nomInsumo, cantInsumo, medidaCompraId, precioCosto, densidad) VALUES (?, ?, ?, ?, ?)";
        InsumoLiquido insumo = (InsumoLiquido) t;
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, insumo.getNomInsumo());
            statement.setInt(2, insumo.getCantInsumo());
            statement.setInt(3, insumo.getMedidaCompra().getId());
            statement.setDouble(4, insumo.getPrecioCosto());
            statement.setDouble(5, insumo.getDensidad());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[ERROR] Failed to add [model] to the database:\n" + e.getMessage());
            return -1;
        }
        return insumo.getCodInsumo();
    }

    @Override
    public List<Insumo> listar() throws DataAccessException {
        List<Insumo> insumos = new ArrayList<>();
        String sql = "SELECT * FROM Insumo order by nomInsumo";

        try (
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
            ) {
            MedidaDao medidaDao = new MedidaDao(ds);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("codInsumo");
                    String name = resultSet.getString("nomInsumo");
                    int cantInsumo = resultSet.getInt("cantInsumo");
                    int medidaId = resultSet.getInt("medidaCompraId");

                    Medida medida = medidaDao.buscarPorID(medidaId);

                    Double precioCosto = resultSet.getDouble("precioCosto");
                    Double densidad = resultSet.getDouble("densidad");
                    Insumo insumo = new InsumoLiquido(
                        id, name,
                        cantInsumo, medida, precioCosto);
                    if (densidad != 0)
                        ((InsumoLiquido) insumo ).setDensidad(densidad);

                    insumos.add(insumo);
                }
            }
        } catch (SQLException ex) {
            // Handle or rethrow the exception as needed
            // throw new SQLDataAccessException(ex.getStackTrace().toString()); 
            System.err.println(ex.getStackTrace().toString());
            System.err.println(ex);
            System.err.println("[ERROR] Something went wrong");
        }
        return insumos;
    }

    @Override
    public int actualizar(Insumo t) throws DataAccessException {
        String query = "UPDATE Insumo SET nomInsumo = ?, cantInsumo = ?, medidaCompraId = ?, precioCosto = ?, densidad = ? WHERE codInsumo = ?";

        InsumoLiquido insumo = (InsumoLiquido) t;
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, insumo.getNomInsumo());
            statement.setInt(2, insumo.getCantInsumo());
            statement.setInt(3, insumo.getMedidaCompra().getId());
            statement.setDouble(4, insumo.getPrecioCosto());
            statement.setDouble(5, insumo.getDensidad());
            statement.setInt(6, insumo.getCodInsumo());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[ERROR] Failed to update [model] "+ insumo + "\n" + e.getMessage());
            return -1;
        }
        return insumo.getCodInsumo();
    }

    @Override
    public int eliminar(int id) throws DataAccessException {
        String query = "DELETE FROM Insumo  WHERE codInsumo = ?";

        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("[ERROR] Failed to delete [model]'s id: "+ id + "\n" + e.getMessage());
            return -1;
        }
        return id; 
    }

    @Override
    public Insumo buscarPorID(int id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Insumo> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
