package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.exceptions.DataAccessException;
import com.oasisdrinks.app.models.Medida;
import java.util.List;
import javax.sql.DataSource;
import java.util.*;
import java.sql.*;

public class MedidaDao implements BasicCRUDInterface <Medida>,MedidaDaoInterface {
    private DataSource ds = null;

    public MedidaDao(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public void agregar(Medida t) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medida> listar() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(Medida t) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medida buscarPorID(int id) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Medida> buscarPorPropiedad(String propiedad, Object valor) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Medida buscarMedidaPorAbrev(String abrev) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
