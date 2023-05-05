package vistas;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.awt.Color;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import conexiones.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.naming.spi.DirStateFactory;
import registro.Alumno;

public class LoginView extends javax.swing.JFrame {

    int xMouse, yMouse;
    Connection conn;
    Conexion con = new Conexion();

    public LoginView() {
        initComponents();
        this.setLocationRelativeTo(null);
        con.conectar();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Titulo = new javax.swing.JLabel();
        txtCont = new javax.swing.JPasswordField();
        txtNombre = new javax.swing.JTextField();
        butIngresar = new javax.swing.JButton();
        lab1 = new javax.swing.JLabel();
        lab2 = new javax.swing.JLabel();
        ButLimpiar = new javax.swing.JButton();
        PanTitulo1 = new javax.swing.JPanel();
        txtTitulo1 = new javax.swing.JLabel();
        PanTitulo2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 0, 153));
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(320, 350));

        Titulo.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        Titulo.setForeground(new java.awt.Color(85, 110, 230));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Ingresa a tu cuenta");
        Titulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Titulo.setPreferredSize(new java.awt.Dimension(320, 32));
        Titulo.setVerifyInputWhenFocusTarget(false);

        txtCont.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtCont.setForeground(new java.awt.Color(153, 153, 153));
        txtCont.setToolTipText("");
        txtCont.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContActionPerformed(evt);
            }
        });

        txtNombre.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(153, 153, 153));
        txtNombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        butIngresar.setBackground(new java.awt.Color(85, 110, 230));
        butIngresar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        butIngresar.setForeground(new java.awt.Color(255, 255, 255));
        butIngresar.setText("Ingresar");
        butIngresar.setBorder(null);
        butIngresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        butIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butIngresarActionPerformed(evt);
            }
        });

        lab1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lab1.setForeground(new java.awt.Color(73, 80, 87));
        lab1.setText("Ingrese su codigo");

        lab2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab2.setForeground(new java.awt.Color(73, 80, 87));
        lab2.setText("Ingrese su contraseña");

        ButLimpiar.setBackground(new java.awt.Color(85, 110, 230));
        ButLimpiar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ButLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        ButLimpiar.setText("Limpiar");
        ButLimpiar.setBorder(null);
        ButLimpiar.setBorderPainted(false);
        ButLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButLimpiarActionPerformed(evt);
            }
        });

        PanTitulo1.setBackground(new java.awt.Color(204, 255, 255));
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
                .addComponent(txtTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanTitulo1Layout.setVerticalGroup(
            PanTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTitulo1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitulo1)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        PanTitulo2.setBackground(new java.awt.Color(204, 255, 255));
        PanTitulo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("x");
        jLabel4.setPreferredSize(new java.awt.Dimension(35, 35));

        javax.swing.GroupLayout PanTitulo2Layout = new javax.swing.GroupLayout(PanTitulo2);
        PanTitulo2.setLayout(PanTitulo2Layout);
        PanTitulo2Layout.setHorizontalGroup(
            PanTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanTitulo2Layout.setVerticalGroup(
            PanTitulo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanTitulo2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lab1)
                    .addComponent(txtNombre)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(butIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(ButLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lab2)
                    .addComponent(txtCont))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(PanTitulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanTitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lab2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCont, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void butIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butIngresarActionPerformed

        String codigo = txtNombre.getText();
        String pass = txtCont.getText();
        /*
        Alumno u20227896 = new Alumno("Ingieneria", 1, "Jose", "Flores", "u12345678", "Ate");
        Alumno u12345678 = new Alumno("Ingieneria", 2, "Fredy", "Lopez", "u12345678", "Sur");
        Alumno u98764321 = new Alumno("Ingieneria", 1, "luis", "Daniel", "u98764321", "Ate");
        Alumno u14728369 = new Alumno("Ingieneria", 2, "Miguel", "Martinez", "u14728369", "Norte");
        Alumno u36925741 = new Alumno("Ingieneria", 3, "Fabian", "Rivera", "u36925741", "sur");

        Map<String, Alumno> lista = new HashMap<String, Alumno>();
        lista.put("123456", u20227896);
        lista.put("987412", u12345678);
        lista.put("123698", u98764321);
        lista.put("789461", u14728369);
        lista.put("963824", u36925741);

        for (Entry<String, Alumno> e : lista.entrySet()) {
            System.out.println(e);
        }
        // Conexion

        try {
            String query = "Select * from Estudiante where codigo = '" + codigo + "' and clave = '" + pass + "'";
            
            Statement st = con.conn.createStatement();
        } catch (Exception e) {

        }
         */

        try {

            Statement st = con.conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Estudiante WHERE codigo = '" + codigo + "' and cont = '" + pass + "'");

            if (codigo.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "Debe de ingresar los datos",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            } else {
                if (rs.next()) {
                    MenuView.main(null);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Usuario o contraseña incorrecta",
                            "Información",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        /*
        if (codigo.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(
                    null,
                    "Debe de ingresar los datos",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (codigo.equals("u20227896") && pass.equals("123456")) {
                MenuView.main(null);
                //MenuView paMenu = new MenuView();
                //paMenu.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "Usuario o contraseña incorrecta",
                        "Información",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        }*/
    }//GEN-LAST:event_butIngresarActionPerformed

    private void PanTitulo1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo1MouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xMouse, y - yMouse);
    }//GEN-LAST:event_PanTitulo1MouseDragged

    private void PanTitulo1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo1MousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_PanTitulo1MousePressed

    private void PanTitulo2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_PanTitulo2MouseClicked

    private void PanTitulo2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseEntered
        PanTitulo2.setBackground(Color.red);
    }//GEN-LAST:event_PanTitulo2MouseEntered

    private void PanTitulo2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanTitulo2MouseExited
        PanTitulo2.setBackground(Color.white);
    }//GEN-LAST:event_PanTitulo2MouseExited

    private void ButLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButLimpiarActionPerformed
        txtNombre.setText("");
        txtCont.setText("");
    }//GEN-LAST:event_ButLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButLimpiar;
    private javax.swing.JPanel PanTitulo1;
    private javax.swing.JPanel PanTitulo2;
    private javax.swing.JLabel Titulo;
    private javax.swing.JButton butIngresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab2;
    private javax.swing.JPasswordField txtCont;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtTitulo1;
    // End of variables declaration//GEN-END:variables
}
