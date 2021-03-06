package Paq_Interfaz;


import Atxy2k.CustomTextField.RestrictedTextField;
import Paq_Interfaz.Frm_Menu;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.ComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACMK
 */
public class Frm_InventarioA2 extends javax.swing.JFrame {

    /**
     * Creates new form Frm_InventarioA
     */
    private ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"));
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    Paq_Clases.Cla_Fecha fecha = new Paq_Clases.Cla_Fecha();
    private DefaultTableModel model;
    private DecimalFormat format = new DecimalFormat("##,###,###,##0.00");
    private int fila;
    
    public Frm_InventarioA2() {
        initComponents();
        this.Ajustar(lblLogo, icon1);
        this.setLocationRelativeTo(null);
        txtF.setText(fecha.getFecha());
        this.Llenar();
        this.restringir();
    }
    
    public void Llenar(){
        try {
            String[]titulos={"Codigo","Nombre","Descripcion","Precio",
                "Cantidad"};
            String sql="select * from inventario";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= operaciones.Consultar(sql);
            String[]fila=new String[5];
            while(rs.next()){
            fila[0]=rs.getString("cod_producto");
            fila[1]=rs.getString("nombre_producto");
            fila[2]=rs.getString("descripcion");
            fila[3]=format.format(rs.getFloat("precio_venta"));
            fila[4]=rs.getString("cantidad"); 
                model.addRow(fila);      
            }
            tbl.setModel(model);
            operaciones.conn.close();
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());    
        }
    }
    
     public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint(); 
    }
     
     public void restringir(){
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtCa);
        restricted3.setOnlyNums(true);
          restricted3.setLimit(6);
