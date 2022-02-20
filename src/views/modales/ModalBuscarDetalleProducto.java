package views.modales;

import controllers.DetalleProductoController;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import models.vo.DetalleProductoVO;
import utils.Constants;
import utils.Messages;
import utils.MyDate;
import utils.MySerializable;
import views.PnlProductos;

public class ModalBuscarDetalleProducto extends javax.swing.JFrame {

    private final DetalleProductoController controller;    
    private static PnlProductos pnlProductos;
    
    private String nit;
    private String codigo;
    private String fecha;
    
    private String filtro = "Un registro";
    
    public ModalBuscarDetalleProducto() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        this.setTitle("Buscar producto");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        controller = new DetalleProductoController();
        rbtUno.addActionListener(action);
        rbtTodos.addActionListener(action);
    }
    
    //Eventos para los radiobutton
    ActionListener action = e -> {
        JRadioButton button = (JRadioButton) e.getSource();
        filtro = button.getText();
        txtNIT.requestFocus();
        txtCodigo.setEnabled(filtro.equals("Un registro"));
    };

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNIT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtCodigo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rbtUno = new javax.swing.JRadioButton();
        rbtTodos = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NIT:");

        txtNIT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Código de producto");

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

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Seleccione el filtro para la búsqueda:");

        buttonGroup1.add(rbtUno);
        rbtUno.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtUno.setSelected(true);
        rbtUno.setText("Un registro");

        buttonGroup1.add(rbtTodos);
        rbtTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtTodos.setText("Todos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                        .addComponent(txtCodigo)
                        .addComponent(txtNIT)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtUno)
                        .addGap(18, 18, 18)
                        .addComponent(rbtTodos)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtUno)
                    .addComponent(rbtTodos))
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readFields() {
        setCodigo(txtCodigo.getText().trim());
        setNit(txtNIT.getText().trim());
        setFecha(MyDate.getDate(txtFecha) == null ? "" : MyDate.getDate(txtFecha));
    }
      
    private boolean isEmpty() {
        return getNit().equals("") || getCodigo().equals("") || getFecha().equals("");
    }    
    
    private void buscar() {
        if(filtro.equals("Un registro")) {
            readFields();
            if(isEmpty()) {
                Messages.msgError(Constants.REQUIRED);
                return;
            }
            DetalleProductoVO detalle = controller.buscarProducto(nit, codigo, fecha);
        
            if(detalle.getProveedor() != null && detalle.getProducto() != null) {
                MySerializable serial = new MySerializable();
                serial.writeObj(detalle, Constants.PATH_DETALLE_PRODUCTO);
                pnlProductos = PnlProductos.getInstance();
                pnlProductos.readObjSerializable();
                this.dispose();
            } else {
                Messages.msgError(Constants.NOT_FOUND);
                clearFields();
                resetVariables();
                txtNIT.requestFocus();
            }
        } else {
            setNit(txtNIT.getText().trim());
            setFecha(MyDate.getDate(txtFecha) == null ? "" : MyDate.getDate(txtFecha));
            
            if(getNit().equals("") || getFecha().equals("")) {
                Messages.msgError(Constants.REQUIRED);
                return;
            }
            ArrayList<DetalleProductoVO> listaDetalle = controller.buscarTodos(nit, fecha);
            
            if(listaDetalle != null) {
                MySerializable serial = new MySerializable();
                serial.writeObj(listaDetalle, Constants.PATH_DETALLE_TODOS_PRODUCTOS);
                pnlProductos = PnlProductos.getInstance();
                pnlProductos.readObjSerializableAll();
                this.dispose();
            } else {
                Messages.msgError(Constants.NOT_FOUND);
                clearFields();
                resetVariables();
                txtNIT.requestFocus();
            }              
            
        }       
        
    }
    
    private void resetVariables() {
        setNit("");
        setCodigo("");
        setFecha("");
    }
    
    private void clearFields() {
        txtNIT.setText("");
        txtCodigo.setText("");
        ((JTextField)txtFecha.getDateEditor().getUiComponent()).setText("");
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) buscar();
    }//GEN-LAST:event_btnBuscarKeyPressed

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
            java.util.logging.Logger.getLogger(ModalBuscarDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalBuscarDetalleProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ModalBuscarDetalleProducto().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JRadioButton rbtTodos;
    private javax.swing.JRadioButton rbtUno;
    private static javax.swing.JTextField txtCodigo;
    private static com.toedter.calendar.JDateChooser txtFecha;
    private static javax.swing.JTextField txtNIT;
    // End of variables declaration//GEN-END:variables
}
