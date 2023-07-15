package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.exceptions.SQLDataAccessException;
import com.oasisdrinks.app.models.Medida;
import java.util.List;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;

public class MedidaDao implements AltCRUDInterface<Medida> {
    private DataSource ds = null;

    public MedidaDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(Medida t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medida> listar() {
        List<Medida> medidas = new ArrayList<>();
        String sql = "SELECT * FROM Medida order by nombre";

        try (
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
            ) {
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    String abrev = resultSet.getString("abrev");
                    Medida medida = new Medida(id, name, abrev);

                    medidas.add(medida);
                }
            }

            // return medidas;
        } catch (SQLException ex) {
            // Handle or rethrow the exception as needed
            // throw new SQLDataAccessException(ex.getStackTrace().toString()); 
            System.err.println(ex.getStackTrace().toString());
            System.err.println(ex);
            System.err.println("[ERROR] Something went wrong");
        }
        return medidas;
    }

    @Override
    public int actualizar(Medida t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medida buscarPorID(int id) {
        List<Medida> medidas = new ArrayList<>();
        String sql = "SELECT * FROM Medida WHERE id=?";

        try (
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
            ) {

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    // int id = resultSet.getInt("id");
                    String name = resultSet.getString("nombre");
                    String abrev = resultSet.getString("abrev");

                    Medida medida = new Medida(id, name, abrev);

                    medidas.add(medida);
                }
            }

        } catch (SQLException ex) {
            // Handle or rethrow the exception as needed
            // throw new SQLDataAccessException(ex.getStackTrace().toString()); 
            System.err.println(ex.getStackTrace().toString());
            System.err.println(ex);
            System.err.println("[ERROR] Something went wrong");
        }

        return medidas.stream().findFirst().orElse(null);

    }

    @Override
    public List<Medida> buscarPorPropiedad(String propiedad, Object valor){
        List<Medida> medidas = new ArrayList<>();
        String sql = "SELECT * FROM Medida WHERE " + propiedad + " = ?";

        try (
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
            ) {
            statement.setObject(1, valor);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String abrev = resultSet.getString("abrev");
                    
                    Medida medida = new Medida(id, name, abrev);
                    medidas.add(medida);
                }
            }

            // return medidas;
        } catch (SQLException ex) {
            // Handle or rethrow the exception as needed
            // throw new SQLDataAccessException(ex.getStackTrace().toString()); 
            System.err.println(ex.getStackTrace().toString());
        }
        return medidas;
    }

    
}
