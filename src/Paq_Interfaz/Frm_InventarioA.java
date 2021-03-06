package Paq_Interfaz;


import Atxy2k.CustomTextField.RestrictedTextField;
import Paq_Interfaz.Frm_Menu;
import java.awt.Color;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Formatter;
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
public class Frm_InventarioA extends javax.swing.JFrame {

    /**
     * Creates new form Frm_InventarioA
     */
    private ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"));
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    Paq_Clases.Cla_Fecha fecha = new Paq_Clases.Cla_Fecha();
    private boolean update;
    
    public Frm_InventarioA() {
        initComponents();
        this.Ajustar(lblLogo, icon1);
        this.setLocationRelativeTo(null);
        txtF.setText(fecha.getFecha());
        this.Llenar();
        this.restringir();
    }
    
    public static double redondearDecimales(float valorInicial, int numeroDecimales) {
        double parteEntera, resultado;

        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }
    
    public void restringir(){
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtC);
        restricted3.setOnlyNums(true);
        restricted3.setLimit(10);
        
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtCa);
        restricted4.setOnlyNums(true);
        restricted4.setLimit(6);
        
        RestrictedTextField restricted6 = new RestrictedTextField(this.txtN);
       
        restricted6.setLimit(20);
        
        RestrictedTextField restricted5 = new RestrictedTextField(this.txtC);
        restricted5.setOnlyNums(true);
         
          RestrictedTextField restricted9 = new RestrictedTextField(this.txtPrecio);
        restricted9.setOnlyNums(true);
        restricted9.setLimit(9);
        
         RestrictedTextField restricted10 = new RestrictedTextField(this.txtMargen);
        restricted10.setOnlyNums(true);
        restricted10.setLimit(2);
        
        
        RestrictedTextField r1 = new RestrictedTextField(txtPrecio, "0123456789.");
        RestrictedTextField r2 = new RestrictedTextField(txtMargen, "0123456789.");
    }
    
    public void Llenar(){
        try {
            String sql = "select * from proveedores";
            ResultSet rs= operaciones.Consultar(sql);
            while(rs.next()){
            cbxP.addItem(rs.getString("nombre")); 
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            String sql1 = "select * from valores";
            ResultSet rs= operaciones.Consultar(sql1);
            while(rs.next()){
            txtIva.setText(rs.getString("iva"));
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public int getCodigoPro (String nombre){
        int cod = 0;
        try {
            String sql = "select * from proveedores where nombre = '"+nombre+"'";
            ResultSet rs= operaciones.Consultar(sql);
            while(rs.next()){
            cod = rs.getInt("cod_proveedor"); 
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cod;
    }
    
     public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint(); 
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        cbxL = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbxP = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtCa = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtR = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtF = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnAt = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtIva = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtMargen = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
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

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(0, 153, 51));
        jPanel3.setToolTipText("");
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nombre del Producto");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 30));

        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });
        jPanel3.add(txtN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, 170, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Linea de Producto");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 120, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Descripcion");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 20));

        txtD.setColumns(1);
        txtD.setLineWrap(true);
        txtD.setRows(1);
        txtD.setTabSize(1);
        txtD.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txtD);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 300, 50));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Codigo producto");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));
        jPanel3.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 170, 30));

        cbxL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laton", "Ferroso", "Bronce", "Hierro" }));
        jPanel3.add(cbxL, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 170, 30));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Proveedor");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 30));

        cbxP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPActionPerformed(evt);
            }
        });
        jPanel3.add(cbxP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 160, 30));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update 16x16.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 30, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 20, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 20, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 20, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("*");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 20, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("*");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 20, 30));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar 12x12.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 30, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 330, 270));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 153, 51));
        jPanel5.setToolTipText("");
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Cantidad que Ingresa");
        jPanel5.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));
        jPanel5.add(txtCa, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 130, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Responsable");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 130, 30));

        txtR.setEnabled(false);
        txtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRActionPerformed(evt);
            }
        });
        jPanel5.add(txtR, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 130, 30));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Fecha de Ingreso");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 30));

        txtF.setEnabled(false);
        txtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFActionPerformed(evt);
            }
        });
        jPanel5.add(txtF, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 130, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("*");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 20, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 20, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("*");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 20, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText("*");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 20, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(204, 0, 0));
        jLabel29.setText("*");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 20, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 330, 140));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-10.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-14.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, 112, 32));

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-10.png"))); // NOI18N
        btnA.setContentAreaFilled(false);
        btnA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-14.png"))); // NOI18N
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        jPanel1.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 112, 32));

        btnAt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        btnAt.setContentAreaFilled(false);
        btnAt.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        btnAt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtActionPerformed(evt);
            }
        });
        jPanel1.add(btnAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 370, 112, 32));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Producto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 153, 51));
        jPanel4.setToolTipText("");
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("%");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 20, 30));

        txtTotal.setEditable(false);
        txtTotal.setEnabled(false);
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        jPanel4.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 90, 30));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel8.setText("Precio de Venta");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 100, 30));

        txtPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioActionPerformed(evt);
            }
        });
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioKeyReleased(evt);
            }
        });
        jPanel4.add(txtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 70, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("IVA");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 30, 30));

        txtIva.setText("0");
        txtIva.setEnabled(false);
        txtIva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIvaActionPerformed(evt);
            }
        });
        txtIva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIvaKeyReleased(evt);
            }
        });
        jPanel4.add(txtIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 30, 30));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Margen");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 60, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("%");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 20, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Precio Unitario");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 100, 30));

        txtMargen.setText("0");
        txtMargen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMargenActionPerformed(evt);
            }
        });
        txtMargen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMargenKeyReleased(evt);
            }
        });
        jPanel4.add(txtMargen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 40, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("*");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 20, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("*");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 20, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 0, 0));
        jLabel28.setText("*");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 20, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 240, 330, 120));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, 60));

        jLabel15.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 153, 51));
        jLabel15.setText("Nuevo Producto");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 230, 60));

        lblFondo.setBackground(new java.awt.Color(255, 255, 255));
        lblFondo.setOpaque(true);
        jPanel1.add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 420));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
