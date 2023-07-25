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
import java.util.ArrayList;
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
public class MedidaFixedController implements ActionListener, ListSelectionListener {

    private MedidaService modelService;
    private MedidaView view;
    private ConnectionFactory conFactory;

    public MedidaFixedController(MedidaService modelService, MedidaView view) {
        this.modelService = modelService;
        this.view = view;
        view.getBtnGuardar().addActionListener(this);
        view.getBtnNuevo().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getTblDatos()
            .getSelectionModel()
            .addListSelectionListener(this);
        init();
    }

    private void init() {
        // fillFilterCombo();
        readAction();
        centerTableCells();
    }

    private void centerTableCells() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        view.getTblDatos().setDefaultRenderer(Object.class, centerRenderer);
    }

    private void readAction() {
        loadDataToTable();
    }

    private void filterAction() {
        //List<Medida> medidas = modelService.getAll();
        //List<Medida> filtered = new ArrayList<>();
        //String property = view.getFilterCombo().getSelectedItem().toString();

        //System.out.println("[DEBUG] Inside filter action, medidas: " + medidas);
        //System.out.println("[DEBUG] Inside filter action, medidas size: " + medidas.size());
        //System.out.println("[DEBUG] Inside filter action, property: " + property);
        //switch (property) {
        //    case "id":
        //        // TODO: Needs validation
        //        int value = Integer.parseInt( view.getFilterValue().getText() );
        //        medidas.stream()
        //            .filter((medida) -> medida.getCodMedida() == value)
        //            .forEach(filtered::add);

        //        break;
        //    case "nombre":
        //        break;
        //    default:
        //        break;
        //}
        //System.out.println("[DEBUG] Filter result:\n " + filtered);
        //loadListToTable(filtered);

    }

    private void loadDataToTable(){
        List<Medida> medidas = new ArrayList<>();

        medidas = modelService.getAll();

        loadListToTable(medidas);

    }

    private void loadListToTable(List<Medida> insumos){
        DefaultTableModel tableModel = null;
        tableModel =  (DefaultTableModel) view.getTblDatos().getModel();

        tableModel.setRowCount(0);

        if (insumos == null || insumos.isEmpty())
            return;

        for (Medida insu: insumos) {
            agregarFila(insu, tableModel);
        }
    }

    private Medida getModelFromForm() {
        int cod = 0;
        String nombre = "";
        String abrev = null;

        nombre = view.getTxtNombre().getText();
        abrev = view.getTxtAbrev().getText();
        try{
            cod = Integer.parseInt(view.getTxtCodigo().getText());
        } catch (NumberFormatException e) {
            System.out.println("[DEBUG] No code");
        }

        System.out.println("[DEBUG] Searching for medida with abrev: " + abrev);

        Medida medida = new Medida();
        medida.setId(cod);
        medida.setNombre(nombre);
        medida.setAbrev(abrev);

        return medida; 
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }


    // private void fillFilterCombo() {
    //     JComboBox<String> filterCombo = view.getFilterCombo();
    //     fillCombo(filterCombo, Arrays.asList("id", "nombre", "tipo"));
    // }
    
    private void emptyForm () {
        System.out.println("[DEBUG]  Nuevo button pressed");
        view.getTxtCodigo().setText("");
        view.getTxtAbrev().setText("");
        view.getTxtNombre().setText("");
    }

    private void agregarFila(Medida mod, DefaultTableModel tblModel){
        //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        System.out.println("[DEBUG] Trying to add tor table row medida:  " + mod);
        String medidaFQClass; // Fully Qualified name of the Medida subclass
        String medidaClass;
        String classParts[] = null;


        medidaFQClass = mod.getClass().toString();
        classParts = medidaFQClass.split("\\.");
        medidaClass = classParts[classParts.length - 1];

        //tblModel.addRow(new Object[]{
        //    mod.getId(), 
        //    mod.getNombre(),
        //    mod.getAbrev()
        //});

        tblModel.addRow(modelToArray(mod));
    }

    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        view.getTxtCodigo().setText(rowObjects.get(0).toString());
        view.getTxtNombre().setText(rowObjects.get(1).toString());
        view.getTxtAbrev().setText(rowObjects.get(1).toString());
        
    }

    private Object[]  modelToArray (Medida mod) {
        return new Object[] {
            mod.getId(),
            mod.getNombre(),
            mod.getAbrev()
        };
    }

    // private Medida createMedidaFromCombo(){
    //     Medida med = null;
    //     String abrev;
    //     MedidaService medidaSrv = new MedidaService(new MedidaDao( new MySQLPool()));

    //     abrev = (String) view.getMedidasCombo().getSelectedItem();

    //     med = medidaSrv.buscarMedidaPorAbrev(abrev);

    //     return med;
    // } 

    public void createAction() {

        modelService.add(getModelFromForm());
        readAction();
    }

    public void updateAction() {
        modelService.update(getModelFromForm());
        readAction();
    }

    public void deleteAction() {
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
        //readAction();
        loadDataToTable();
        //modelService.delete(id);
    }


    public void refreshView() {
        // List<Medida> medidas = modelService.getAllMedidas();
        // view.displayMedidas(medidas);
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



    private void fillMedidasCombo () {
    }

    //public Medida buscarMedidaPorAbrev(String abrev) {
    //   return modelService.buscarMedidaPorAbrev(abrev) ;
    //}
    
}
