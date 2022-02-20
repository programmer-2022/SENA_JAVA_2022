package views;

import controllers.ActaController;
import controllers.ControllerEmpleado;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.vo.ActaVO;
import models.vo.DetalleProductoVO;
import models.vo.EmpleadoVO;
import models.vo.ProveedorVO;
import utils.Constants;
import utils.Messages;
import utils.MyDate;
import utils.MySerializable;
import views.modales.ModalBuscarProveedorDetalle;

public class PnlEntradasSalidas extends javax.swing.JPanel {

    private String codigo;
    private String acronimo;
    private String fecha;
    private String observaciones;
    private String nombreProveedor;
    private String proveedorID;
    private String empleadoResponsable;
    private String responsableProveedor;
    
    private final ActaController actaController;
    private final ControllerEmpleado controllerEmpleado;
    private HashMap<String, Integer> listaEmpleados = null;
    public static PnlEntradasSalidas instance;
    private ArrayList<DetalleProductoVO> listaProductos;
    
    private PnlEntradasSalidas() {
        initComponents();
        controllerEmpleado = new ControllerEmpleado();
        actaController = new ActaController();
        cargarComboEmpleados();        
        cbxTipoActa.setSelectedIndex(0);
    }
    
    public synchronized static PnlEntradasSalidas getInstance() {
        if(instance == null) {
            instance = new PnlEntradasSalidas();
        }
        return instance;
    }

    private void cargarCodigoProducto() {
        String str = "015";
        int numero = Integer.parseInt(str) + 1;
        String formatted = String.format("%03d", numero);
        System.out.println(formatted);
    }
    
    public void readObjSerializableAll() {
        MySerializable<ArrayList<DetalleProductoVO>> _serial = new MySerializable<>();
        listaProductos = _serial.readObj(Constants.PATH_DETALLE_ACTA);        
        if(listaProductos != null) fillDataTable();
    }
    
     public void fillDataTable() {

        if(listaProductos.size() > 0) {
            String datos[][] = new String[listaProductos.size()][12];
            String[] columns = {
                "DetalleID", "Fecha", "ProveedorID", "Nombre Proveedor", "ProductoID",
                "Codigo Producto", "Nombre Producto", "Cantidad", "Serial", "Estado", "CategoriaID", "Nombre Categoria"       						
            };

            for (int i = 0; i < listaProductos.size(); i++) {
                datos[i][0] = Integer.toString(listaProductos.get(i).getId());
                datos[i][1] = MyDate.Date2Str(listaProductos.get(i).getFecha());
                datos[i][2] = Integer.toString(listaProductos.get(i).getProveedor().getId());
                datos[i][3] = listaProductos.get(i).getProveedor().getNombre();
                datos[i][4] = Integer.toString(listaProductos.get(i).getProducto().getId());
                datos[i][5] = listaProductos.get(i).getProducto().getCode();
                datos[i][6] = listaProductos.get(i).getProducto().getName();
                datos[i][7] = Integer.toString(listaProductos.get(i).getCantidad());
                datos[i][8] = listaProductos.get(i).getProducto().getSerial();
                datos[i][9] = listaProductos.get(i).getProducto().getStatus();
                datos[i][10] = Integer.toString(listaProductos.get(i).getProducto().getCategoria().getId());
                datos[i][11] = listaProductos.get(i).getProducto().getCategoria().getName();
            }
            
            DefaultTableModel model = new DefaultTableModel(datos, columns);
            int[] columnSize = {10, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50, 50};
            for(int x=0; x<columnSize.length;x++) {
                tblProductos.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
            }
            tblProductos.setRowHeight(30);
            tblProductos.setModel(model);
            
            txtFecha.setDate(listaProductos.get(0).getFecha());
            txtProveedorID.setText(Integer.toString(listaProductos.get(0).getProveedor().getId()));
            txtNombreProveedor.setText(listaProductos.get(0).getProveedor().getNombre());
        }            
    }
   
    private void cargarComboEmpleados() {
        listaEmpleados = controllerEmpleado.cargarComboEmpleados();
        if(listaEmpleados != null) {
            listaEmpleados.keySet().forEach((s) -> {
                cbxEmpleados.addItem(s);
            });        
        }        
    }
     
    private void readFields() {
        setAcronimo(txtCodigoAcronimo.getText().trim());
        setCodigo(txtCodigo.getText().trim());
        setProveedorID(txtProveedorID.getText().trim());
        setFecha(MyDate.getDate(txtFecha) == null ? "" : MyDate.getDate(txtFecha));
        setNombreProveedor(txtNombreProveedor.getText().trim());
        setObservaciones(txtObservaciones.getText().trim());
        setEmpleadoResponsable(txtEmpleadoID.getText().trim());
        setResponsableProveedor(txtProveedorCargo.getText().trim().toUpperCase());
    } 
    
    private boolean isEmpty() {
        return getAcronimo().equals("") || getCodigo().equals("") || getFecha().equals("")
            || getProveedorID().equals("") || getObservaciones().equals("") || getNombreProveedor().equals("")
            || getEmpleadoResponsable().equals("") || getResponsableProveedor().equals("");
    }
    
    private void clearFields() {
        txtCodigo.setText("");
        txtNombreProveedor.setText("");
        txtObservaciones.setText("");
        txtProveedorCargo.setText("");
        ((JTextField)txtFecha.getDateEditor().getUiComponent()).setText("");
        txtCodigo.requestFocus();
    }
    
    private void resetVariables() {
        setAcronimo("");
        setCodigo("");
        setFecha("");
        setProveedorID("");
        setObservaciones("");
        setEmpleadoResponsable("");
        setResponsableProveedor("");
    }
    
