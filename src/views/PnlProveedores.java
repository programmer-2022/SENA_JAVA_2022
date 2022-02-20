package views;

import controllers.ProveedorController;
import java.awt.event.KeyEvent;
import models.vo.ProveedorVO;
import utils.Constants;
import utils.Messages;

public class PnlProveedores extends javax.swing.JPanel {

    private final ProveedorController proveedorController;
        
    private int id;
    private String nit;
    private String nombre;
    private String telefono;
    private String direccion;
    private String email;
    
    public PnlProveedores() {
        initComponents();
        proveedorController = new ProveedorController();
    }
    
    private void create() {
        if(isEmpty()) {
            Messages.msgError(Constants.REQUIRED);
            txtNIT.requestFocus();
            return;
        }
        
        //Comprobar si existe el proveedor
        ProveedorVO existeProveedor = proveedorController.buscarProveedor(getNit());
        ProveedorVO newProveedor = getProveedorObj();
        
        if(existeProveedor != null) {
            if(existeProveedor.getNit() == null ? newProveedor.getNit() == null : existeProveedor.getNit().equals(newProveedor.getNit())) {
                Messages.msgError(Constants.PROVEEDOR_EXIST);
                return;
            }
        }
        
        if(proveedorController.create(newProveedor)) {
            Messages.msgSuccess(Constants.OK_INSERT);
        } else {
            Messages.msgError(Constants.ERROR_INSERT);
        }                
        clearFields();
        resetVariables();
        txtNIT.requestFocus();
    }
    
    private void readFields() {
        setNit(txtNIT.getText().trim());
        setNombre(txtNombre.getText().trim());
        setTelefono(txtTelefono.getText().trim());
        setDireccion(txtDireccion.getText().trim());
        setEmail(txtEmail.getText().trim());
    }
    
    private void clearFields() {
        txtNIT.setText("");
        txtNombre.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
        txtEmail.setText("");
    }
    
    private boolean isEmpty() {
        return (getNit().equals("") || getNombre().equals("") || getTelefono().equals("") 
                || getDireccion().equals("") || getEmail().equals(""));
    }
    
    private void resetVariables() {
        setNit("");
        setNombre("");
        setTelefono("");
        setDireccion("");
        setEmail("");
    }
    
    private ProveedorVO getProveedorObj() {
        ProveedorVO proveedor = new ProveedorVO();
        proveedor.setNit(getNit());
        proveedor.setNombre(getNombre());
        proveedor.setTelefono(getTelefono());
        proveedor.setDireccion(getDireccion());
        proveedor.setEmail(getEmail());
        return proveedor;
    }
    
    private void buscar() {
        setNit(txtNIT.getText().trim());
        
        if(getNit().equals("")) {
            Messages.msgError(Constants.REQUIRED);
            txtNIT.requestFocus();
            return;
        }        
        
        ProveedorVO proveedor = proveedorController.buscarProveedor(nit);
        
        if(proveedor != null) {
            txtNombre.setText(proveedor.getNombre());
            txtTelefono.setText(proveedor.getTelefono());
            txtDireccion.setText(proveedor.getDireccion());
            txtEmail.setText(proveedor.getEmail());
        } else {
            Messages.msgError(Constants.NOT_FOUND);
        }
        resetVariables();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        txtNIT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtNuevo = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1300, 750));
        setMinimumSize(new java.awt.Dimension(1300, 750));
        setPreferredSize(new java.awt.Dimension(1300, 750));

        jPanel2.setBackground(new java.awt.Color(48, 51, 107));
        jPanel2.setPreferredSize(new java.awt.Dimension(300, 30));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label1.setForeground(new java.awt.Color(204, 204, 204));
        label1.setText("X");
        label1.setVisible(false);
        jPanel2.add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        label3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        label3.setForeground(new java.awt.Color(204, 204, 204));
        label3.setText("Proveedores");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Teléfono");

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtNIT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtNIT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNITKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NIT");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEditar.setText("Editar");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección");

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNuevo.setText("Nuevo");
        txtNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 916, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(448, 448, 448)
                        .addComponent(jLabel6))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtDireccion))
                    .addComponent(txtEmail)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNombre)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNIT, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addGap(13, 13, 13)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65))
        );
    }// </editor-fold>//GEN-END:initComponents

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        readFields();
        create();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuevoActionPerformed
        clearFields();
        resetVariables();
        txtNIT.requestFocus();
    }//GEN-LAST:event_txtNuevoActionPerformed

    private void txtNITKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNITKeyPressed
        if(evt.getKeyChar() == KeyEvent.VK_ENTER) {
            buscar();
        }
    }//GEN-LAST:event_txtNITKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JButton txtNuevo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
