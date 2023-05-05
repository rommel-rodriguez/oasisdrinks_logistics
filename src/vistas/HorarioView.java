
package vistas;

import conexiones.Conexion;
import dao.DaoHorarioImpl;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import registro.Horarios;

public class HorarioView extends javax.swing.JFrame {

    int xMouse, yMouse;
    Connection conn;
    Conexion con = new Conexion();

    public HorarioView() {
        
        initComponents();
        this.setLocationRelativeTo(null);
        con.conectar();
        
        
        
        tf4.setText("Ingieneria de Software");
        
        //tabla
       
       
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM CursosMatriculados";
        try {

            Statement stmt = con.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            //int a= Integer.parseInt(miResultSet.getString(1));
            modelo.setColumnIdentifiers(new Object[]{"item", "curso",
                "lunes","martes", "miercoles", "jueves", "viernes", "sabado"});
            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("seccion"), rs.getString("curso"),
                    rs.getString("lunes"), rs.getString("martes"),
                    rs.getString("miercoles"), rs.getString("jueves"), rs.getString("viernes"), rs.getString("sabado")
                });

                tabla1.setModel(modelo);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se conecto");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanTitulo2 = new javax.swing.JPanel();
        txtTitulo2 = new javax.swing.JLabel();
        PanTitulo1 = new javax.swing.JPanel();
        txtTitulo1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        txt1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        txt3 = new javax.swing.JLabel();
        txt4 = new javax.swing.JLabel();
        txt5 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        txt6 = new javax.swing.JLabel();
        tabla = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        tf3 = new javax.swing.JTextField();
        tf4 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        deltex = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(945, 500));

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

        txtTitulo1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
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
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(txtTitulo1)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(85, 110, 230));
        jPanel1.setPreferredSize(new java.awt.Dimension(200, 428));

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
        b3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setText("Pagos");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(85, 110, 230));
        b4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setText("Crear solicitud");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(284, Short.MAX_VALUE))
        );

        txt1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txt1.setForeground(new java.awt.Color(85, 110, 230));
        txt1.setText("Horario");

        txt2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt2.setText("Resumen:");

        txt3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt3.setText("Facultad:");

        txt4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt4.setText("Cantidad de Creditos:");

        txt5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt5.setText("Credito total:");

        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });

        txt6.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        txt6.setText("Cantidad de horas: ");

        tabla1 = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tabla1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tabla1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"
            }
        ));
        tabla1.setGridColor(new java.awt.Color(255, 255, 255));
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        tabla.setViewportView(tabla1);

        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(85, 110, 230));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Quitar Curso");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt6)
                        .addGap(18, 18, 18)
                        .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt2)
                            .addComponent(txt3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txt5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PanTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(deltex, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt2)
                            .addComponent(tf3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt3)
                            .addComponent(tf4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt4)
                            .addComponent(txt5)
                            .addComponent(tf1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt6)
                            .addComponent(tf5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(deltex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        SolicitudView paSolicitud = new SolicitudView();
        paSolicitud.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b4ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed

    }//GEN-LAST:event_b2ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        PagosView paPagos = new PagosView();
        paPagos.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_b3ActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int boton = Integer.parseInt(deltex.getText());

        try {
            //Statement stmt = con.conn.prepareCall(Var2);
            CallableStatement cst = con.conn.prepareCall("{call dbo_DeletHorario (" + boton + ")}");

            cst.execute();
            //texArea.setText("Fila eliminada");
            //System.out.println("Fila eliminada");
        } catch (Exception e) {
            //texArea.setText("Procedimiento Errado");
            System.out.println("Procedimiento Errado");
            System.out.println(e);
        }
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM CursosMatriculados";
        try {

            Statement stmt = con.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            //int a= Integer.parseInt(miResultSet.getString(1));
            modelo.setColumnIdentifiers(new Object[]{"item", "curso",
                "lunes","martes", "miercoles", "jueves", "viernes", "sabado"});
            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("seccion"), rs.getString("curso"),
                    rs.getString("lunes"), rs.getString("martes"),
                    rs.getString("miercoles"), rs.getString("jueves"), rs.getString("viernes"), rs.getString("sabado")
                });

                tabla1.setModel(modelo);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se conecto");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
        int select = tabla1.rowAtPoint(evt.getPoint());
        deltex.setText(String.valueOf(tabla1.getValueAt(select, 0)));
    }//GEN-LAST:event_tabla1MouseClicked

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
            java.util.logging.Logger.getLogger(HorarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HorarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HorarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HorarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HorarioView().setVisible(true);
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
    private javax.swing.JTextField deltex;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane tabla;
    private javax.swing.JTable tabla1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txt3;
    private javax.swing.JLabel txt4;
    private javax.swing.JLabel txt5;
    private javax.swing.JLabel txt6;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    // End of variables declaration//GEN-END:variables
}
