package com.oasisdrinks.app.dao;

import com.oasisdrinks.app.models.Medida;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public interface MedidaDaoInterface {

    Medida buscarMedidaPorAbrev(String abrev);
    
}