if (this.verificacion()){ 
        try {
            String sql = "insert into inventario(cod_producto, nombre_producto, cod_proveedor, linea_producto"
                    + ", descripcion, cantidad, fecha_ingreso, responsable, precio_venta, margen, precio_unitario)"
                + "values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = operaciones.Ingresar(sql);
            ps.setLong(1, Long.parseLong(txtC.getText().toLowerCase()));
            ps.setString(2, txtN.getText().toLowerCase());
            ps.setInt(3, getCodigoPro(cbxP.getSelectedItem().toString()));
            ps.setString(4, cbxL.getSelectedItem().toString().toLowerCase());
            ps.setString(5, txtD.getText().toLowerCase());
            ps.setLong(6, Long.parseLong(txtCa.getText().toLowerCase()));
            ps.setString(7, txtF.getText().toLowerCase());
            ps.setString(8, txtR.getText().toLowerCase());
            if(!"".equals(txtTotal.getText())){
              ps.setFloat(9, Float.parseFloat(txtTotal.getText()));  
            }else{
              ps.setFloat(9, 0); 
            }
            if(!"".equals(txtMargen.getText())){
              ps.setFloat(10, Float.parseFloat(txtMargen.getText()));  
            }else{
              ps.setFloat(10, 0); 
            }
            if(!"".equals(txtPrecio.getText())){
              ps.setFloat(11, Float.parseFloat(txtPrecio.getText()));  
            }else{
              ps.setFloat(11, 0); 
            }
            int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "PRODUCTO INGRESADO CON EXITO");
                    this.Borrar(1);
                }
                operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
}      
    }//GEN-LAST:event_btnAActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioActionPerformed

    private void txtIvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIvaActionPerformed

    private void txtMargenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMargenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMargenActionPerformed

    private void txtPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyPressed

    }//GEN-LAST:event_txtPrecioKeyPressed

    private void txtPrecioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyReleased
    float resultado = 0, iva = 0, margen = 0, precio=0;
    if (txtPrecio.getText().equals("0")||txtPrecio.getText().equals(".")) {
            txtPrecio.setText("");
    }
    
    if (!txtIva.getText().equals("")){
        iva = Float.parseFloat(txtIva.getText());
    }else{
        iva = 0;
    }
    if (!txtMargen.getText().equals("")){
        margen = Float.parseFloat(txtMargen.getText());
    }else{
        margen = 0;
    }
    if (!txtPrecio.getText().equals("")){
        precio = Float.parseFloat(txtPrecio.getText());
    }else{
        precio = 0;
    }
    resultado = precio + (precio*(iva/100));
    resultado += (resultado*(margen/100));
    txtTotal.setText(String.valueOf(redondearDecimales(resultado, 2)));
    }//GEN-LAST:event_txtPrecioKeyReleased

    private void txtMargenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMargenKeyReleased
    float resultado = 0, iva = 0, margen = 0, precio=0;
    if (!txtIva.getText().equals("")){
        iva = Float.parseFloat(txtIva.getText());
    }else{
        iva = 0;
    }
    if (!txtMargen.getText().equals("")){
        margen = Float.parseFloat(txtMargen.getText());
    }else{
        margen = 0;
    }
    if (!txtPrecio.getText().equals("")){
        precio = Float.parseFloat(txtPrecio.getText());
    }else{
        precio = 0;
    }
    resultado = precio + (precio*(iva/100));
    resultado += (resultado*(margen/100));
    txtTotal.setText(String.valueOf(redondearDecimales(resultado, 2)));
    }//GEN-LAST:event_txtMargenKeyReleased

    private void txtIvaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIvaKeyReleased
    float resultado = 0, iva = 0, margen = 0, precio=0;
    if (!txtIva.getText().equals("")){
        iva = Float.parseFloat(txtIva.getText());
    }else{
        iva = 0;
    }
    if (!txtMargen.getText().equals("")){
        margen = Float.parseFloat(txtMargen.getText());
    }else{
        margen = 0;
    }
    if (!txtPrecio.getText().equals("")){
        precio = Float.parseFloat(txtPrecio.getText());
    }else{
        precio = 0;
    }
    resultado = precio + (precio*(iva/100));
    resultado += (resultado*(margen/100));
    txtTotal.setText(String.valueOf(redondearDecimales(resultado, 2)));
    }//GEN-LAST:event_txtIvaKeyReleased

    private void cbxPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPActionPerformed

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

    }//GEN-LAST:event_formWindowLostFocus

    private void txtRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                            
          new Paq_Interfaz.Frm_ProveedoresA().setVisible(true);
  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       this.txtC.setText(null);
        update = true;
        cbxP.removeAllItems();
        try {
            String sql = "select * from proveedores";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
             cbxP.addItem(rs.getString("nombre"));
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        update = false;      
    }//GEN-LAST:event_jButton4ActionPerformed

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
                new Frm_InventarioA().setVisible(true);
            }
        });
    }

    
    private boolean verificacion(){
            if (!"".equals(txtN.getText()) && !"".equals(txtC.getText()) && 
            !"".equals(txtCa.getText()) && !"".equals(txtPrecio.getText())
                    && !"".equals(txtR.getText())) {
                return true; 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Faltan Campos por llenar");
                return false; 
            }
    }
    private void Borrar(int tipo) {
        //Elimina campos llenos en el formulario
        switch (tipo){
            case 1:
                txtN.setText(null);
                txtCa.setText(null);
                txtC.setText(null);
                txtD.setText(null);
                txtPrecio.setText(null);
                txtMargen.setText(null);
                txtTotal.setText(null);
                break;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnAt;
    private javax.swing.JComboBox<String> cbxL;
    private javax.swing.JComboBox<String> cbxP;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtCa;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextField txtF;
    private javax.swing.JTextField txtIva;
    private javax.swing.JTextField txtMargen;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtPrecio;
    public javax.swing.JTextField txtR;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
