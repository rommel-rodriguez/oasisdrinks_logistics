package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Medida;
import java.util.List;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;

public class MedidaDao implements OasisCRUDI<Medida> {
    private DataSource ds = null;

    public MedidaDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public int agregar(Medida t) {
        Medida medida = (Medida) t;

        String sql = "INSERT INTO Medida (nombre, abreviacion) VALUES (?, ?)";
        try (Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
             ) {
            statement.setString(1, medida.getNombre());
            statement.setString(2, medida.getAbrev());
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected == 0) {
                throw new SQLException("Creating Medida failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Creating Medida failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Indicates failure.
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
                    int id = resultSet.getInt("idMedida");
                    String name = resultSet.getString("nombre");
                    String abrev = resultSet.getString("abreviacion");
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
        System.out.println("[DEBUG] Inside MedidaDao actualizar method");
        Medida medida = (Medida) t;
        String sql = "UPDATE Medida SET nombre=?, abreviacion=? WHERE idMedida=?";
        try (Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
             ) {
            statement.setString(1, medida.getNombre());
            statement.setString(2, medida.getAbrev());
            statement.setInt(3, medida.getId());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return -1; // Indicates failure.
    }

    @Override
    public int eliminar(int id) {
        String sql = "DELETE FROM Medida WHERE idMedida=?";
        try (Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
             ) {
            statement.setInt(1, id);
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception or rethrow it as needed.
        }
        return -1; // Indicates failure.
    }

    @Override
    public Medida buscarPorID(int id) {
        List<Medida> medidas = new ArrayList<>();
        String sql = "SELECT * FROM Medida WHERE idMedida=?";

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
                    String abrev = resultSet.getString("abreviacion");

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
        System.out.println("[DEBUG] DAO Search by Prop: Medida criteria:  propiedad: "
            + propiedad
            + " valor: "
            + valor);

        try (
            Connection connection = ds.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql)
            ) {
            statement.setObject(1, valor);
            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("idMedida");
                    String name = resultSet.getString("nombre");
                    String abrev = resultSet.getString("abreviacion");
                    
                    Medida medida = new Medida(id, name, abrev);
                    medidas.add(medida);
                }
            }

            // return medidas;
        } catch (SQLException ex) {
            // Handle or rethrow the exception as needed
            // throw new SQLDataAccessException(ex.getStackTrace().toString()); 
            System.err.println(ex.getStackTrace().toString());
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return medidas;
    }

    
}
