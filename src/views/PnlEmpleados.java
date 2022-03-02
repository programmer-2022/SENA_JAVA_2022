package views;

import controllers.ControllerEmpleado;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.vo.EmpleadoVO;
import utils.Constants;
import utils.Messages;
import views.modales.ModalInsertarEmpleado;

import utils.MySerializable;

public class PnlEmpleados extends javax.swing.JPanel {

    private String identificacion;
    private static ControllerEmpleado controllerEmpleado;
    private static LinkedList<EmpleadoVO> listaEmpleados;
    private EmpleadoVO empleado = null;
 
    
    public PnlEmpleados() {
        initComponents();
        controllerEmpleado = new ControllerEmpleado();
        fillDataTable();        
    }
    
    public static void fillDataTable() {
        listaEmpleados = controllerEmpleado.readAll();
        String datos[][] = new String[listaEmpleados.size()][8];
        String[] columns = {
            "ID", "Identificacion", "Nombre", "Apellido", "GeneroID", "Genero", "CargoID", "Cargo"
        };

        if(!listaEmpleados.isEmpty()) {
            for (int i = 0; i < listaEmpleados.size(); i++) {
                datos[i][0] = Integer.toString(listaEmpleados.get(i).getId());
                datos[i][1] = Integer.toString(listaEmpleados.get(i).getIdentificacion());
                datos[i][2] = listaEmpleados.get(i).getNombre();
                datos[i][3] = listaEmpleados.get(i).getApellido();
                datos[i][4] = Integer.toString(listaEmpleados.get(i).getGenero().getId());
                datos[i][5] = listaEmpleados.get(i).getGenero().getName();
                datos[i][6] = Integer.toString(listaEmpleados.get(i).getCargo().getId());
                datos[i][7] = listaEmpleados.get(i).getCargo().getName();
            }
            
            DefaultTableModel model = new DefaultTableModel(datos, columns);
            int[] columnSize = {10, 50, 50, 50, 50, 50, 50, 50};
            for(int x=0; x<columnSize.length;x++) {
                tblEmpleados.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
            }
            tblEmpleados.setRowHeight(30);
            tblEmpleados.setModel(model);
        }               
    }

    public void fillDataTableOne(int identificacion) {
        listaEmpleados = controllerEmpleado.readOne(identificacion);
        String datos[][] = new String[listaEmpleados.size()][8];
        String[] columns = {
            "ID", "Identificacion", "Nombre", "Apellido", "GeneroID", "Genero", "CargoID", "Cargo"
        };

        if(!listaEmpleados.isEmpty()) {
            for (int i = 0; i < listaEmpleados.size(); i++) {
                datos[i][0] = Integer.toString(listaEmpleados.get(i).getId());
                datos[i][1] = Integer.toString(listaEmpleados.get(i).getIdentificacion());
                datos[i][2] = listaEmpleados.get(i).getNombre();
                datos[i][3] = listaEmpleados.get(i).getApellido();
                datos[i][4] = Integer.toString(listaEmpleados.get(i).getGenero().getId());
                datos[i][5] = listaEmpleados.get(i).getGenero().getName();
                datos[i][6] = Integer.toString(listaEmpleados.get(i).getCargo().getId());
                datos[i][7] = listaEmpleados.get(i).getCargo().getName();
            }
            
            DefaultTableModel model = new DefaultTableModel(datos, columns);
            int[] columnSize = {10, 50, 50, 50, 50, 50, 50, 50};
            for(int x=0; x<columnSize.length;x++) {
                tblEmpleados.getColumnModel().getColumn(x).setPreferredWidth(columnSize[x]);
            }
            tblEmpleados.setRowHeight(30);
            tblEmpleados.setModel(model);
        }               
    }
    
    private void buscar() {
        identificacion = txtBuscar.getText().trim();
                
        if(identificacion.equals("")) {
            Messages.msgError(Constants.REQUIRED);
            txtBuscar.requestFocus();
            return;
        }        
        
        if(isNumber(identificacion)) {
            empleado = controllerEmpleado.buscarID(Integer.parseInt(identificacion));
            MySerializable serial = new MySerializable();
            serial.writeObj(empleado, Constants.PATH_SERIAL_EMPLEADO);
            if(empleado != null) {
                fillDataTableOne(Integer.parseInt(identificacion));
            }
        } else Messages.msgError(Constants.ONLY_NUMBERS);
    }
    
    private boolean isNumber(String text) {
        return (text.matches("[0-9]+"));
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label3 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnNuevoEmpleado = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnVerTodos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
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
        label3.setText("Empleados");
        jPanel2.add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 50));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, -1, -1));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, 140, 42));

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "EmpleadoID", "Identificacion", "Nombre", "Apellido", "GeneroID", "Genero", "CargoID", "Cargo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEmpleados);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 1230, 420));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Lista de empleados");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        txtBuscar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 250, 41));

        btnNuevoEmpleado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNuevoEmpleado.setText("Nuevo Empleado");
        btnNuevoEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoEmpleadoActionPerformed(evt);
            }
        });
        add(btnNuevoEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Buscar por identificación:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        btnVerTodos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVerTodos.setText("Ver Todos");
        btnVerTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerTodosActionPerformed(evt);
            }
        });
        add(btnVerTodos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 210, 160, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoEmpleadoActionPerformed
        ModalInsertarEmpleado.operacionDML = Constants.INSERT;
        ModalInsertarEmpleado modal = new ModalInsertarEmpleado();
        modal.setVisible(true);
    }//GEN-LAST:event_btnNuevoEmpleadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscar();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked
        
        if(listaEmpleados != null) {
        
            int row = tblEmpleados.getSelectedRow();
            String id = tblEmpleados.getValueAt(row, 1).toString();

            int dialogResult = JOptionPane.showConfirmDialog (
                null, 
                "¿Editar este registro?",
                "Warning",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
            );

            if(dialogResult == JOptionPane.YES_OPTION){
                EmpleadoVO _empleado = controllerEmpleado.buscarID(Integer.parseInt(id));
                MySerializable serial = new MySerializable();
                serial.writeObj(_empleado, Constants.PATH_SERIAL_EMPLEADO);

                ModalInsertarEmpleado.operacionDML = Constants.UPDATE;
                ModalInsertarEmpleado modal = new ModalInsertarEmpleado();
                modal.setVisible(true);
                modal.readObjSerializable();            
            }
        }               
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnVerTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerTodosActionPerformed
        fillDataTable();
    }//GEN-LAST:event_btnVerTodosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNuevoEmpleado;
    private javax.swing.JButton btnVerTodos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private java.awt.Label label3;
    public static javax.swing.JTable tblEmpleados;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
