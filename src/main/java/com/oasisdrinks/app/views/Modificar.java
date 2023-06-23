package com.oasisdrinks.app.views;



/**
 *
 * @author Grupo 3
 */
public class Modificar extends javax.swing.JFrame {
MainView objFrmsistema = new MainView();
    /**
     * Creates new form Modificar
     */
    public Modificar() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Modificar Bebidas");
        CBOINSUMO.addItem(objFrmsistema.insumo0);
        CBOINSUMO.addItem(objFrmsistema.insumo1);

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
        jLabel5 = new javax.swing.JLabel();
        TXTPRECIO = new javax.swing.JTextField();
        TXTCONTENIDO = new javax.swing.JTextField();
        TXTPESO = new javax.swing.JTextField();
        TXTSABOR = new javax.swing.JTextField();
        CBOINSUMO = new javax.swing.JComboBox<>();
        BTNCERRAR = new javax.swing.JButton();
        BTNGRABAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("INSUMO");

        jLabel2.setText("PRECIO");

        jLabel3.setText("CONTENIDO (und.)");

        jLabel4.setText("PESO (gr.)");

        jLabel5.setText("SABOR");

        TXTPRECIO.setColumns(4);

        TXTCONTENIDO.setColumns(4);

        TXTPESO.setColumns(4);

        TXTSABOR.setColumns(15);

        CBOINSUMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBOINSUMOActionPerformed(evt);
            }
        });

        BTNCERRAR.setText("CERRAR");
        BTNCERRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNCERRARActionPerformed(evt);
            }
        });

        BTNGRABAR.setText("GRABAR");
        BTNGRABAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNGRABARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TXTCONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTSABOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTPESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXTPRECIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBOINSUMO, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTNCERRAR)
                    .addComponent(BTNGRABAR))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(CBOINSUMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNCERRAR))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXTPRECIO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTNGRABAR))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(TXTCONTENIDO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(TXTPESO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXTSABOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNCERRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNCERRARActionPerformed
        // TODO add your handling code here:
        objFrmsistema.setVisible(true);
        this.setVisible(false);   
    }//GEN-LAST:event_BTNCERRARActionPerformed

    private void CBOINSUMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOINSUMOActionPerformed
        // TODO add your handling code here:
        if (CBOINSUMO.getSelectedItem()==objFrmsistema.insumo0)
        {
            TXTPRECIO.setText(Double.toString(MainView.precio0));
            TXTCONTENIDO.setText(Integer.toString(MainView.contenido0));
            TXTPESO.setText(Double.toString(MainView.peso0));
            TXTSABOR.setText(MainView.sabor0);
        }
        else
            if (CBOINSUMO.getSelectedItem()==objFrmsistema.insumo1)
        {
            TXTPRECIO.setText(Double.toString(MainView.precio1));
            TXTCONTENIDO.setText(Integer.toString(MainView.contenido1));
            TXTPESO.setText(Double.toString(MainView.peso1));
            TXTSABOR.setText(MainView.sabor1);
       
        }
    }//GEN-LAST:event_CBOINSUMOActionPerformed

    private void BTNGRABARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGRABARActionPerformed
        // TODO add your handling code here:
        if (CBOINSUMO.getSelectedItem()==objFrmsistema.insumo0)
        {
            objFrmsistema.precio0=Double.parseDouble(TXTPRECIO.getText());
            objFrmsistema.contenido0=Integer.parseInt(TXTCONTENIDO.getText());
            objFrmsistema.peso0=Double.parseDouble(TXTPESO.getText());
            objFrmsistema.sabor0=TXTSABOR.getText();
        }
        else
            if (CBOINSUMO.getSelectedItem()==objFrmsistema.insumo1)
        {
            objFrmsistema.precio1=Double.parseDouble(TXTPRECIO.getText());
            objFrmsistema.contenido1=Integer.parseInt(TXTCONTENIDO.getText());
            objFrmsistema.peso1=Double.parseDouble(TXTPESO.getText());
            objFrmsistema.sabor1=TXTSABOR.getText();
       
        }
    }//GEN-LAST:event_BTNGRABARActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNCERRAR;
    private javax.swing.JButton BTNGRABAR;
    private javax.swing.JComboBox<String> CBOINSUMO;
    private javax.swing.JTextField TXTCONTENIDO;
    private javax.swing.JTextField TXTPESO;
    private javax.swing.JTextField TXTPRECIO;
    private javax.swing.JTextField TXTSABOR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
