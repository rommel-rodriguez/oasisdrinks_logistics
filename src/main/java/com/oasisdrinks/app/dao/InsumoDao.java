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
public class InsumoDao implements OasisCRUDI<Insumo> {
    private DataSource ds = null;

    public InsumoDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(Insumo t) throws DataAccessException {
        String query = "INSERT INTO Insumo (nomInsumo, cantInsumo, idMedida, precioCosto, densidad) VALUES (?, ?, ?, ?, ?)";
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
                    int medidaId = resultSet.getInt("idMedida");

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
        String query = "UPDATE Insumo SET nomInsumo = ?, cantInsumo = ?, idMedida = ?, precioCosto = ?, densidad = ? WHERE codInsumo = ?";

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
        Insumo insumo = null;
        String sql = "SELECT * FROM Insumo WHERE codInsumo = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    insumo = createInsumoFromResultSet(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
            throw new DataAccessException("Error while fetching Insumo from the database.", e);
        }
        return insumo;
    }

    @Override
    public List<Insumo> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException {
        List<Insumo> insumos = new ArrayList<>();
        String sql = "SELECT * FROM Insumo WHERE " + propiedad + " = ?";
        try (Connection connection = ds.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            // Set the parameter value based on the data type of the property
            if (valor instanceof String) {
                statement.setString(1, (String) valor);
            } else if (valor instanceof Integer) {
                statement.setInt(1, (Integer) valor);
            } else if (valor instanceof Double) {
                statement.setDouble(1, (Double) valor);
            } else {
                // Handle other data types if needed
                throw new IllegalArgumentException("Unsupported data type for property value: " + valor.getClass());
            }

            MedidaDao medidaDao = new MedidaDao(ds);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    // Create and populate the Insumo object from the result set
                    int idMedida = 0;
                    Medida medida = null;
                    Insumo insumo = new InsumoLiquido();
                    insumo.setCodInsumo(resultSet.getInt("codInsumo"));
                    idMedida = resultSet.getInt("idMedida");
                    medida = medidaDao.buscarPorID(idMedida);
                    insumo.setMedidaCompra(medida);
                    insumo.setNomInsumo(resultSet.getString("nomInsumo"));
                    insumo.setPrecioCosto(resultSet.getDouble("precioCosto"));
                    insumo.setCantInsumo(resultSet.getInt("cantInsumo"));
                    //insumo.setDensidad(resultSet.getDouble("densidad"));
                    //insumo.setFlagEstado(resultSet.getString("flagEstado"));
                    // Add the Insumo object to the list
                    insumos.add(insumo);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DataAccessException("Error while searching for Insumo by property: " + e.getMessage(), e);
        }
        return insumos;
    }
    private Insumo createInsumoFromResultSet(ResultSet resultSet) throws SQLException {
        int idMedida = resultSet.getInt("idMedida");
        int codInsumo = resultSet.getInt("codInsumo");
        String nomInsumo = resultSet.getString("nomInsumo");
        double precioCosto = resultSet.getDouble("precioCosto");
        int cantInsumo =(int) resultSet.getDouble("cantInsumo");
        double densidad = resultSet.getDouble("densidad");
        boolean flagEstado = resultSet.getString("flagEstado").equals("1");
        // Load Medida using MedidaDAO or MedidaDataSource
        MedidaDao medidaDao = new MedidaDao(ds); // Assuming MedidaDAOImpl implements MedidaDao
        Medida medida = medidaDao.buscarPorID(idMedida);
        //return new InsumoLiquido(id, medida, nomInsumo, precioCosto, cantInsumo, densidad, flagEstado);
        return new InsumoLiquido(codInsumo, nomInsumo, cantInsumo, medida, precioCosto);
    }
    
}
