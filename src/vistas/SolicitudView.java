
package vistas;

import java.awt.Color;

public class SolicitudView extends javax.swing.JFrame {

    int xMouse, yMouse;
    public SolicitudView() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanTitulo2 = new javax.swing.JPanel();
        txtTitulo2 = new javax.swing.JLabel();
        PanTitulo1 = new javax.swing.JPanel();
        txtTitulo1 = new javax.swing.JLabel();
        panel3 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txt3 = new javax.swing.JLabel();
        rad1 = new javax.swing.JRadioButton();
        rad2 = new javax.swing.JRadioButton();
        txt4 = new javax.swing.JLabel();
        rad3 = new javax.swing.JRadioButton();
        rad4 = new javax.swing.JRadioButton();
        rad5 = new javax.swing.JRadioButton();
        rad6 = new javax.swing.JRadioButton();
        txt5 = new javax.swing.JLabel();
        tfTelefono = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        PanTitulo2.setBackground(new java.awt.Color(204, 255, 255));
        PanTitulo2.setForeground(new java.awt.Color(255, 255, 255));
        PanTitulo2.setPreferredSize(new java.awt.Dimension(35, 35));
        PanTitulo2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanTitulo2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PanTitulo2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PanTitulo2MouseExited(evt);
            }
        });

        txtTitulo2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtTitulo2.setText("x");
        txtTitulo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txtTitulo2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        txtTitulo2.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout PanTitulo2Layout = new javax.swing.GroupLayout(PanTitulo2);
        PanTitulo2.setLayout(PanTitulo2Layout);
        PanTitulo2Layout.setHorizontalGroup(
            PanTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanTitulo2Layout.setVerticalGroup(
            PanTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTitulo2Layout.createSequentialGroup()
                .addComponent(txtTitulo2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        PanTitulo1.setBackground(new java.awt.Color(204, 255, 255));
        PanTitulo1.setPreferredSize(new java.awt.Dimension(865, 35));
        PanTitulo1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PanTitulo1MouseDragged(evt);
            }
        });
        PanTitulo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                PanTitulo1MousePressed(evt);
            }
        });

        txtTitulo1.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        txtTitulo1.setForeground(new java.awt.Color(85, 110, 230));
        txtTitulo1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txtTitulo1.setText("Matricula en linea");

        javax.swing.GroupLayout PanTitulo1Layout = new javax.swing.GroupLayout(PanTitulo1);
        PanTitulo1.setLayout(PanTitulo1Layout);
        PanTitulo1Layout.setHorizontalGroup(
            PanTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanTitulo1Layout.createSequentialGroup()
                .addContainerGap(437, Short.MAX_VALUE)
                .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanTitulo1Layout.setVerticalGroup(
            PanTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanTitulo1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(txtTitulo1)
                .addContainerGap())
        );

        panel3.setBackground(new java.awt.Color(85, 110, 230));
        panel3.setPreferredSize(new java.awt.Dimension(200, 428));

        b1.setBackground(new java.awt.Color(85, 110, 230));
        b1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b1.setForeground(new java.awt.Color(255, 255, 255));
        b1.setText("Cursos a matricula");
        b1.setToolTipText("");
        b1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b2.setBackground(new java.awt.Color(85, 110, 230));
        b2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setText("Horario");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b3.setBackground(new java.awt.Color(85, 110, 230));
        b3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Pagos");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(85, 110, 230));
        b4.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("Crear solicitud");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(276, Short.MAX_VALUE))
        );

        txt1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txt1.setForeground(new java.awt.Color(85, 110, 230));
        txt1.setText("Crear Nueva Solicitud");

        txt2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt2.setText("Curso a solicitar:");

        jComboBox1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        txt3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt3.setText("Turno de preferencia:");

        rad1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad1.setText("Diurno");
        rad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad1ActionPerformed(evt);
            }
        });

        rad2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad2.setText("Nocturno");
        rad2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad2ActionPerformed(evt);
            }
        });

        txt4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt4.setText("Modalidad:");

        rad3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad3.setText("Presencial");
        rad3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rad3ActionPerformed(evt);
            }
        });

        rad4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad4.setText("Virtual");

        rad5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad5.setText("Semipresencial");

        rad6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        rad6.setText("Remoto");

        txt5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt5.setText("Telefono:");

        tfTelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt1)
                    .addComponent(txt2)
                    .addComponent(jComboBox1, 0, 311, Short.MAX_VALUE)
                    .addComponent(txt3)
                    .addComponent(rad1)
                    .addComponent(rad2)
                    .addComponent(txt4)
                    .addComponent(rad3)
                    .addComponent(rad4)
                    .addComponent(rad5)
                    .addComponent(rad6)
                    .addComponent(txt5)
                    .addComponent(tfTelefono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(txt1)
                        .addGap(18, 18, 18)
                        .addComponent(txt2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rad2)
                        .addGap(18, 18, 18)
                        .addComponent(txt4)
                        .addGap(18, 18, 18)
                        .addComponent(rad3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rad6)
                        .addGap(18, 18, 18)
                        .addComponent(txt5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PanTitulo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_PanTitulo1MousePressed

    private void PanTitulo1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_PanTitulo1MouseDragged

    private void PanTitulo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_PanTitulo2MouseClicked

    private void PanTitulo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseEntered
        PanTitulo2.setBackground(Color.red);
    }//GEN-LAST:event_PanTitulo2MouseEntered

    private void PanTitulo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseExited
        PanTitulo2.setBackground(Color.white);
    }//GEN-LAST:event_PanTitulo2MouseExited

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        MenuView paMenu = new MenuView();
        paMenu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        
    }//GEN-LAST:event_b4ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        HorarioView paHorario = new HorarioView();
        paHorario.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        PagosView paPagos = new PagosView();
        paPagos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void rad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad1ActionPerformed

    private void rad2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad2ActionPerformed

    private void rad3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rad3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rad3ActionPerformed

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
            java.util.logging.Logger.getLogger(SolicitudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SolicitudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SolicitudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SolicitudView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SolicitudView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanTitulo1;
    private javax.swing.JPanel PanTitulo2;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel panel3;
    private javax.swing.JRadioButton rad1;
    private javax.swing.JRadioButton rad2;
    private javax.swing.JRadioButton rad3;
    private javax.swing.JRadioButton rad4;
    private javax.swing.JRadioButton rad5;
    private javax.swing.JRadioButton rad6;
    private javax.swing.JTextField tfTelefono;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    // End of variables declaration//GEN-END:variables
}
