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
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class InsumoController implements ActionListener, ListSelectionListener {

    private InsumoService modelService;
    private InsumoView view;
    private ConnectionFactory conFactory;

    public InsumoController(InsumoService modelService, InsumoView view) {
        this.modelService = modelService;
        this.view = view;

        view.getBtnNuevo().addActionListener(this);
        view.getBtnGuardar().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getRefreshButton().addActionListener(this);
        view.getFilterButton().addActionListener(this);
        view.getTblDatos()
            .getSelectionModel()
            .addListSelectionListener(this);
        init();
    }


    public void init() {
        fillMedidasCombo();
        fillFilterCombo();
        readAction();
        centerTableCells();
    }

    private void centerTableCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        view.getTblDatos().setDefaultRenderer(Object.class, centerRenderer);
    }

    public void refreshAction() {
        emptyForm();
        readAction();
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
            deleteAction();
        } else if ( source ==  view.getUpdateButton()) {
            System.out.println("[DEBUG]  Update button pressed");
            updateAction();
        } else if ( source ==  view.getFilterButton()) {
            System.out.println("[DEBUG]  Filter button pressed");
            filterAction();
        } else if ( source ==  view.getRefreshButton()) {
            System.out.println("[DEBUG]  Filter button pressed");
            refreshAction();
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
                                           
        Insumo insumo = null;
        
        insumo = getModelFromForm();

        if (insumo == null) {
            System.out.println("[DEBUG]  Model could not be created from form");
            return;
        }
        
        // agregarFila(insumo, (DefaultTableModel) view.getTblDatos().getModel()); //MM, sino se invoca, no se adiciona registros

        try {
            modelService.add(insumo);
        } catch ( BusinessException.DensidadRangoNoPermitido ble) {
            JOptionPane.showMessageDialog(null, ble.getMessage());
        }
        readAction();
    }

    private void updateAction () {
                                             
        Insumo insu =  getModelFromForm();

        modelService.update(insu);
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

    private void filterAction() {
                                             
        List<Insumo> insumos = modelService.getAll();
        List<Insumo> filtered = new ArrayList<>();
        String property = view.getFilterCombo().getSelectedItem().toString();

        System.out.println("[DEBUG] Inside filter action, insumos: " + insumos);
        System.out.println("[DEBUG] Inside filter action, insumos size: " + insumos.size());
        System.out.println("[DEBUG] Inside filter action, property: " + property);
        switch (property) {
            case "id":
                // TODO: Needs validation
                int value = Integer.parseInt( view.getFilterValue().getText() );
                insumos.stream()
                    .filter((insumo) -> insumo.getCodInsumo() == value)
                    .forEach(filtered::add);
                    //.forEach( (insumo) -> filtered.add(insumo));
                // for (Insumo insumo: insumos) {
                //     System.out.println("[DEBUG] Trying Value: " + insumo.getCodInsumo());
                //     if (insumo.getCodInsumo() == value)
                //         System.out.println("DEBUG: Value found!!!: " + value);
                // }

                break;
            case "nombre":
                break;
            default:
                break;
        }
        System.out.println("[DEBUG] Filter result:\n " + filtered);
        loadListToTable(filtered);

    }

    private void loadDataToTable(){
        List<Insumo> insumos = new ArrayList<>();

        insumos = modelService.getAll();

        loadListToTable(insumos);

    }

    private void loadListToTable(List<Insumo> insumos){
        DefaultTableModel tableModel = null;
        tableModel =  (DefaultTableModel) view.getTblDatos().getModel();

        tableModel.setRowCount(0);

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


        medidasCombo = view.getMedidasCombo();

        nom = view.getTxtNombre().getText();
        // abrev = (String) medidasCombo.getSelectedItem();

        // TODO: This field should never be inputted manually
        try{
            cod = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException e) {
            System.out.println("[INFO] No code");
        }
        try {
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

        System.out.println("[DEBUG] Searching for medida with abrev: " + abrev);

        med = createMedidaFromCombo();
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

    private void fillFilterCombo() {
        JComboBox<String> filterCombo = view.getFilterCombo();
        fillCombo(filterCombo, Arrays.asList("id", "nombre", "tipo"));
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
        System.out.println("[DEBUG] Trying to add tor table row insumo:  " + mod);
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

    private Medida createMedidaFromCombo(){
        Medida med = null;
        String abrev;
        MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));

        abrev = (String) view.getMedidasCombo().getSelectedItem();

        med = medidaSrv.buscarMedidaPorAbrev(abrev);

        return med;
    } 
            
}
