/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oasisdrinks.app.controllers;

import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.dao.MedidaDao;
import com.oasisdrinks.app.dao.ProductoDao;
import com.oasisdrinks.app.exceptions.BusinessException;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.InsumoService;
import com.oasisdrinks.app.models.Receta;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.RecetaService;
import com.oasisdrinks.app.models.MedidaService;
import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.models.ProductoService;
import com.oasisdrinks.app.models.RecetaDetalle;
import com.oasisdrinks.app.utils.dbconnection.ConnectionFactory;
import com.oasisdrinks.app.utils.dbconnection.HikariCPConnectionPool;
import com.oasisdrinks.app.utils.dbconnection.MySQLPool;
import com.oasisdrinks.app.views.RecetaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class RecetaController implements ActionListener, ListSelectionListener {

    private RecetaService modelService;
    private int idReceta = 0;
    private Producto producto;
    private RecetaView view;
    private ConnectionFactory conFactory;
    private boolean isNewReceta = false;

    public RecetaController(RecetaService modelService, RecetaView view, int idProdcuto) {
        this.modelService = modelService;
        this.view = view;

        view.getBtnNuevo().addActionListener(this);
        view.getBtnGuardar().addActionListener(this);
        view.getDeleteButton().addActionListener(this);
        view.getUpdateButton().addActionListener(this);
        view.getDeleteRecetaButton().addActionListener(this);
        //view.getRefreshButton().addActionListener(this);
        //view.getFilterButton().addActionListener(this);
        view.getTblDatos()
            .getSelectionModel()
            .addListSelectionListener(this);
        setIdProducto(idProdcuto);
        init();
    }


    public void init() {
        fillInsumosCombo();
        centerTableCells();

        if (idReceta == 0)
            return;

        readAction();
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
                                           
        Receta receta = null;
        
        receta = getModelFromForm();

        if (receta == null) {
            System.out.println("[DEBUG]  Model could not be created from form");
            return;
        }
        
        /////////////////////////////////////////////////////////////////////

        // TODO: Assumes that, if the product does not yet have any Recipe linked to it, the codReceta will be
        // zero.
        int codProducto = this.producto.getCodProducto();
        double cant;
        String nomInsumo;
        Insumo insumo = null;
        //Receta receta = null;


        InsumoService insumoSrv = new InsumoService(
            new InsumoDao(new MySQLPool())
        );

        ProductoService productoSrv = new ProductoService(
            new ProductoDao(new MySQLPool())
        );

        nomInsumo = (String) view.getInsumosCombo().getSelectedItem();
        try {
            codProducto = Integer.parseInt(view.getTxtCodigoProducto().getText());
            idReceta = Integer.parseInt(view.getTxtCodigo().getText());
            cant = Double.parseDouble(view.getTxtCantidad().getText());
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(
           null,
               "Uno de los campos numericos posee un valor invalido",
                  "Error no es numero",
            JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create receta if none exists
        if (idReceta == 0) {
            int nuevoCodigo = 1;
            if (modelService.getAll().size() != 0) {
                for (Receta rec: modelService.getAll()) {
                    if (rec.getCodReceta() != nuevoCodigo)
                        break;

                    nuevoCodigo += 1;
                }
            }

            receta = new Receta(nuevoCodigo); // TODO: I have to assign a reasonable code here
            modelService.add(receta);
        } else {
            // receta = // TODO: I need to implemente th controller for this to work
            receta = modelService.buscarPorID(idReceta);
        }


        System.out.println("[INFO] before assign to txtCodigoReceta, codigo: " + receta.getCodReceta());
        view.getTxtCodigo().setText(""+receta.getCodReceta());

        // this.producto.setReceta(receta);

        insumo = insumoSrv.buscarPorNombre(nomInsumo);

        if (insumo ==  null)
            JOptionPane.showMessageDialog(null, "Insumo to be add returned null");
        
        
        // Create a new detail
        RecetaDetalle detalle = new RecetaDetalle(insumo, cant);

        // First lets update the receta
        receta.agregarDetalle(detalle);

        // Second, assign the updated receta to the Product
        this.producto.setReceta(receta);
        productoSrv.update(producto);
                

        // Third, send all the changes through the controller and the daos
        DefaultTableModel tblModel = (DefaultTableModel) view.getTblDatos().getModel();
        agregarFila(detalle, tblModel); //MM, sino se invoca, no se adiciona registros
        // addRecord(detalle); //MM, sino se invoca, no se adiciona registros
        // This adds, deletes or modifies 
        // recetaCtrl.actualizarReceta(receta);
        // TODO: Need a store method here that does create or update the receta
        // TODO: Really not sure about this.
        modelService.add(receta);
        modelService.update(receta);



        readAction();
    }

    private void updateAction () {
                                             
        Receta insu =  getModelFromForm();

        modelService.update(insu);

        //int codReceta, codProducto;
        //double cant;
        //String nomInsumo;
        //Insumo insumo = null;
        //Receta receta = null;


        //InsumoController insumoCtrl = new InsumoController();
        //RecetaController recetaCtrl = new RecetaController();
        //insumoCtrl.setCache(cache);

        //nomInsumo = (String) insumosCombo.getSelectedItem();
        //try {
        //    codProducto = Integer.parseInt(txtCodigoProducto.getText());
        //    codReceta = Integer.parseInt(txtCodigoReceta.getText());
        //    cant = Double.parseDouble(txtCantidad.getText());
        //} catch (NumberFormatException nfe) {
        //    JOptionPane.showMessageDialog(
        //   this,
        //       "Uno de los campos numericos posee un valor invalido",
        //          "Error no es numero",
        //    JOptionPane.ERROR_MESSAGE);
        //    return;
        //}

        //// Create receta if none exists
        //if (codReceta == 0) {
        //    JOptionPane.showMessageDialog(
        //   this,
        //       "No se puede actualizar sin codigo de receta",
        //          "Error no hay codigo de receta",
        //    JOptionPane.ERROR_MESSAGE);
        //    return;
        //}
        //insumo = insumoCtrl.buscarPorNombre(nomInsumo);

        //if (insumo ==  null)
        //    JOptionPane.showMessageDialog(this, "Insumo to be add returned null");
        //
        //
        //// Create a new detail
        //RecetaDetalle detalle = new RecetaDetalle(insumo, cant);

        //// First lets update the receta
        //receta.agregarDetalle(detalle);

        //// Second, assign the updated receta to the Product
        //this.producto.setReceta(receta);
        //        

        //recetaCtrl.actualizarReceta(receta);
        //
        //loadDataToTable();
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



        //int codigo = 0;

        //try {
        //    codigo = Integer.parseInt(this.txtCodigoReceta.getText());
        //} catch (NumberFormatException nfe) {
        //    JOptionPane.showMessageDialog(
        //   this,
        //       "El codigo indicado no es un entero",
        //          "Error no es entero",
        //    JOptionPane.ERROR_MESSAGE);
        //    return;
        //}

        //if (codigo == 0)
        //    return;

        //InsumoController inCon = new InsumoController();
        //inCon.setCache(cache);
        //inCon.borrarInsumo(codigo);
        //loadDataToTable();
    }

    private void readAction() {
        loadDataToTable();
    }


    private void loadDataToTable(){
        List<RecetaDetalle> detalles = new ArrayList<>();

        detalles = modelService
            .buscarPorID(idReceta)
            .getDetalles();

        loadListToTable(detalles);

    }

    private void loadListToTable(List<RecetaDetalle> detalles){

        DefaultTableModel tblModel = (DefaultTableModel) view.getTblDatos().getModel();
        tblModel.setRowCount(0);

        // detalles = insumoCtrl.listarRecetaDetalles();
       // detalles = this.receta.getDetalles();

        if (detalles  == null)
            return;

        for (RecetaDetalle detalle: detalles) {
            agregarFila(detalle, tblModel);
        }

    }

    private Receta getModelFromForm() {
        //// TODO:  Need to add the validations for range and type
        //int code = 0, cantidad = 0;
        //String nom = "", abrev = "";
        //double precioCosto = 0, densidad = 0;
        //Medida med = null;
        //JComboBox<String> medidasCombo = null;


        //medidasCombo = view.getMedidasCombo();

        //nom = view.getTxtNombre().getText();
        //// abrev = (String) medidasCombo.getSelectedItem();

        //// TODO: This field should never be inputted manually
        //try{
        //    code = Integer.parseInt(view.getTxtCodigo().getText());
        //} catch (NumberFormatException e) {
        //    System.out.println("[INFO] No code");
        //}
        //try {
        //    cantidad = Integer.parseInt(view.getTxtCantidad().getText());
        //    precioCosto = Double.parseDouble(view.getTxtPrecioCosto().getText());
        //    densidad = Double.parseDouble(view.getTxtDensidad().getText());
        //} catch (NumberFormatException nfe) {
        //    JOptionPane.showMessageDialog(
        //   null,
        //       "Uno de los campos numericos posee un valor invalido",
        //          "Error no es numero",
        //    JOptionPane.ERROR_MESSAGE);

        //    return null;
        //}

        //if (cantidad < 0) {
        //    // Mensaje de error si la cantidad es negativa
        //    JOptionPane.showMessageDialog(view, "La cantidad debe ser un número entero positivo.", "Error", JOptionPane.ERROR_MESSAGE);
        //    return null;
        //}

        //if (precioCosto < 0) {
        //    // Mensaje de error si el precio de costo es negativo
        //    JOptionPane.showMessageDialog(view, "El precio de costo debe ser un número positivo.", "Error", JOptionPane.ERROR_MESSAGE);
        //    return null;
        //}

        //if (densidad <= 0) {
        //    // Mensaje de error si la densidad es menor o igual a cero
        //    JOptionPane.showMessageDialog(view, "La densidad debe ser un número positivo mayor que cero.", "Error", JOptionPane.ERROR_MESSAGE);
        //    return null;
        //}
        //System.out.println("[DEBUG] Searching for medida with abrev: " + abrev);

        //med = createMedidaFromCombo();
        //// med = medidaSrv.buscarMedidaPorNombre(abrev);

        //if (med ==  null) {
        //    System.out.println("[DEBUG] Combo: No se pudo optener medida de base de datos");
        //    return null;
        //}
        //
        //Receta insu = new RecetaLiquido(densidad, code, nom, cantidad, med, precioCosto);

        //return insu; 
        return null;
    }

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }

    private void fillInsumosCombo () {
        List<Insumo> insumos = null;
        List<String> comboList = new ArrayList<>();
        InsumoService insumoSrv = new InsumoService(
            new InsumoDao(new MySQLPool())
        );


        insumos = insumoSrv.getAll();

        if (insumos == null) {
            JOptionPane.showMessageDialog(null, "No se pudieron conseguir las insumos!",
                           "Error Insumos", JOptionPane.ERROR_MESSAGE);
            return;
        }

        insumos.forEach(insumo -> comboList.add(insumo.getNomInsumo()));


        fillCombo(view.getInsumosCombo(), comboList);
    }

    private void emptyForm () {
        System.out.println("[DEBUG]  Nuevo button pressed");
        view.getTxtCantidad().setText("");
    }

    private void fillProductData() {
        //emptyForm();
        //this.txtCodigoProducto.setText( "" + this.producto.getCodProducto());
        //this.txtNombreProducto.setText(this.producto.getNomProducto());

        //if (this.receta != null)
        //    this.txtCodigo.setText("" + this.receta.getCodReceta());

    }

    private void agregarFila(RecetaDetalle mod, DefaultTableModel tblModel){
        //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        System.out.println("[DEBUG] Trying to add tor table row receta:  " + mod);


        tblModel.addRow(modelToArray(mod));
    }

    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        view.getTxtCodigo().setText(rowObjects.get(0).toString());
        view.getInsumosCombo().setSelectedItem(rowObjects.get(1).toString());
        view.getTxtCantidad().setText(rowObjects.get(2).toString());
    }

    private Object[]  modelToArray (RecetaDetalle mod) {
        return new Object[] {
            mod.getInsumo().getCodInsumo(),
            mod.getInsumo().getNomInsumo(),
            mod.getInsumo().getCantInsumo()

        };
    }

    public void setIdProducto(int idProducto) {
        Receta receta = null;
        ProductoService prodSrv = new ProductoService(
            new ProductoDao(new MySQLPool())
        );
        this.producto = prodSrv.buscarPorID(idProducto);
        receta = this.producto.getReceta();
        if (receta == null) {
            isNewReceta = true;
            return;
        }
        this.idReceta = receta.getCodReceta();
    }

            
}
