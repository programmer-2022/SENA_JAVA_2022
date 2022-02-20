package views.modales;

import controllers.DetalleProductoController;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextField;
import models.vo.DetalleProductoVO;
import utils.Constants;
import utils.Messages;
import utils.MyDate;
import utils.MySerializable;
import views.PnlEntradasSalidas;
import views.PnlProductos;

public class ModalBuscarProveedorDetalle extends javax.swing.JFrame {

    private final DetalleProductoController controller;
        private static PnlEntradasSalidas pnlEntradasSalidas;
    
    private String nit;
    private String fecha;
    
    public ModalBuscarProveedorDetalle() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Buscar proveedor");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        controller = new DetalleProductoController();
    }

    private void readFields() {
        setNit(txtNIT.getText().trim());
        setFecha(MyDate.getDate(txtFecha) == null ? "" : MyDate.getDate(txtFecha));
    }   
    
    private boolean isEmpty() {
        return getNit().equals("") || getFecha().equals("");
    }
    
    private void buscar() {
        if(isEmpty()) {
            Messages.msgError(Constants.REQUIRED);
            txtNIT.requestFocus();
            return;
        }
        
        ArrayList<DetalleProductoVO> listaDetalle = controller.buscarTodos(nit, fecha);
            
            if(listaDetalle != null) {
                MySerializable serial = new MySerializable();
                serial.writeObj(listaDetalle, Constants.PATH_DETALLE_ACTA);
                pnlEntradasSalidas = PnlEntradasSalidas.getInstance();
                pnlEntradasSalidas.readObjSerializableAll();
                this.dispose();
            } else {
                Messages.msgError(Constants.NOT_FOUND);
                clearFields();
                resetVariables();
                txtNIT.requestFocus();
            }              
    }
    
    private void clearFields() {
        txtNIT.setText("");
        ((JTextField)txtFecha.getDateEditor().getUiComponent()).setText("");
    }
    
    private void resetVariables() {
        setNit("");
        setFecha("");
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NIT:");

        txtNIT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Fecha de registro");

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        btnBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarKeyPressed(evt);
            }
        });

        txtFecha.setDateFormatString("yyyy/MM/d");
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNIT)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        readFields();
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) buscar();
    }//GEN-LAST:event_btnBuscarKeyPressed

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
            java.util.logging.Logger.getLogger(ModalBuscarProveedorDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarProveedorDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarProveedorDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarProveedorDetalle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ModalBuscarProveedorDetalle().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private static com.toedter.calendar.JDateChooser txtFecha;
    private static javax.swing.JTextField txtNIT;
    // End of variables declaration//GEN-END:variables
}
