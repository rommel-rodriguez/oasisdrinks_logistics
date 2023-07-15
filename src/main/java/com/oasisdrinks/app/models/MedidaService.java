package com.oasisdrinks.app.models;

import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.exceptions.SQLDataAccessException;
import com.oasisdrinks.app.models.Medida;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class MedidaService {
    private MedidaDao medidaDao;

    public MedidaService(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public void add(Medida medida) {
        // Perform validation or other business logic checks
        // before adding the medida to the data store
        medidaDao.agregar(medida);
    }

    public void update(Medida medida) {
        // Perform validation or other business logic checks
        // before updating the medida in the data store
        medidaDao.actualizar(medida);
    }

    public void delete(int id) {
        // Perform validation or other business logic checks
        // before deleting the medida from the data store
        medidaDao.eliminar(id );
    }

    public List<Medida> getAll() {
        // Retrieve all medidas from the data store
        return medidaDao.listar();
    }

    public Medida buscarMedidaPorAbrev(String abrev) {
        List<Medida> medidas = new ArrayList<>();
        
        medidas = medidaDao.buscarPorPropiedad("abrev", abrev);

        return medidas.stream().findFirst().orElse(null);
    }

    public Medida buscarMedidaPorNombre(String nombre) {
        List<Medida> medidas = new ArrayList<>();
        
        medidas = medidaDao.buscarPorPropiedad("nombre", nombre);

        return medidas.stream().findFirst().orElse(null);
    }
}
