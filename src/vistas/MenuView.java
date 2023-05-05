package vistas;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JTable;

import javax.swing.table.DefaultTableModel;
import conexiones.Conexion;
import conexiones.Render;
import java.sql.CallableStatement;
import registro.TablaMatricula;

public class MenuView extends javax.swing.JFrame {

    int xMouse, yMouse;
    Connection conn;
    Conexion con = new Conexion();

    public MenuView() {

        initComponents();
        this.setLocationRelativeTo(null);
        con.conectar();

        // boton en la tabla menu
        TablaCursos.setDefaultRenderer(Object.class, new Render());
        JButton btn = new JButton("Seleccionar");

        
        // tabla
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT * FROM Cursos";
        try {

            Statement stmt = con.conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);

            //int a= Integer.parseInt(miResultSet.getString(1));
            modelo.setColumnIdentifiers(new Object[]{"item", "curso",
                "creditos", "ciclo", "nInscritos", "tipo", "seccion", "accion", "capacidad"});
            while (rs.next()) {

                modelo.addRow(new Object[]{
                    rs.getString("item"), rs.getString("curso"),
                    rs.getString("creditos"), rs.getString("ciclo"),
                    rs.getString("nInscritos"), rs.getString("tipo"), rs.getString("seccion"), btn, rs.getString("capacidad")

                });

                TablaCursos.setModel(modelo);
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se conecto");
        }
/*
        List<TablaMatricula> tabla = new ArrayList<>();
        tabla.add(new TablaMatricula(1,"Matematica I",4,1,0,"Obligatorio",4566," ",25));
        tabla.add(new TablaMatricula(2,"Algoritmos",3,1,0,"Obligatorio",4968," ",15));
        tabla.add(new TablaMatricula(3,"Quimica",3,1,0,"Obligatorio",1563," ",6));
        tabla.add(new TablaMatricula(4,"Ingles i",2,1,0,"Obligatorio",9264," ",9));
        tabla.add(new TablaMatricula(5,"Texto I",2,1,0,"Obligatorio",1624," ",17));
        tabla.add(new TablaMatricula(6,"calculo I",5,1,0,"Obligatorio",4568," ",5));
        
        tabla.add(new TablaMatricula(7,"programacion I",3,2,0,"Obligatorio",1886," ",25));
        tabla.add(new TablaMatricula(8,"Ingles II",2,2,0,"Obligatorio",4562," ",60));
        tabla.add(new TablaMatricula(9,"Matematica II",4,2,0,"Obligatorio",3334," ",15));
        tabla.add(new TablaMatricula(10,"Calculo II",5,2,0,"Obligatorio",3654," ",5));
        
        tabla.add(new TablaMatricula(1,"Ingles III",2,3,0,"Obligatorio",8950," ",11));
        tabla.add(new TablaMatricula(1,"Estadistica I",4,3,0,"Obligatorio",8216," ",16));
        tabla.add(new TablaMatricula(1,"Programacion II",3,3,0,"Obligatorio",1115," ",35));
        
        DefaultTableModel tableModel = (DefaultTableModel)TablaCursos.getModel();
        for (TablaMatricula tab : tabla){
            Object[] fila = {
                tab.getItem(),
                tab.getCursos(),
                tab.getCreditos(),
                tab.getCiclo(),
                tab.getnIncripcion(),
                tab.getTipo(),
                tab.getSeccion(),
                tab.getAccion(),
                tab.getCapac()
            };
            tableModel.addRow(fila);
        }*/
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanTitulo2 = new javax.swing.JPanel();
        txtTitulo2 = new javax.swing.JLabel();
        PanTitulo1 = new javax.swing.JPanel();
        txtTitulo1 = new javax.swing.JLabel();
        tabla1 = new javax.swing.JScrollPane();
        TablaCursos = new javax.swing.JTable();
        txt1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        b1 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        titulo1 = new javax.swing.JLabel();
        txt2 = new javax.swing.JLabel();
        Salida = new javax.swing.JScrollPane();
        texA1 = new javax.swing.JTextArea();

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        TablaCursos = new javax.swing.JTable(){
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        TablaCursos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TablaCursos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        TablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "Curso", "Créditos", "Ciclo", "Nro. Insc", "Tipo", "Sección", "Accion", "Capac"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        TablaCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TablaCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaCursosMouseClicked(evt);
            }
        });
        tabla1.setViewportView(TablaCursos);

        txt1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt1.setText("Aqui encontraras la lista de cursos aptos para matricularte. Elige primero los cursos de menor nivel para avanzar ");

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
                .addContainerGap(276, Short.MAX_VALUE))
        );

        titulo1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        titulo1.setForeground(new java.awt.Color(85, 110, 230));
        titulo1.setText("Cursos a matricula");

        txt2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txt2.setText("de acuerdo con tu plan de estudios.");

        texA1.setColumns(20);
        texA1.setRows(5);
        texA1.setToolTipText("");
        texA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Salida.setViewportView(texA1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt2)
                            .addComponent(txt1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tabla1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Salida, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)))
                        .addGap(24, 24, 24))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(titulo1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                        .addComponent(titulo1)
                        .addGap(18, 18, 18)
                        .addComponent(txt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt2)
                        .addGap(18, 18, 18)
                        .addComponent(tabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Salida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE))))
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

    }//GEN-LAST:event_b1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        SolicitudView paSolicitud = new SolicitudView();
        paSolicitud.setVisible(true);
        this.setVisible(false);
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

    private void TablaCursosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaCursosMouseClicked
        int column = TablaCursos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TablaCursos.getRowHeight();

        int select = TablaCursos.rowAtPoint(evt.getPoint());

        if (row < TablaCursos.getRowHeight() && row >= 0 && column < TablaCursos.getColumnCount() && column >= 0) {

            Object value = TablaCursos.getValueAt(row, column);
            if (value instanceof JButton) {
                ((JButton) value).doClick();
                JButton boton = (JButton) value;
                System.out.println("clic");
                //String.valueOf(TablaCursos.getValueAt(select, 0));
                System.out.println(String.valueOf(TablaCursos.getValueAt(select, 0)));

                try {
                    //Statement stmt = con.conn.prepareCall(Var2);
                    CallableStatement cst = con.conn.prepareCall("{call dbo_Horario (" + String.valueOf(TablaCursos.getValueAt(select, 0)) + ")}");

                    cst.execute();
                    texA1.setText("Curso agregado con exito");
                    //System.out.println("Fila agregado con exito");
                } catch (Exception e) {
                    texA1.setText("Procedimiento Errado");
                    //System.out.println("Procedimiento Errado");
                    System.out.println(e);
                }
            }
        }

    }//GEN-LAST:event_TablaCursosMouseClicked

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
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanTitulo1;
    private javax.swing.JPanel PanTitulo2;
    private javax.swing.JScrollPane Salida;
    private javax.swing.JTable TablaCursos;
    private javax.swing.JButton b1;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane tabla1;
    private javax.swing.JTextArea texA1;
    private javax.swing.JLabel titulo1;
    private javax.swing.JLabel txt1;
    private javax.swing.JLabel txt2;
    private javax.swing.JLabel txtTitulo1;
    private javax.swing.JLabel txtTitulo2;
    // End of variables declaration//GEN-END:variables
}
