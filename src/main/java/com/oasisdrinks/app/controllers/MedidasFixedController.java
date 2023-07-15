/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import com.oasisdrinks.app.utils.dbconnection.HikariCPConnectionPool;
import com.oasisdrinks.app.views.MedidaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class MedidasFixedController implements ActionListener, ListSelectionListener {

    private MedidaService modelService;
    private MedidaView view;
    private ConnectionFactory conFactory;

    public MedidasFixedController(MedidaService modelService, MedidaView view) {
        this.modelService = modelService;
        this.view = view;
    }

    public void addMedida(Medida medida) {
        // modelService.add(medida);
    }

    public void updateMedida(Medida medida) {
        // modelService.update(medida);
    }

    public void deleteMedida(int id) {
        modelService.delete(id);
    }

    // Other methods for interacting with the service layer

    public void refreshView() {
        // List<Medida> medidas = modelService.getAllMedidas();
        // view.displayMedidas(medidas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Medida getModelFromForm() {
        return null;
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }

    private void fillMedidasCombo () {
    }

    public Medida buscarMedidaPorAbrev(String abrev) {
       return modelService.buscarMedidaPorAbrev(abrev) ;
    }
    
}
