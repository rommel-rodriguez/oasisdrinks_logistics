/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.exceptions.BusinessException;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.InsumoLiquido;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.models.InsumoSolido;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import com.oasisdrinks.app.utils.dbconnection.HikariCPConnectionPool;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.InsumoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

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
        view.getBtnNuevo().addActionListener(this);
        view.getBtnGuardar().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getTblDatos()
            .getSelectionModel()
            .addListSelectionListener(this);
        init();
    }


    public void init() {
        fillMedidasCombo();
        readAction();
    }

    public void refreshView() {
        // List<Insumo> insumos = modelService.getAllInsumos();
        // view.displayInsumos(insumos);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if ( source == view.getBtnGuardar()) {
            createAction();
        } else if ( source ==  view.getBtnNuevo()) {
            System.out.println("[DEBUG]  Nuevo button pressed");
            emptyForm();
        } else if ( source == view.getDeleteButton() ) {
            System.out.println("[DEBUG]  Delete button pressed");
        } else if ( source ==  view.getUpdateButton()) {
            System.out.println("[DEBUG]  Update button pressed");
        } 
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        if (!e.getValueIsAdjusting()) {
            int selectedRow = view.getTblDatos().getSelectedRow();
            if (selectedRow >= 0) {
                int columnCount = view.getTblDatos().getColumnCount();
                List<Object> rowObjects = new ArrayList<>();

                // Assuming the desired columns are at index 0, 1, and 2
                for (int i = 0; i < columnCount; i++) {
                    Object obj = view.getTblDatos().getValueAt(selectedRow, i);
                    rowObjects.add(obj);
                }
                fillForm(rowObjects);
            }
        }
    }

    private void createAction () {

        System.out.println("[DEBUG]  Guardar button pressed");
                                           
        // MM, Se programa el boton guardar:
        // int cod, cant;
        // String nom, und;
        // double pcosto, dens;
        // Medida med = null;
        Insumo insumo = null;
        
        insumo = getModelFromForm();

        if (insumo == null) {
            System.out.println("[DEBUG]  Model could not be created from form");
            return;
        }
        
        agregarFila(insumo, (DefaultTableModel) view.getTblDatos().getModel()); //MM, sino se invoca, no se adiciona registros

        try {
            modelService.add(insumo);
        } catch ( BusinessException.DensidadRangoNoPermitido ble) {
            JOptionPane.showMessageDialog(null, ble.getMessage());
        }
    }

    private void updateAction () {

    }

    private void deleteAction () {

        int codigo = 0;

        try {
            codigo = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (codigo <= 0) {
            JOptionPane.showMessageDialog(
           null,
               "El codigo indicado no es un entero",
                  "Error no es entero",
            JOptionPane.ERROR_MESSAGE);
            return;

        }

        modelService.delete(codigo);
        loadDataToTable();

    }

    private void readAction() {
        loadDataToTable();
    }

    private void loadDataToTable(){
        List<Insumo> insumos = new ArrayList<>();
        DefaultTableModel tableModel = null;
        tableModel =  (DefaultTableModel) view.getTblDatos().getModel();

        tableModel.setRowCount(0);

        insumos = modelService.getAll();

        if (insumos == null || insumos.isEmpty())
            return;

        for (Insumo insu: insumos) {
            agregarFila(insu, tableModel);
        }
    }

    private Insumo getModelFromForm() {
        // TODO:  Need to add the validations for range and type
        int cod = 0, cant = 0;
        String nom = "", abrev = "";
        double pcosto = 0, dens = 0;
        Medida med = null;
        JComboBox<String> medidasCombo = null;

        MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));

        medidasCombo = view.getMedidasCombo();

        nom = view.getTxtNombre().getText();
        abrev = (String) medidasCombo.getSelectedItem();

        try {
            cod = Integer.parseInt(view.getTxtCodigo().getText());
            cant = Integer.parseInt(view.getTxtCantidad().getText());
            pcosto = Double.parseDouble(view.getTxtPrecioCosto().getText());
            dens = Double.parseDouble(view.getTxtDensidad().getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           null,
               "Uno de los campos numericos posee un valor invalido",
                  "Error no es numero",
            JOptionPane.ERROR_MESSAGE);

            return null;
        }

        med = medidaSrv.buscarMedidaPorAbrev(abrev);
        // med = medidaSrv.buscarMedidaPorNombre(abrev);

        if (med ==  null) {
            System.out.println("[DEBUG] Combo: No se pudo optener medida de base de datos");
            return null;
        }
        
        Insumo insu = new InsumoLiquido(dens, cod, nom, cant, med, pcosto);

        return insu; 
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }

    private void fillMedidasCombo () {
        List<Medida> meds = null;
        List<String> abrevList = new ArrayList<>();
        MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));
        JComboBox<String> medidasCombo = view.getMedidasCombo();

        meds = medidaSrv.getAll();
        System.out.println("[INFO] Medidas listed: " + meds.toString());

        if (meds == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron conseguir las medidas!",
                           "Error Medidas", JOptionPane.ERROR_MESSAGE);
            return;
        }

        meds.forEach(medida -> abrevList.add(medida.getAbrev()));


        fillCombo(medidasCombo, abrevList);
    }
    
    private void emptyForm () {
        System.out.println("[DEBUG]  Nuevo button pressed");
        view.getTxtCantidad().setText("");
        view.getTxtCodigo().setText("");
        view.getTxtDensidad().setText("");
        view.getTxtNombre().setText("");
        view.getTxtPrecioCosto().setText("");
    }

    private void agregarFila(Insumo mod, DefaultTableModel tblModel){
        //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        String insumoFQClass; // Fully Qualified name of the Insumo subclass
        String insumoClass;
        String classParts[] = null;


        insumoFQClass = mod.getClass().toString();
        classParts = insumoFQClass.split("\\.");
        insumoClass = classParts[classParts.length - 1];
        switch (insumoClass){
            case "InsumoLiquido":
                InsumoLiquido i = (InsumoLiquido) mod;
                tblModel.addRow(new Object[]{i.getCodInsumo(), 
                    i.getNomInsumo(), i.getCantInsumo(), i.getMedidaCompra().getAbrev(), i.getDensidad(), i.getPrecioCosto()
                });
                break;
            case "InsumoSolido":
                Insumo s = (InsumoSolido) mod;
                tblModel.addRow(new Object[]{s.getCodInsumo(), 
                    s.getNomInsumo(), s.getCantInsumo(), s.getMedidaCompra().getAbrev(), 0, s.getPrecioCosto()
                });
                break;

        }
    }

    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        view.getTxtCodigo().setText(rowObjects.get(0).toString());
        view.getTxtNombre().setText(rowObjects.get(1).toString());
        view.getTxtCantidad().setText(rowObjects.get(2).toString());
        // TODO: This way of setting medidaCombo might not be the best
        view.getMedidasCombo().setSelectedItem(rowObjects.get(3).toString());
        view.getTxtDensidad().setText(rowObjects.get(4).toString());
        view.getTxtPrecioCosto().setText(rowObjects.get(5).toString());
        
    }

    private Object[]  modelToArray (Insumo mod) {
        return new Object[] {
        };
    }
            
}
