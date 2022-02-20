package views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import models.vo.Permissions;
import utils.Constants;
import utils.MySerializable;

public class Home extends javax.swing.JFrame {

    private JScrollPane spContainer;
    private PnlHome pnlHome;
    private PnlUsuarios pnlUsuarios;
    private PnlEmpleados pnlEmpleados;
    private static PnlEntradasSalidas pnlEntradasSalidas;
    private static PnlProductos pnlProductos;
    private PnlProveedores pnlProveedores;
    private PnlConfiguracion pnlConfiguracion;
    
    private Permissions permissions;
    
    public Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.init_container();
        this.getContentPane().add(spContainer);        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        pnlHome = new PnlHome();
        this.loadPanel(pnlHome);
    }
    
    private void loadPanel(JPanel panel) {
        spContainer.setViewportView(panel);
        spContainer.validate();
    }
    
    private void init_container() {
        spContainer = new JScrollPane();
        spContainer.setBounds(300, 50, 1300, 750);
        spContainer.setBackground(new Color(204, 204,204));
        spContainer.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        spContainer.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }
    
    private void closeApp() {
        int dialogResult = JOptionPane.showConfirmDialog (
                null, 
                "¿Está a punto de cerrar esta sesión, desea continuar?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE
        );
        
        if(dialogResult == JOptionPane.YES_OPTION){
            this.dispose();
            Login login = new Login();
            login.setVisible(true);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnHome = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnUsuarios = new javax.swing.JButton();
        btnEntradas = new javax.swing.JButton();
        btnProveedores = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnConfiguracion = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label4 = new java.awt.Label();
        lblRol = new java.awt.Label();
        lblUsuario = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(19, 15, 64));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 750));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 750));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 750));

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHome.setForeground(new java.awt.Color(204, 204, 204));
        btnHome.setText("Home");
        btnHome.setContentAreaFilled(false);
        btnHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnUsuarios.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(204, 204, 204));
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setContentAreaFilled(false);
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuariosActionPerformed(evt);
            }
        });

        btnEntradas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEntradas.setForeground(new java.awt.Color(204, 204, 204));
        btnEntradas.setText("Entradas / Salidas");
        btnEntradas.setContentAreaFilled(false);
        btnEntradas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEntradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntradasActionPerformed(evt);
            }
        });

        btnProveedores.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProveedores.setForeground(new java.awt.Color(204, 204, 204));
        btnProveedores.setText("Proveedores");
        btnProveedores.setContentAreaFilled(false);
        btnProveedores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProveedoresActionPerformed(evt);
            }
        });

        btnProductos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(204, 204, 204));
        btnProductos.setText("Productos");
        btnProductos.setContentAreaFilled(false);
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(204, 204, 204));
        btnSalir.setText("Cerrar sesión");
        btnSalir.setContentAreaFilled(false);
        btnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnConfiguracion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConfiguracion.setForeground(new java.awt.Color(204, 204, 204));
        btnConfiguracion.setText("Configuración");
        btnConfiguracion.setContentAreaFilled(false);
        btnConfiguracion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracionActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(204, 204, 204));
        btnEmpleados.setText("Empleados");
        btnEmpleados.setContentAreaFilled(false);
        btnEmpleados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEntradas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, 750));

        jPanel2.setBackground(new java.awt.Color(19, 15, 64));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 204, 204));
        label1.setText("X");
        label1.setVisible(false);
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        label1.getAccessibleContext().setAccessibleDescription("");

        label4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label4.setForeground(new java.awt.Color(204, 204, 204));
        label4.setText("Sistema de Inventario - Compensar SENA 2022");
        jPanel2.add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        lblRol.setAlignment(java.awt.Label.CENTER);
        lblRol.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblRol.setForeground(new java.awt.Color(204, 204, 204));
        lblRol.setText("Rol: Administrador");
        jPanel2.add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 30, 420, -1));

        lblUsuario.setAlignment(java.awt.Label.CENTER);
        lblUsuario.setForeground(new java.awt.Color(204, 204, 204));
        lblUsuario.setText("Usuario activo: Jonathan Guillermo Jaimes Moreno");
        jPanel2.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, 420, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuariosActionPerformed
        pnlUsuarios = new PnlUsuarios();
        this.loadPanel(pnlUsuarios);
    }//GEN-LAST:event_btnUsuariosActionPerformed

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        pnlEmpleados = new PnlEmpleados();
        this.loadPanel(pnlEmpleados);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        pnlHome = new PnlHome();
        this.loadPanel(pnlHome);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProveedoresActionPerformed
        pnlProveedores = new PnlProveedores();
        this.loadPanel(pnlProveedores);
    }//GEN-LAST:event_btnProveedoresActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        pnlProductos = PnlProductos.getInstance();
        this.loadPanel(pnlProductos);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnEntradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntradasActionPerformed
        pnlEntradasSalidas = PnlEntradasSalidas.getInstance();
        this.loadPanel(pnlEntradasSalidas);
    }//GEN-LAST:event_btnEntradasActionPerformed

    private void btnConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracionActionPerformed
        pnlConfiguracion = new PnlConfiguracion();
        this.loadPanel(pnlConfiguracion);
    }//GEN-LAST:event_btnConfiguracionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.closeApp();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        readObjSerializable();
    }//GEN-LAST:event_formWindowOpened

    public void readObjSerializable() {
        MySerializable<Permissions> serial = new MySerializable<>();
        permissions = serial.readObj(Constants.PATH_CREDENTIALS);
        if(permissions != null) {
            lblUsuario.setText("Usuario activo: " + permissions.getUsername());
            lblRol.setText((permissions.getRol() == Constants.ROL_ADMIN) ? "Rol: Adminsitrador" : "Rol: Auxiliar");             
            disableUIforAuxiliarRol();
        }
    }
    
    private void disableUIforAuxiliarRol() {
        if(permissions.getRol() == Constants.ROL_AUXILIAR) {
            btnEmpleados.setVisible(false);
            btnUsuarios.setVisible(false);
            btnConfiguracion.setVisible(false);
        }
    }
        
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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Home().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConfiguracion;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnEntradas;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnProveedores;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnUsuarios;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private java.awt.Label label1;
    private java.awt.Label label4;
    private java.awt.Label lblRol;
    private java.awt.Label lblUsuario;
    // End of variables declaration//GEN-END:variables
}