    private ActaVO getActaObj() {
        ActaVO acta = new ActaVO();
        ProveedorVO proveedor = new ProveedorVO();
        EmpleadoVO empleado = new EmpleadoVO();
        
        acta.setCodigo(getAcronimo() + "-" + getCodigo());
        acta.setFecha(Date.valueOf(getFecha()));
        acta.setObservaciones(getObservaciones());
        acta.setResponsableProveedor(getResponsableProveedor());
        
        proveedor.setId(Integer.parseInt(getProveedorID()));
        empleado.setId(Integer.parseInt(getEmpleadoResponsable()));
        
        acta.setProveedor(proveedor);
        acta.setEmpleado(empleado);
        return acta;
    }
    
    private void create() {
        if(isEmpty()) {
            Messages.msgError(Constants.REQUIRED);
            return;
        }
        
        //ProductoVO newProduct = getProductObj();
        //ProveedorVO newProveedor = getProveedorObj();
        
        ActaVO acta = getActaObj();
        
        if(actaController.create(acta)) {
            Messages.msgSuccess(Constants.OK_INSERT);
        } else {
            Messages.msgError(Constants.ERROR_INSERT);
        }
        clearFields();
        resetVariables();        
    } 

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEmpleadoResponsable() {
        return empleadoResponsable;
    }

    public void setEmpleadoResponsable(String empleadoResponsable) {
        this.empleadoResponsable = empleadoResponsable;
    }

    public String getResponsableProveedor() {
        return responsableProveedor;
    }

    public void setResponsableProveedor(String responsableProveedor) {
        this.responsableProveedor = responsableProveedor;
    }

    public String getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(String proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }
    
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFecha = new com.toedter.calendar.JDateChooser();
        txtCodigo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        lblResponsableProveedor = new javax.swing.JLabel();
        txtEmpleadoID = new javax.swing.JTextField();
        txtProveedorCargo = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        btnBuscarActa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        cbxTipoActa = new javax.swing.JComboBox<>();
        btnBuscarProveedor = new javax.swing.JButton();
        txtCodigoAcronimo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtNombreProveedor = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        cbxEmpleados = new javax.swing.JComboBox<>();
        txtProveedorID = new javax.swing.JTextField();

        jLabel8.setText("jLabel8");

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
        label3.setText("Entradas");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Detalle productos");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Código acta:");

        lblFecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFecha.setText("Fecha  de Entrada");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Observaciones");

        txtFecha.setDateFormatString("yyyy/MM/d");
        txtFecha.setEnabled(false);

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Empleado Responsable");

        lblResponsableProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblResponsableProveedor.setText("Responsable entrega");

        txtEmpleadoID.setEditable(false);
        txtEmpleadoID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtProveedorCargo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtObservaciones.setColumns(20);
        txtObservaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtObservaciones.setRows(5);
        jScrollPane3.setViewportView(txtObservaciones);

        btnBuscarActa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarActa.setText("Buscar Acta");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DetalleID", "Fecha", "ProveedorID", "Nombre Proveedor", "ProductoID", "Codigo Producto", "Nombre Producto", "Cantidad", "Serial", "Estado", "CategoriaID", "Nombre Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Seleccione tipo de acta");

        cbxTipoActa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cbxTipoActa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Acta de Entrada", "Acta de Salida" }));
        cbxTipoActa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxTipoActaActionPerformed(evt);
            }
        });

        btnBuscarProveedor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscarProveedor.setText("Buscar proveedor");
        btnBuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProveedorActionPerformed(evt);
            }
        });

        txtCodigoAcronimo.setEditable(false);
        txtCodigoAcronimo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Nombre Proveedor");

        txtNombreProveedor.setEditable(false);

        btnGuardar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnGuardar.setText("Guardar Acta");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        cbxEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEmpleadosActionPerformed(evt);
            }
        });

        txtProveedorID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1245, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGap(1, 1, 1)
                                            .addComponent(txtCodigoAcronimo))
                                        .addComponent(jLabel3))
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCodigo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbxTipoActa, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFecha))))
                            .addGap(27, 27, 27)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombreProveedor)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnBuscarActa, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(cbxEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtEmpleadoID, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(txtProveedorID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtProveedorCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblResponsableProveedor))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarProveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscarActa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(txtCodigoAcronimo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblFecha)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(cbxTipoActa, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(txtNombreProveedor))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsableProveedor)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProveedorCargo, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(cbxEmpleados))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmpleadoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProveedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProveedorActionPerformed
        ModalBuscarProveedorDetalle modal = new ModalBuscarProveedorDetalle();
        modal.setVisible(true);
    }//GEN-LAST:event_btnBuscarProveedorActionPerformed

    private void cbxTipoActaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxTipoActaActionPerformed
        lblFecha.setText(cbxTipoActa.getSelectedIndex() == 0 ? "Fecha de Entrada" : "Fecha de Salida");
        lblResponsableProveedor.setText(cbxTipoActa.getSelectedIndex() == 0 ? "Responsable de entrega" : "Quién recibe");
        txtCodigoAcronimo.setText(cbxTipoActa.getSelectedIndex() == 0 ? "ENT" : "SLD");
    }//GEN-LAST:event_cbxTipoActaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        readFields();
        create();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cbxEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEmpleadosActionPerformed
        txtEmpleadoID.setText(listaEmpleados.get(cbxEmpleados.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbxEmpleadosActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        clearFields();
    }//GEN-LAST:event_btnNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarActa;
    private javax.swing.JButton btnBuscarProveedor;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxEmpleados;
    private javax.swing.JComboBox<String> cbxTipoActa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblResponsableProveedor;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCodigoAcronimo;
    private javax.swing.JTextField txtEmpleadoID;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombreProveedor;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtProveedorCargo;
    private javax.swing.JTextField txtProveedorID;
    // End of variables declaration//GEN-END:variables
}