//        RestrictedTextField restricted4 = new RestrictedTextField(this.txtB);
//        restricted4.setLimit(10);
    }
     
    public boolean verificacion() {
        fila = tbl.getSelectedRow();
        if (fila > -1) {
            if (!txtCa.getText().equals("")) {
                int total = Integer.parseInt(tbl.getValueAt(fila, 4).toString()) + Integer.parseInt(txtCa.getText());
                if (total <= getMaximo()) {
                    return true;
                } else {
                    JOptionPane.showMessageDialog(null, "La cantidad no puede superar el maximo de: " + getMaximo(), null, JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Rellene los Campos", null, JOptionPane.WARNING_MESSAGE);
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila en la tabla superior", null, JOptionPane.WARNING_MESSAGE);
            return false;
         }
    }
     
     public int getMinimo() {
        int numero = 0;
        try {
            String sql = "select * from valores where id_valor= '1'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                numero = rs.getInt("minimo");
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return numero;
    }
     
        public int getMaximo() {
        int numero = 0;
        try {
            String sql = "select * from valores where id_valor= '1'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                numero = rs.getInt("maximo");
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return numero;
    }
    
     public int getSeguridad() {
        int numero = 0;
        try {
            String sql = "select * from valores where id_valor= '1'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                numero = rs.getInt("seguridad");
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return numero;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtR = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtF = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtP = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnAt = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        lblFondo = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos de Ingreso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad que Ingresa");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        txtCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCaActionPerformed(evt);
            }
        });
        txtCa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCaKeyPressed(evt);
            }
        });
        jPanel5.add(txtCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 130, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Responsable");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 110, 30));

        txtR.setEnabled(false);
        txtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRActionPerformed(evt);
            }
        });
        jPanel5.add(txtR, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 20, 120, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Ingreso");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 130, 30));

        txtF.setEnabled(false);
        txtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActionPerformed(evt);
            }
        });
        jPanel5.add(txtF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, 120, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("*");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 20, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 20, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("*");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 20, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Producto Seleccionado");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        txtP.setEnabled(false);
        txtP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPKeyPressed(evt);
            }
        });
        jPanel5.add(txtP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 130, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 590, 100));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-10.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-14.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 112, 32));

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-10.png"))); // NOI18N
        btnA.setContentAreaFilled(false);
        btnA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-14.png"))); // NOI18N
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        jPanel1.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 112, 32));

        btnAt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        btnAt.setContentAreaFilled(false);
        btnAt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        btnAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtActionPerformed(evt);
            }
        });
        jPanel1.add(btnAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 112, 32));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 300, 60));

        jLabel15.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 51));
        jLabel15.setText("Añadir Productos");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 240, 60));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 60, 20));

        txtB.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBActionPerformed(evt);
            }
        });
        txtB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBKeyReleased(evt);
            }
        });
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Codigo" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 150, 20));

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tbl.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMouseClicked(evt);
            }
        });
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(tbl);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 560, 110));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 590, 170));

        lblFondo.setBackground(new java.awt.Color(255, 255, 255));
        lblFondo.setOpaque(true);
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 420));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
if (this.verificacion()){
        int cantidad=0;
        try {
            String sql = "SELECT cantidad FROM inventario where cod_producto = '"+model.getValueAt(fila, 0)+"'";
            ResultSet rs = operaciones.Consultar(sql);
            while(rs.next()){
                cantidad = Integer.parseInt(rs.getString("cantidad"));
            }
            operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
        cantidad += Integer.parseInt(txtCa.getText());
        try {
            String sql = "UPDATE inventario set cantidad=?, fecha_ingreso=? WHERE cod_producto = '"+model.getValueAt(fila, 0)+"'";
            PreparedStatement ps = operaciones.Actualizar(sql);
            ps.setInt(1, cantidad);
            ps.setString(2, txtF.getText());
            int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "PRODUCTO AÑADIDO CON EXITO");
                    this.Borrar(1);
                    this.Llenar();
                }
                operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
} 
    }//GEN-LAST:event_btnAActionPerformed

    private void btnAtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnAtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.Borrar(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void txtRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRActionPerformed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        int c = evt.getKeyChar();
        if(cbxFiltro.getSelectedIndex()==0){
            try {
                String[]titulos={"Codigo","Nombre","Descripcion","Precio",
                    "Cantidad"};
                String sql="select * from inventario where nombre_producto like '"+this.txtB.getText().toLowerCase()+"%'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                    fila[0]=rs.getString("cod_producto");
                    fila[1]=rs.getString("nombre_producto");
                    fila[2]=rs.getString("descripcion");
                    fila[3]=rs.getString("precio_venta");
                    fila[4]=rs.getString("cantidad");
                    model.addRow(fila);
                    tbl.setModel(model);
                }
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if(cbxFiltro.getSelectedIndex()==1){
            try {
                String[]titulos={"Codigo","Nombre","Descripcion","Precio",
                    "Cantidad"};
                String sql="select * from inventario where descripcion like '"+this.txtB.getText().toLowerCase()+"%'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                    fila[0]=rs.getString("cod_producto");
                    fila[1]=rs.getString("nombre_producto");
                    fila[2]=rs.getString("descripcion");
                    fila[3]=rs.getString("precio_venta");
                    fila[4]=rs.getString("cantidad");
                    model.addRow(fila);
                    tbl.setModel(model);

                }
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if (!"".equals(txtB.getText())){
            if(cbxFiltro.getSelectedIndex()==2){
              if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
         try {
                String[]titulos={"Codigo","Nombre","Descripcion","Precio",
                    "Cantidad"};
                String sql="select * from inventario where cod_producto = '"+this.txtB.getText().toLowerCase()+"'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                    fila[0]=rs.getString("cod_producto");
                    fila[1]=rs.getString("nombre_producto");
                    fila[2]=rs.getString("descripcion");
                    fila[3]=rs.getString("precio_venta");
                    fila[4]=rs.getString("cantidad");
                    model.addRow(fila);
                }
                tbl.setModel(model);
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros","ERROR",JOptionPane.ERROR_MESSAGE);
            this.txtB.setText("");
        }
            
        }
        }
        if ("".equals(txtB.getText())){
            try {
                String[]titulos={"Codigo","Nombre","Descripcion","Precio",
                    "Cantidad"};
                String sql="select * from inventario";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                    fila[0]=rs.getString("cod_producto");
                    fila[1]=rs.getString("nombre_producto");
                    fila[2]=rs.getString("descripcion");
                    fila[3]=rs.getString("precio_venta");
                    fila[4]=rs.getString("cantidad");
                    model.addRow(fila);
                }
                tbl.setModel(model);
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_txtBKeyReleased

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        fila = this.tbl.getSelectedRow();
        this.txtCa.setText(null);
        txtP.setText(model.getValueAt(fila, 1).toString());
    }//GEN-LAST:event_tblMouseClicked

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void txtCaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCaKeyPressed

    }//GEN-LAST:event_txtCaKeyPressed

    private void txtPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPKeyPressed

    private void txtCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtCaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try{
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
          e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_InventarioA2().setVisible(true);
            }
        });
    }

    private void Borrar(int tipo) {
        //Elimina campos llenos en el formulario
        switch (tipo){
            case 1:
                txtCa.setText(null);
                txtP.setText(null);
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnAt;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtCa;
    private javax.swing.JTextField txtF;
    private javax.swing.JTextField txtP;
    public javax.swing.JTextField txtR;
    // End of variables declaration//GEN-END:variables
}
