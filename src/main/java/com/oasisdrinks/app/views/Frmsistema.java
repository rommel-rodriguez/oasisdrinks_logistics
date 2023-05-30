package com.oasisdrinks.app.views;

import com.oasisdrinks.app.model.Insumo;
import javax.swing.JFrame;
import java.util.*;


/**
 *
 * @author Grupo 3
 */
public class Frmsistema extends javax.swing.JFrame {
    
    
    public static String insumo0 = "Maracuya";
    public static double precio0 = 35.0;
    public static int contenido0 = 12;
    public static double peso0 = 120;
    public static String sabor0 = "Maracuya";
    
     public static String insumo1 = "Chicha";
    public static double precio1 = 40.0;
    public static int contenido1 = 13;
    public static double peso1 = 130;
    public static String sabor1 = "Chicha";
    Map<String, List<?>> cache = new HashMap<>();


    
    // Porcentajes de descuento
public static double porcentaje1 = 3.0;
public static double porcentaje2 = 2.0;


// Cantidad óptima de lotes vendidas
public static int cantidadOptima = 20;

// Cantidad mínima de paquetes adquiridos para obtener el obsequio
public static int cantidadObsequiable = 15;
	
// Obsequio por cantidad mínima de paquetes adquiridos
public static String obsequio = "Balon de gas";

// Número de cliente que recibe el premio sorpresa
public static int numeroClienteSorpresa = 3;

// Premio sorpresa
public static String premioSorpresa = "Peluche de nuestra mascota";


    /**
     * Creates new form Frmsistema
     */
    public Frmsistema() {
        initComponents();
        initializeCache();
        this.setLocationRelativeTo(this);
        this.setTitle("Sistema de Ventas Oasis Drink");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        MNUSalir = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        MNUMantenimiento = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        MNUVENDER = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        MNUCONFIDES = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        MNUCONFCANTOP = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        MNUAcercade = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MNUSalir.setText("Archivo");
        MNUSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUSalirActionPerformed(evt);
            }
        });

        jMenuItem4.setText("Salida");
        MNUSalir.add(jMenuItem4);

        jMenuBar1.add(MNUSalir);

        MNUMantenimiento.setText("Mantenimiento");

        jMenuItem2.setText("Consultar Bebidas");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        MNUMantenimiento.add(jMenuItem2);

        jMenuItem3.setText("Modificar Bebidas");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        MNUMantenimiento.add(jMenuItem3);

        jMenuItem1.setText("Listar Bebidas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        MNUMantenimiento.add(jMenuItem1);

        jMenuItem5.setText("Insumos - Agregar y Listar");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        MNUMantenimiento.add(jMenuItem5);

        jMenuBar1.add(MNUMantenimiento);

        jMenu4.setText("Ventas");

        MNUVENDER.setText("Vender");
        MNUVENDER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUVENDERActionPerformed(evt);
            }
        });
        jMenu4.add(MNUVENDER);

        jMenuItem6.setText("Generar reportes");
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Configuración");

        MNUCONFIDES.setText("Configurar descuentos");
        MNUCONFIDES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUCONFIDESActionPerformed(evt);
            }
        });
        jMenu5.add(MNUCONFIDES);

        jMenuItem9.setText("Configurar obsequio");
        jMenu5.add(jMenuItem9);

        MNUCONFCANTOP.setText("Configurar cantidad óptima de gaseosas vendidos");
        MNUCONFCANTOP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUCONFCANTOPActionPerformed(evt);
            }
        });
        jMenu5.add(MNUCONFCANTOP);

        jMenuItem11.setText("Configurar premio sorpresa");
        jMenu5.add(jMenuItem11);

        jMenuBar1.add(jMenu5);

        MNUAcercade.setText("Ayuda");
        MNUAcercade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MNUAcercadeActionPerformed(evt);
            }
        });

        jMenuItem7.setText("Acerca de Tienda");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        MNUAcercade.add(jMenuItem7);

        jMenuBar1.add(MNUAcercade);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void initializeCache() {
        List<Insumo> insumos = new ArrayList<>();
        this.cache.put("insumos", insumos);
    }

    private void MNUSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        
    }//GEN-LAST:event_MNUSalirActionPerformed

    private void MNUAcercadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUAcercadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MNUAcercadeActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        dlgAcercade objdlgAcercade = new dlgAcercade(this, rootPaneCheckingEnabled);
        objdlgAcercade.setVisible(true);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        Consultar objConsultar = new Consultar();
        objConsultar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        Modificar objModificar = new Modificar();
        objModificar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void MNUVENDERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUVENDERActionPerformed
        // TODO add your handling code here:
        Vender objVender = new Vender();
        objVender.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MNUVENDERActionPerformed

    private void MNUCONFIDESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUCONFIDESActionPerformed
        // TODO add your handling code here:
        ConfigurarDescuento objConfigurarDescuento = new ConfigurarDescuento();
        objConfigurarDescuento.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MNUCONFIDESActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Listar objListar = new Listar();
        objListar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void MNUCONFCANTOPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MNUCONFCANTOPActionPerformed
        // TODO add your handling code here:
        ConfigurarCantidadOptima objConfigurarCantidadOptima = new ConfigurarCantidadOptima();
        objConfigurarCantidadOptima.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_MNUCONFCANTOPActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JFrame insumoView = new jfrmInsumo(cache);
        insumoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        insumoView.setVisible(true);
        // this.setVisible(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

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
            java.util.logging.Logger.getLogger(Frmsistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frmsistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frmsistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frmsistema.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frmsistema().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MNUAcercade;
    private javax.swing.JMenuItem MNUCONFCANTOP;
    private javax.swing.JMenuItem MNUCONFIDES;
    private javax.swing.JMenu MNUMantenimiento;
    private javax.swing.JMenu MNUSalir;
    private javax.swing.JMenuItem MNUVENDER;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem9;
    // End of variables declaration//GEN-END:variables
}
