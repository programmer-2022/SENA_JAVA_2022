package views;

import controllers.DetalleProductoController;
import controllers.ProductController;
import controllers.ProveedorController;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import models.vo.CategoriaVO;
import models.vo.DetalleProductoVO;
import models.vo.ProductoVO;
import models.vo.ProveedorVO;
import utils.Constants;
import utils.Messages;
import utils.MyDate;
import utils.MySerializable;
import views.modales.ModalBuscarDetalleProducto;

public class PnlProductos extends javax.swing.JPanel {

    public static PnlProductos instance;
    
    private final ProductController productController;
    //private static LinkedList<DetalleProductoVO> listaProductos;
    private final ProveedorController proveedorController;
    private final DetalleProductoController detalleProductoController;
    private ArrayList<DetalleProductoVO> listaProductos;
    
    private int id;
    private String code;
    private String nombre;
    private String serial;
    private String status;
    private String categoria;
    
    private String proveedor;
    private String cantidad;
    private String fecha;
    
    private String busqueda = Constants.SEARCH_CODE;
    
    private HashMap<String, Integer> listaCategorias = null;
    private HashMap<String, Integer> listaProveedores = null;
            
    public synchronized static PnlProductos getInstance() {
        if(instance == null) {
            instance = new PnlProductos();
        }
        return instance;
    }
        
    private PnlProductos() {
        initComponents();
        productController = new ProductController();
        proveedorController = new ProveedorController();
        detalleProductoController = new DetalleProductoController();
        txtCategoriaID.setEnabled(false);
        cargarComboCategorias();
        cargarComboProveedores();
    }
    
    private ProductoVO getProductObj() {
        ProductoVO product = new ProductoVO();
        CategoriaVO cat = new CategoriaVO();       
        
        product.setCode(getCode());
        product.setName(getNombre());
        product.setSerial(getSerial());
        product.setStatus(getStatus());
        cat.setId(Integer.parseInt(getCategoria()));
        product.setCategoria(cat);
        return product;    
    }
    
    private ProveedorVO getProveedorObj() {
        ProveedorVO _proveedor = new ProveedorVO();
        _proveedor.setId(Integer.parseInt(txtProveedorID.getText().trim()));
        return _proveedor;
    }
    
    private DetalleProductoVO getDetalleObj(ProductoVO _producto, ProveedorVO _proveedor) {
        DetalleProductoVO detalle = new DetalleProductoVO();
        detalle.setCantidad(Integer.parseInt(getCantidad()));
        detalle.setFecha(Date.valueOf(getFecha()));
        detalle.setProveedor(_proveedor);
        detalle.setProducto(_producto);
        return detalle;
    }
    
    private void create() {
        if(isEmpty()) {
            Messages.msgError(Constants.REQUIRED);
            txtCodigo.requestFocus();
            return;
        }
        
        if(getStatus().equals("-Seleccione-")) {
            Messages.msgError(Constants.REQUIRED);
            txtCodigo.requestFocus();
            return;
        }
        
        ProductoVO newProduct = getProductObj();
        ProveedorVO newProveedor = getProveedorObj();
        DetalleProductoVO detalle = getDetalleObj(newProduct, newProveedor);
        if(productController.crear(detalle)) {
            Messages.msgSuccess(Constants.OK_INSERT);
        } else {
            Messages.msgError(Constants.ERROR_INSERT);
        }
        clearFields();
        resetVariables();
    }
    
    private boolean isEmpty() {
        return (getCode().equals("") || getNombre().equals("") || getSerial().equals("") 
                || getStatus().equals("") || getCategoria().equals("") || getCantidad().equals("")
                || getProveedor().equals("") || getFecha().equals(""));
    }
    
