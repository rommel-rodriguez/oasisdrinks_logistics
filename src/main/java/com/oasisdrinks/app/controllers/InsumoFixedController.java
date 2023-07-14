/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.service.InsumoService;
import com.oasisdrinks.app.service.MedidaService;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import com.oasisdrinks.app.utils.dbconnection.HikariCPConnectionPool;
import com.oasisdrinks.app.views.InsumoView;
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
public class InsumoFixedController implements ActionListener, ListSelectionListener {

    private InsumoService modelService;
    private InsumoView view;
    private ConnectionFactory conFactory;

    public InsumoFixedController(InsumoService modelService, InsumoView view) {
        this.modelService = modelService;
        this.view = view;
        this.conFactory = new HikariCPConnectionPool();
        // Set up event listeners and other initialization
        // ...
    }

    public void addInsumo(Insumo insumo) {
        modelService.add(insumo);
    }

    public void updateInsumo(Insumo insumo) {
        modelService.update(insumo);
    }

    public void deleteInsumo(int id) {
        modelService.delete(id);
    }

    // Other methods for interacting with the service layer

    public void refreshView() {
        List<Insumo> insumos = modelService.getAllInsumos();
        view.displayInsumos(insumos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Insumo getModelFromForm() {
        // MM, Se programa el boton guardar:
        int cod, cant;
        String nom, und;
        double pcosto, dens;
        Medida med = null;
        JComboBox<String> medidasCombo = null;


        nom = txtNombre.getText();
        und = (String) medidasCombo.getSelectedItem();

        try {
            cod = Integer.parseInt(txtCodigo.getText());
            cant = Integer.parseInt(txtCantidad.getText());
            pcosto = Double.parseDouble(txtPrecioCosto.getText());
            dens = Double.parseDouble(txtDensidad.getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           this,
               "Uno de los campos numericos posee un valor invalido",
                  "Error no es numero",
            JOptionPane.ERROR_MESSAGE);
            return;
        }

        MedidaController medidaCtrl = new MedidaController();
        medidaCtrl.setCache(cache);

        med = medidaCtrl.buscarMedidaPorAbrev(und);

        if (med ==  null)
            med = new Medida(0, "Not Found", "N.F.");

        
        Insumo insu = new InsumoLiquido(dens, cod, nom, cant, med, pcosto);
        agregarFila(insu); //MM, sino se invoca, no se adiciona registros
        addRecord(insu); //MM, sino se invoca, no se adiciona registros

        return null;
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }

    private void fillMedidasCombo () {
        List<Medida> meds = null;
        List<String> abrevList = new ArrayList<>();
        MedidaService medidaSrv = null; 

        medidaSrv = new MedidaService(new MedidaDao());

        if (this.useCache) {
            if (this.cache == null || this.medidas == null)
                return;

            medidaCtrl.setUseCache(true);
            medidaCtrl.setCache(cache);
        }


        meds = 

        if (meds == null) {
            JOptionPane.showMessageDialog(this, "No se pudieron conseguir las medidas!",
                           "Error Medidas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        meds.forEach(medida -> abrevList.add(medida.getAbrev()));


        fillCombo(medidasCombo, abrevList);
    }
    
}
