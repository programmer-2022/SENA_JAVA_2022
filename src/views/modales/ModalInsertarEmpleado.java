package views.modales;

import controllers.ControllerEmpleado;
import java.util.HashMap;
import javax.swing.JFrame;
import models.vo.CargoVO;
import models.vo.EmpleadoVO;
import models.vo.GeneroVO;
import utils.Constants;
import utils.Messages;
import utils.MySerializable;
import views.PnlEmpleados;

public class ModalInsertarEmpleado extends javax.swing.JFrame {

    private final ControllerEmpleado controllerEmpleado;
    
    public static String operacionDML;
    
    private String identificacion;
    private String nombre;
    private String apellido;
    private String genero;
    private String cargo;
    
    private HashMap<String, Integer> listaCargos = null;
    private HashMap<String, Integer> listaGeneros = null;

    public ModalInsertarEmpleado() {
        initComponents();
        editarEliminar();
        this.setLocationRelativeTo(null);
        this.setLayout(null);
        controllerEmpleado = new ControllerEmpleado();
        llenarComboGeneros();
        llenarComboCargos();
        txtIdentificacion.setFocusable(true);
        txtID.setEnabled(false);
        txtCargoID.setEnabled(false);
        txtGeneroID.setEnabled(false);
        txtID.setVisible(false);
        txtCargoID.setVisible(false);
        txtGeneroID.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        cbxCargo = new javax.swing.JComboBox<>();
        cbxGenero = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        txtGeneroID = new javax.swing.JTextField();
        txtCargoID = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Cargo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Identificación");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Género");

        txtIdentificacion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbxCargo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCargoActionPerformed(evt);
            }
        });

        cbxGenero.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGeneroActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(txtIdentificacion)
                        .addComponent(jLabel4)
                        .addComponent(txtNombre)
                        .addComponent(jLabel5)
                        .addComponent(txtApellido)
                        .addComponent(jLabel6)
                        .addComponent(cbxGenero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(cbxCargo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(txtGeneroID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)
                        .addComponent(txtCargoID, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGeneroID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCargoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(13, 13, 13)
                .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(13, 13, 13)
                .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addGap(33, 33, 33)
                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(23, 23, 23)
                .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void readFields() {
        identificacion = txtIdentificacion.getText().trim();
        nombre = txtNombre.getText().trim().toUpperCase();
        apellido = txtApellido.getText().trim().toUpperCase();
        genero = txtGeneroID.getText().trim();
        cargo = txtCargoID.getText().trim();
    }
    
    private EmpleadoVO getObjEmpleado() {
        EmpleadoVO empleado = new EmpleadoVO();
        CargoVO cargoVO = new CargoVO();
        GeneroVO generoVO = new GeneroVO();                       
        empleado.setIdentificacion(Integer.parseInt(identificacion));
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        generoVO.setId(Integer.parseInt(genero));
        cargoVO.setId(Integer.parseInt(cargo));
        empleado.setGenero(generoVO);
        empleado.setCargo(cargoVO);        
        return empleado;       
    }
    
    private void create() {
                
        if(identificacion.equals("") || nombre.equals("") 
                || apellido.equals("") || cargo.equals("") || genero.equals("")) {
            Messages.msgError(Constants.REQUIRED);
            return;
        }
  
        EmpleadoVO empleadoID = controllerEmpleado.buscarID(Integer.parseInt(identificacion));
        EmpleadoVO nuevoEmpleado = getObjEmpleado();
        
        //Consultar si ya esta registrado
        if(empleadoID.getIdentificacion() == nuevoEmpleado.getIdentificacion()) {
            Messages.msgError(Constants.DATOS_DUPLICADOS);
            clearFields();
            resetVariables();
            txtIdentificacion.requestFocus();
            return;
        }
        
        if(controllerEmpleado.create(nuevoEmpleado)) {
            Messages.msgSuccess(Constants.OK_INSERT);
        } else {
            Messages.msgSuccess(Constants.ERROR_INSERT);
        }
        updateTable();
        clearFields();
        resetVariables();
        this.dispose();
    }
    
    private void update() {
        if(identificacion.equals("") || nombre.equals("") 
                || apellido.equals("") || cargo.equals("") || genero.equals("")) {
            Messages.msgError(Constants.REQUIRED);
            return;
        }
        
        EmpleadoVO editarEmpleado = getObjEmpleado();       
                
        if(controllerEmpleado.update(editarEmpleado)) {
            Messages.msgSuccess(Constants.OK_UPDATE);
        } else {
            Messages.msgSuccess(Constants.ERROR_UPDATE);
        }
        updateTable();
        clearFields();
        resetVariables();
        this.dispose();
    }
    
    private void updateTable() {
        PnlEmpleados.fillDataTable();
    }    
    
    private void clearFields() {
        txtIdentificacion.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtID.setText("");        
    }
    
    private void resetVariables() {
        identificacion = "";
        nombre = "";
        apellido = "";
        genero = "";
        cargo = "";        
    }
    
    private void llenarComboGeneros() {
        listaGeneros = controllerEmpleado.cargarComboGeneros();
        listaGeneros.keySet().forEach((s) -> {
            cbxGenero.addItem(s);
        });        
    }
    
     private void llenarComboCargos() {
        listaCargos = controllerEmpleado.cargarComboCargos();
        listaCargos.keySet().forEach((s) -> {
            cbxCargo.addItem(s);
        }); 
    }
     
    public void readObjSerializable() {
        MySerializable<EmpleadoVO> serial = new MySerializable<>();
        EmpleadoVO obj = serial.readObj(Constants.PATH_SERIAL_EMPLEADO);

        if(obj != null) {
            txtID.setText(String.valueOf(obj.getId()));
            txtIdentificacion.setText(String.valueOf(obj.getIdentificacion()));
            txtNombre.setText(obj.getNombre());
            txtApellido.setText(obj.getApellido());
            txtGeneroID.setText(String.valueOf(obj.getGenero().getId()));
            cbxGenero.setSelectedItem(obj.getGenero().getName());
            txtCargoID.setText(String.valueOf(obj.getCargo().getId()));          
            cbxCargo.setSelectedItem(obj.getCargo().getName());
        }
    }
    
    private void editarEliminar() {
        if(operacionDML.equals(Constants.UPDATE)) {
            btnGuardar.setText("Actualizar");
            txtIdentificacion.setEnabled(false);
        } else {
            btnGuardar.setText("Guardar");
            txtIdentificacion.setEnabled(true);
        }
    }
    
        
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        readFields();
        if(operacionDML.equals(Constants.INSERT)) {
            create();
        }else {
            update();
        }       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxGeneroActionPerformed
        txtGeneroID.setText(listaGeneros.get(cbxGenero.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbxGeneroActionPerformed

    private void cbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCargoActionPerformed
        txtCargoID.setText(listaCargos.get(cbxCargo.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbxCargoActionPerformed

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
            java.util.logging.Logger.getLogger(ModalInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModalInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModalInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModalInsertarEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ModalInsertarEmpleado().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JComboBox<String> cbxGenero;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCargoID;
    private javax.swing.JTextField txtGeneroID;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
