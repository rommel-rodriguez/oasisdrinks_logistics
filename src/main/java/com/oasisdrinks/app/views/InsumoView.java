/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oasisdrinks.app.views;

import com.oasisdrinks.app.controllers.InsumoController;
import com.oasisdrinks.app.dao.InsumoDao;
import com.oasisdrinks.app.dao.InsumoCacheDao;
import com.oasisdrinks.app.model.Insumo;
import com.oasisdrinks.app.model.InsumoLiquido;
import java.util.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class InsumoView extends javax.swing.JFrame {
    
    DefaultTableModel tblModel; //MM, se asigna variable 
    Map<String, List<?>> cache;
    List<Insumo> insumos;
    
    public InsumoView(Map<String, List<?>> cache) {
        initComponents();
        tblDatos.getSelectionModel().addListSelectionListener(tableSelectionListener);
        this.tblModel=(DefaultTableModel)tblDatos.getModel(); //MM, Se castea con DefaultTableModel
        this.tblModel.setNumRows(0); //MM, Para inicializar en la pantalla con 0 registros
        if (cache != null) {
            this.cache = cache;
            this.insumos = (List<Insumo>) cache.get("insumos");
        }
        // Needs to be after all of the above this.* cause it uses them
        loadDataToTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        txtUnidad = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatos = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtDensidad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtPrecioCosto = new javax.swing.JTextField();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Cantidad");

        jLabel4.setText("Unidad");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/boton_nuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        tblDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Unidad", "Densidad", "PrecioCosto"
            }
        ));
        jScrollPane1.setViewportView(tblDatos);

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/boton_guardar.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setText("Densidad");

        jLabel6.setText("Precio Costo");

        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/delete.png"))); // NOI18N
        deleteButton.setText("Eliminar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        updateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/oasisdrinks/app/views/imagen/system_software_update_22485.png"))); // NOI18N
        updateButton.setText("Actualizar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevo)
                        .addGap(52, 52, 52)
                        .addComponent(btnGuardar)
                        .addGap(208, 208, 208)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPrecioCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(txtDensidad)
                            .addComponent(txtUnidad))
                        .addGap(100, 100, 100)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnGuardar, btnNuevo, deleteButton, updateButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2, jLabel3});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDensidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(updateButton)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnGuardar, btnNuevo, deleteButton, updateButton});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Asignando valores en blanco
        // txtCodigo.setText(""); //MM
        // txtNombre.setText(""); //MM
        // txtCantidad.setText(""); //MM
        // txtUnidad.setText(""); //MM
        // txtPrecioCosto.setText("");
        // txtDensidad.setText(""); //MM
        // txtCodigo.requestFocus(); //MM
        this.emptyForm();
        
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // MM, Se programa el boton guardar:
        int cod, cant;
        String nom, und;
        double pcosto, dens;
        
        cod = Integer.parseInt(txtCodigo.getText());
        nom = txtNombre.getText();
        cant = Integer.parseInt(txtCantidad.getText());
        und = txtUnidad.getText();
        pcosto = Double.parseDouble(txtPrecioCosto.getText());
        dens = Double.parseDouble(txtDensidad.getText());
        
        // InsumoLiquido i = new InsumoLiquido(dens, cod, nom, cant, und, pcosto);
        Insumo insu = new InsumoLiquido(dens, cod, nom, cant, und, pcosto);
        agregarFila(insu); //MM, sino se invoca, no se adiciona registros
        addRecord(insu); //MM, sino se invoca, no se adiciona registros
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
        int codigo = Integer.parseInt(this.txtCodigo.getText());
        InsumoController inCon = new InsumoController();
        inCon.setCache(cache);
        inCon.borrarInsumo(codigo);
        loadDataToTable();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
        int cod, cant;
        String nom, und;
        double pcosto, dens;
        
        cod = Integer.parseInt(txtCodigo.getText());
        nom = txtNombre.getText();
        cant = Integer.parseInt(txtCantidad.getText());
        und = txtUnidad.getText();
        pcosto = Double.parseDouble(txtPrecioCosto.getText());
        dens = Double.parseDouble(txtDensidad.getText());
        
        // InsumoLiquido i = new InsumoLiquido(dens, cod, nom, cant, und, pcosto);
        Insumo insu = new InsumoLiquido(
            dens, cod, nom, cant, und, pcosto);

        InsumoController inCon = new InsumoController();
        inCon.setCache(cache);
        inCon.actualizarInsumo(insu);
        loadDataToTable();
    }//GEN-LAST:event_updateButtonActionPerformed
    private ListSelectionListener tableSelectionListener = new ListSelectionListener() {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = tblDatos.getSelectedRow();
                if (selectedRow >= 0) {
                    int columnCount = tblDatos.getColumnCount();
                    List<Object> rowObjects = new ArrayList<>();

                    // Assuming the desired columns are at index 0, 1, and 2
                    for (int i = 0; i < columnCount; i++) {
                        Object obj = tblDatos.getValueAt(selectedRow, i);
                        rowObjects.add(obj);
                        // if (obj instanceof Integer) {
                        //     int intValue = (Integer) obj;
                        //     System.out.println("Value (int): " + intValue);
                        // } else if (obj instanceof Double) {
                        //     double doubleValue = (Double) obj;
                        //     System.out.println("Value (double): " + doubleValue);
                        // } else if (obj instanceof String) {
                        //     String stringValue = (String) obj;
                        //     System.out.println("Value (String): " + stringValue);
                        // }
                    }
                    fillForm(rowObjects);
                }
            }
        }
    };

    private void loadDataToTable(){
        this.tblModel.setRowCount(0);
        if (this.insumos != null) {
            for (Insumo insu: this.insumos) {
                agregarFila(insu);
            }
        }
    }

    private void emptyForm () {
        this.txtCantidad.setText("");
        this.txtCodigo.setText("");
        this.txtDensidad.setText("");
        this.txtNombre.setText("");
        this.txtPrecioCosto.setText("");
        this.txtUnidad.setText("");
    }


    private void fillForm(List<Object> rowObjects) {
        emptyForm();
        this.txtCodigo.setText(rowObjects.get(0).toString());
        this.txtNombre.setText(rowObjects.get(1).toString());
        this.txtCantidad.setText(rowObjects.get(2).toString());
        this.txtUnidad.setText(rowObjects.get(3).toString());
        this.txtDensidad.setText(rowObjects.get(4).toString());
        this.txtPrecioCosto.setText(rowObjects.get(5).toString());
        
    }
    private void agregarFila(Insumo insu){
    //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        InsumoLiquido i = (InsumoLiquido) insu;
        tblModel.addRow(new Object[]{i.getCodInsumo(), 
            i.getNomInsumo(), i.getCantInsumo(), i.getUnidadCompra(), i.getDensidad(), i.getPrecioCosto()
        });
    }
            
    private void addRecord(Insumo insu){
    //MM, esta funcion se tiene que implementar, porqque esta permite adicionar registro 
        System.out.println("Adding Record to DB");
        // InsumoDao inDao = new InsumoCacheDao(cache);
        InsumoController inCon = new InsumoController();
        inCon.setCache(cache);
        inCon.agregarInsumo(insu);

        System.out.printf("Insumos Record's Size: ");
        System.out.println(cache.get("insumos").size());
        System.out.println("Insumos Record:");
        System.out.println(cache.get("insumos"));
        System.out.println("Whole");
        System.out.println(cache);
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
            java.util.logging.Logger.getLogger(InsumoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InsumoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InsumoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InsumoView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InsumoView(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDensidad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioCosto;
    private javax.swing.JTextField txtUnidad;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
