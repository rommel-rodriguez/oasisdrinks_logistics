package com.oasisdrinks.app.views;



/**
 *
 * @author Grupo 3
 */
public class Modificar extends javax.swing.JFrame {
Frmsistema objFrmsistema = new Frmsistema();
    /**
     * Creates new form Modificar
     */
    public Modificar() {
        initComponents();
        this.setLocationRelativeTo(this);
        this.setTitle("Modificar Bebidas");
        CBOMARCA.addItem(objFrmsistema.marca0);
        CBOMARCA.addItem(objFrmsistema.marca1);

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
        CBOMARCA = new javax.swing.JComboBox<>();
        BTNCERRAR = new javax.swing.JButton();
        BTNGRABAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MARCA");

        jLabel2.setText("PRECIO");

        jLabel3.setText("CONTENIDO (und.)");

        jLabel4.setText("PESO (gr.)");

        jLabel5.setText("SABOR");

        TXTPRECIO.setColumns(4);

        TXTCONTENIDO.setColumns(4);

        TXTPESO.setColumns(4);

        TXTSABOR.setColumns(15);

        CBOMARCA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBOMARCAActionPerformed(evt);
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
                    .addComponent(CBOMARCA, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(CBOMARCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void CBOMARCAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBOMARCAActionPerformed
        // TODO add your handling code here:
        if (CBOMARCA.getSelectedItem()==objFrmsistema.marca0)
        {
            TXTPRECIO.setText(Double.toString(Frmsistema.precio0));
            TXTCONTENIDO.setText(Integer.toString(Frmsistema.contenido0));
            TXTPESO.setText(Double.toString(Frmsistema.peso0));
            TXTSABOR.setText(Frmsistema.sabor0);
        }
        else
            if (CBOMARCA.getSelectedItem()==objFrmsistema.marca1)
        {
            TXTPRECIO.setText(Double.toString(Frmsistema.precio1));
            TXTCONTENIDO.setText(Integer.toString(Frmsistema.contenido1));
            TXTPESO.setText(Double.toString(Frmsistema.peso1));
            TXTSABOR.setText(Frmsistema.sabor1);
       
        }
    }//GEN-LAST:event_CBOMARCAActionPerformed

    private void BTNGRABARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNGRABARActionPerformed
        // TODO add your handling code here:
        if (CBOMARCA.getSelectedItem()==objFrmsistema.marca0)
        {
            objFrmsistema.precio0=Double.parseDouble(TXTPRECIO.getText());
            objFrmsistema.contenido0=Integer.parseInt(TXTCONTENIDO.getText());
            objFrmsistema.peso0=Double.parseDouble(TXTPESO.getText());
            objFrmsistema.sabor0=TXTSABOR.getText();
        }
        else
            if (CBOMARCA.getSelectedItem()==objFrmsistema.marca1)
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
    private javax.swing.JComboBox<String> CBOMARCA;
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
