package views;

import controllers.ProveedorController;
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
        
        ProveedorVO newProveedor = getProveedorObj();
        
        if(proveedorController.create(newProveedor)) {
            Messages.msgSuccess(Constants.OK_INSERT);
        } else {
            Messages.msgError(Constants.ERROR_INSERT);
        }                
        clearFields();
        resetVariables();
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
        jLabel5 = new javax.swing.JLabel();
        txtBuscarNIT = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(1300, 750));
        setMinimumSize(new java.awt.Dimension(1300, 750));
        setPreferredSize(new java.awt.Dimension(1300, 750));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Teléfono");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 408, -1, -1));

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 436, 480, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Email");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 516, -1, -1));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 630, 285, 41));

        txtNIT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 220, 1055, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("NIT");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 192, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 300, -1, -1));

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 328, 1055, 40));

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 544, 1055, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Buscar por NIT");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 91, -1, -1));

        txtBuscarNIT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBuscarNIT, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 119, 285, 40));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 119, 150, 40));

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(416, 630, 285, 40));

        btnEditar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnEditar.setText("Editar");
        add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(801, 630, 285, 41));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Dirección");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 408, -1, -1));

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(529, 436, 557, 40));
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JTextField txtBuscarNIT;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNIT;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