    private void clearFields() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtSerial.setText("");
        txtEstadoID.setText("");
        txtCantidad.setText("");
        ((JTextField)txtFecha.getDateEditor().getUiComponent()).setText("");
    }
    
    private void resetVariables() {
        setCode("");
        setNombre("");
        setSerial("");
        setStatus("");
        setCategoria("");
        setCantidad("");
        setFecha("");
        setProveedor("");
    }
    
    private void readFields() {
        setCode(txtCodigo.getText().trim());
        setNombre(txtNombre.getText().trim());
        setSerial(txtSerial.getText().trim());
        setStatus(cbxEstado.getSelectedItem().toString());
        setCategoria(txtCategoriaID.getText().trim());
        setProveedor(cbxProveedores.getSelectedItem().toString());
        setCantidad(txtCantidad.getText().trim());
        setFecha(MyDate.getDate(txtFecha));        
    }    
    
    private void cargarComboCategorias() {
        listaCategorias = productController.cargarComboCategorias();
        listaCategorias.keySet().forEach((s) -> {
            cbxCategoria.addItem(s);
        });    
    }
    
    private void cargarComboProveedores() {
        listaProveedores = proveedorController.cargarComboProveedores();
        listaProveedores.keySet().forEach((s) -> {
            cbxProveedores.addItem(s);
        });    
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
        }            
    }
          
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }    
    
    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void readObjSerializable() {
        MySerializable<DetalleProductoVO> _serial = new MySerializable<>();
        DetalleProductoVO obj = _serial.readObj(Constants.PATH_DETALLE_PRODUCTO);

        if(obj != null) {
            txtDetalleID.setText(String.valueOf(obj.getId()));
            txtCantidad.setText(String.valueOf(obj.getCantidad()));
            txtFecha.setDate(obj.getFecha());
            cbxProveedores.setSelectedItem(obj.getProveedor().getNombre());
            txtProductoID.setText(String.valueOf(obj.getProducto().getId()));
            txtCodigo.setText(obj.getProducto().getCode());
            txtNombre.setText(obj.getProducto().getName());
            txtSerial.setText(obj.getProducto().getSerial());
            cbxEstado.setSelectedItem(obj.getProducto().getStatus());
            cbxCategoria.setSelectedItem(obj.getProducto().getCategoria().getName());
        }
    }
    
    public void readObjSerializableAll() {
        MySerializable<ArrayList<DetalleProductoVO>> _serial = new MySerializable<>();
        listaProductos = _serial.readObj(Constants.PATH_DETALLE_TODOS_PRODUCTOS);        
        if(listaProductos != null) fillDataTable();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        txtCodigo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtSerial = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbxCategoria = new javax.swing.JComboBox<>();
        cbxEstado = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        txtCategoriaID = new javax.swing.JTextField();
        txtEstadoID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnNuevaCategoria = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbxProveedores = new javax.swing.JComboBox<>();
        txtFecha = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtProveedorID = new javax.swing.JTextField();
        txtDetalleID = new javax.swing.JTextField();
        txtProductoID = new javax.swing.JTextField();

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
        label3.setText("Productos");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        txtCodigo.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha registro");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nombre");

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Serial");

        txtSerial.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Estado físico");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Categoría");

        cbxCategoria.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        cbxEstado.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Seleccione-", "Nuevo", "Usado" }));

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txtCategoriaID.setEditable(false);

        txtEstadoID.setEditable(false);

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

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar producto");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar producto");

        btnNuevaCategoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevaCategoria.setText("Nueva Categoría");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cantidad");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Codigo");

        cbxProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxProveedoresActionPerformed(evt);
            }
        });

        txtFecha.setDateFormatString("yyyy/MM/d");
        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Seleccione Proveedor");

        txtProveedorID.setEditable(false);

        txtDetalleID.setEditable(false);

        txtProductoID.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1600, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4))
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(281, 281, 281)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(272, 272, 272)
                                .addComponent(jLabel7)
                                .addGap(276, 276, 276)
                                .addComponent(jLabel1))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCategoriaID, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtEstadoID, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtProveedorID, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(txtDetalleID, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtProductoID, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(txtSerial))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cbxProveedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbxProveedores, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSerial, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCategoriaID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEstadoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProveedorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDetalleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtProductoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        txtCategoriaID.setText(listaCategorias.get(cbxCategoria.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        readFields();
        create();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void cbxProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxProveedoresActionPerformed
        txtProveedorID.setText(listaProveedores.get(cbxProveedores.getSelectedItem().toString()).toString());
    }//GEN-LAST:event_cbxProveedoresActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        ModalBuscarDetalleProducto modal = new ModalBuscarDetalleProducto();
        modal.setVisible(true);
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxCategoria;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JComboBox<String> cbxProveedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label3;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCategoriaID;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDetalleID;
    private javax.swing.JTextField txtEstadoID;
    private com.toedter.calendar.JDateChooser txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtProductoID;
    private javax.swing.JTextField txtProveedorID;
    private javax.swing.JTextField txtSerial;
    // End of variables declaration//GEN-END:variables
}