/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oasisdrinks.app.views;

import com.oasisdrinks.app.controllers.InsumoController;
import com.oasisdrinks.app.controllers.MedidaController;
import com.oasisdrinks.app.controllers.ProductoController;
import com.oasisdrinks.app.controllers.RecetaController;
import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.dao.InsumoCacheDao;
import com.oasisdrinks.app.models.Insumo;
import com.oasisdrinks.app.models.InsumoLiquido;
import com.oasisdrinks.app.models.InsumoSolido;
import com.oasisdrinks.app.models.Medida;
import com.oasisdrinks.app.models.Producto;
import com.oasisdrinks.app.models.Receta;
import com.oasisdrinks.app.models.RecetaDetalle;
import java.util.*;
import javax.print.attribute.standard.Media;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class RecetaView extends javax.swing.JFrame {
    
    DefaultTableModel tblModel; //MM, se asigna variable 
    Map<String, List<?>> cache;
    List<RecetaDetalle> detalles = null;
    Receta receta = null;
    Producto producto = null;
    List<Medida> medidas = null;
    boolean useCache = true;
    
    public RecetaView() {
        initComponents();
        tblDatos.getSelectionModel().addListSelectionListener(tableSelectionListener);
        this.tblModel=(DefaultTableModel)tblDatos.getModel(); //MM, Se castea con DefaultTableModel
        this.tblModel.setNumRows(0); //MM, Para inicializar en la pantalla con 0 registros

        // loadDataToView();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCodigoProducto = new javax.swing.JTextField();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        deleteRecetaButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        insumosCombo = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Insumos Management");

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de Receta"));

        jLabel1.setText("Codigo Receta");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jLabel7.setText("Codigo Producto");

        txtCodigoProducto.setEditable(false);
        txtCodigoProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoProductoActionPerformed(evt);
            }
        });

        txtNombreProducto.setEditable(false);
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });

        jLabel8.setText("Nombre Producto");

        deleteRecetaButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/delete.png"))); // NOI18N
        deleteRecetaButton.setText("Eliminar Receta");
        deleteRecetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRecetaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(23, 23, 23)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel1)
                        .addGap(23, 23, 23)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(deleteRecetaButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addGap(23, 23, 23)
                        .addComponent(txtNombreProducto)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteRecetaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Interfaz Detalle"));

        jLabel4.setText("Insumo");

        insumosCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Cantidad");

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/system_software_update_22485.png"))); // NOI18N
        updateButton.setText("Actualizar Detalle");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/delete.png"))); // NOI18N
        deleteButton.setText("Eliminar Detalle");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/boton_guardar.png"))); // NOI18N
        btnGuardar.setText("Agregar Detalle");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/boton_nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(insumosCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGuardar, btnNuevo});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(insumosCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(126, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateButton)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGuardar, btnNuevo, deleteButton, updateButton});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Administracion de Insumos");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Asignando valores en blanco
        this.emptyForm();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //// TODO: Assumes that, if the product does not yet have any Recipe linked to it, the codReceta will be
        //// zero.
        //int codReceta = 0, codProducto;
        //double cant;
        //String nomInsumo;
        //Insumo insumo = null;
        ////Receta receta = null;


        //InsumoController insumoCtrl = new InsumoController();
        //RecetaController recetaCtrl = new RecetaController();
        //ProductoController productoCtrl = new ProductoController();

        //insumoCtrl.setCache(cache);
        //recetaCtrl.setCache(cache);
        //productoCtrl.setCache(cache);

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
        //    // NOTE: This section has to be done prob, with the controller's buscarPorID
        //    // until it returns null;
        //    // The above will be unnecessary when using databases.
        //    int nuevoCodigo = 1;
        //    // if (cache.get("recetas") == null) {
        //    if (recetaCtrl.listarRecetas().size() != 0) {
        //        for (Receta rec: recetaCtrl.listarRecetas() ) {
        //            if (rec.getCodReceta() != nuevoCodigo)
        //                break;

        //            nuevoCodigo += 1;
        //        }
        //    }

        //    receta = new Receta(nuevoCodigo); // TODO: I have to assign a reasonable code here
        //    recetaCtrl.agregarReceta(receta);
        //} else {
        //    // receta = // TODO: I need to implemente th controller for this to work
        //    receta = recetaCtrl.buscarPorId(codReceta);
        //}


        //System.out.println("[INFO] State of recetas cache " + cache.get("recetas"));
        //System.out.println("[INFO] before assign to txtCodigoReceta, codigo: " + receta.getCodReceta());
        //txtCodigoReceta.setText(""+receta.getCodReceta());

        //// this.producto.setReceta(receta);

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
        //productoCtrl.actualizarProducto(producto);
        //        

        //// Third, send all the changes through the controller and the daos
        //agregarFila(detalle); //MM, sino se invoca, no se adiciona registros
        //// addRecord(detalle); //MM, sino se invoca, no se adiciona registros
        //// This adds, deletes or modifies 
        //// recetaCtrl.actualizarReceta(receta);
        //// TODO: Need a store method here that does create or update the receta
        //recetaCtrl.agregarReceta(receta);
        //recetaCtrl.actualizarReceta(receta);
    
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed


    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
    }//GEN-LAST:event_updateButtonActionPerformed

    private void txtCodigoProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoProductoActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void deleteRecetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRecetaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteRecetaButtonActionPerformed
    private ListSelectionListener tableSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
            }
        }
    };


    public void setCache(Map<String, List<?>> cache) {
        if (cache != null) {
            this.cache = cache;
            if (this.useCache){
                // this.producto = (List<Producto>) cache.get("producto");
                this.receta = this.producto.getReceta();
                // this.detalles = this.producto.getReceta().getDetalles();
            }
        }

        loadDataToView();
    }


    public void setProducto(Producto producto) {

        int codReceta = 0;

        this.producto = producto;

        if (producto.getReceta() != null)
            codReceta = producto.getReceta().getCodReceta();

        txtCodigo.setText("" + codReceta);
        // this.receta = producto.getReceta();
    }




    private Medida createMedidaFromCombo(){
        //Medida med = null;
        //String und;
        //und = (String) insumosCombo.getSelectedItem();
        //MedidaController medidaCtrl = new MedidaController();

        //if (this.useCache)
        //    medidaCtrl.setCache(cache);

        //med = medidaCtrl.buscarMedidaPorAbrev(und);

        //if (med ==  null)
        //    med = new Medida(0, "Not Found", "N.F.");

        //return med;
        return null;
    } 

    private void fillCombo(JComboBox combo, List<String> items){
        combo.removeAllItems();
        items.forEach(combo::addItem);
    }


    private void loadDataToTable(){
        //List<RecetaDetalle> detalles = new ArrayList<>();

        //this.tblModel.setRowCount(0);

        //RecetaController insumoCtrl = new RecetaController();

        //if (this.useCache) {
        //    if (this.cache == null || this.receta == null)
        //        return;

        //    insumoCtrl.setUseCache(true);
        //    insumoCtrl.setCache(cache);
        //}

        //// detalles = insumoCtrl.listarRecetaDetalles();
        //detalles = this.receta.getDetalles();

        //if (detalles  == null)
        //    return;

        //for (RecetaDetalle insu: detalles) {
        //    agregarFila(insu);
        //}
    }

    private void fillInsumosCombo () {
        //List<Insumo> meds = null;
        //List<String> abrevList = new ArrayList<>();
        //InsumoController insumoCtrl = new InsumoController();

        //if (this.useCache) {
        //    if (this.cache == null)
        //        return;

        //    insumoCtrl.setUseCache(true);
        //    insumoCtrl.setCache(cache);
        //}


        //meds = insumoCtrl.listarInsumos();

        //if (meds == null) {
        //    JOptionPane.showMessageDialog(this, "No se pudieron conseguir las insumos!",
        //                   "Error Insumos", JOptionPane.ERROR_MESSAGE);
        //    return;
        //}

        //meds.forEach(insumo -> abrevList.add(insumo.getNomInsumo()));


        //fillCombo(insumosCombo, abrevList);
    }

    private void loadDataToView() {
        fillProductData();
        loadDataToTable();
        fillInsumosCombo();
        
    }

    private void emptyForm () {
        this.txtCantidad.setText("");
    }


    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        this.insumosCombo.setSelectedItem(rowObjects.get(1).toString());
        this.txtCantidad.setText(rowObjects.get(2).toString());
    }

    private void fillProductData() {
        emptyForm();
        this.txtCodigoProducto.setText( "" + this.producto.getCodProducto());
        this.txtNombreProducto.setText(this.producto.getNomProducto());

        if (this.receta != null)
            this.txtCodigo.setText("" + this.receta.getCodReceta());

    }


    private Object[]  modelToArray (RecetaDetalle model) {
        return new Object[] {
            model.getInsumo().getCodInsumo(),
            model.getInsumo().getNomInsumo(),
            model.getCantidad()
        };
    }

    private void agregarFila(RecetaDetalle detalle){
        //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        tblModel.addRow(modelToArray(detalle));

    }
            
    private void addRecord(Insumo insu){
    //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        // System.out.println("Adding Record to DB");
        // // InsumoDao inDao = new InsumoCacheDao(cache);
        // InsumoController inCon = new InsumoController();
        // inCon.setCache(cache);
        // inCon.agregarInsumo(insu);

        // System.out.printf("Insumos Record's Size: ");
        // System.out.println(cache.get("insumos").size());
        // System.out.println("Insumos Record:");
        // System.out.println(cache.get("insumos"));
        // System.out.println("Whole");
        // System.out.println(cache);
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }


    public JButton getBtnNuevo() {
        return btnNuevo;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getDeleteRecetaButton() {
        return deleteRecetaButton;
    }

    public JComboBox<String> getInsumosCombo() {
        return insumosCombo;
    }

    public JTable getTblDatos() {
        return tblDatos;
    }

    public JTextField getTxtCantidad() {
        return txtCantidad;
    }

    public JTextField getTxtCodigoProducto() {
        return txtCodigoProducto;
    }

    public JTextField getTxtCodigo() {
        return txtCodigo;
    }


    public JTextField getTxtNombreProducto() {
        return txtNombreProducto;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RecetaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecetaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecetaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecetaView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecetaView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton deleteRecetaButton;
    private javax.swing.JComboBox<String> insumosCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
