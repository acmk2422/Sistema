package Paq_Interfaz;

import Atxy2k.CustomTextField.RestrictedTextField;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Frm_ClientesC extends javax.swing.JFrame {

    DefaultTableModel model;
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    private String cedula;
    private String codigo;
    
    public Frm_ClientesC() {
        initComponents();
        setLocationRelativeTo(null);
        this.llenar();
        this.restringir();
    }
    
    public void restringir(){
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtC);
        restricted3.setOnlyNums(true);
        restricted3.setLimit(8);
        
        RestrictedTextField restricted4 = new RestrictedTextField(this.txtT1);
        restricted4.setOnlyNums(true);
         restricted4.setLimit(11);
         
        RestrictedTextField restricted = new RestrictedTextField(this.txtT2);
        restricted.setOnlyNums(true);
         restricted.setLimit(11);
         
         RestrictedTextField restricted5= new RestrictedTextField(this.txtN1);
        restricted5.setOnlyText(true);
        restricted5.setLimit(10);
         
          RestrictedTextField restricted10= new RestrictedTextField(this.txtN2);
        restricted10.setOnlyText(true);
        restricted10.setLimit(10);
        
         RestrictedTextField restricted12= new RestrictedTextField(this.txtA1);
        restricted12.setOnlyText(true);
        restricted12.setLimit(10);
         
          RestrictedTextField restricted11= new RestrictedTextField(this.txtA2);
        restricted11.setOnlyText(true);
        restricted11.setLimit(10);
         
          RestrictedTextField restricted14= new RestrictedTextField(this.txtNe);
        restricted14.setOnlyText(true);
        restricted14.setLimit(10);
         
    
         RestrictedTextField restricted7 = new RestrictedTextField(this.txtE);
         restricted7.setLimit(40);
         
      
       
         
    }
    
    private void Borrar(int tipo) {
        //Elimina campos llenos en el formulario
        switch (tipo){
            case 1:
                txtN1.setText(null);
                txtN2.setText(null);
                txtA1.setText(null);
                txtA2.setText(null);
                txtC.setText(null);
                break;
            case 2:
                txtD.setText(null);
                txtT1.setText(null);
                txtT2.setText(null);
                txtE.setText(null);
                break;
            case 3:
                txtN1.setText(null);
                txtN2.setText(null);
                txtA1.setText(null);
                txtA2.setText(null);
                txtC.setText(null);
                txtD.setText(null);
                txtT1.setText(null);
                txtT2.setText(null);
                txtE.setText(null);
                txtNe.setText(null);
                break;
        }
    }
    
    public void llenar(){
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql="select * from clientes";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= operaciones.Consultar(sql);
            String[]fila=new String[10];
            while(rs.next()){
            fila[0]=rs.getString("cod_cliente");
            fila[1]=rs.getString("nombre_empresa");
            fila[2]=rs.getString("primer_nombre");
            fila[3]=rs.getString("segundo_nombre");
            fila[4]=rs.getString("primer_apellido");
            fila[5]=rs.getString("segundo_apellido"); 
            fila[6]=rs.getString("cedula");
            fila[7]=rs.getString("telefono1");
            fila[8]=rs.getString("telefono2");
            fila[9]=rs.getString("email");
                model.addRow(fila);      
            }
            tbl.setModel(model);
            operaciones.conn.close();
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());    
    }
    }
    
    public void Habilitar(int x){
        //activa los componentes para editar dependiento si es natural o juridico
        if (x==1) {
            txtN1.setEnabled(true);
            txtN2.setEnabled(true);
            txtA1.setEnabled(true);
            txtA2.setEnabled(true);
            txtC.setEnabled(true);
            txtD.setEnabled(true);
            txtD.setEditable(true);
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            txtE.setEnabled(true);
            cbxC.setEnabled(true);
            cbxN.setEnabled(true);
            cbxJ.setSelected(false);
        } else {
            txtNe.setEnabled(true);
            txtD.setEnabled(true);
            txtD.setEditable(true);
            txtT1.setEnabled(true);
            txtC.setEnabled(true);
            txtT2.setEnabled(true);
            txtE.setEnabled(true);
            cbxC.setEnabled(true);
            cbxJ.setEnabled(true);
            cbxN.setSelected(false);
        }
        
    }
    
    public void Deshabilitar(int x){
        if (x==1) {
            txtN1.setEnabled(false);
            txtN2.setEnabled(false);
            txtA1.setEnabled(false);
            txtA2.setEnabled(false);
            cbxN.setEnabled(false);
            cbxJ.setSelected(true);
        } else if (x==2) {
            txtNe.setEnabled(false);
            cbxN.setSelected(true);
            cbxJ.setSelected(false);
        } else{
            txtN1.setEnabled(false);
            txtNe.setEnabled(false);
            txtN2.setEnabled(false);
            txtA1.setEnabled(false);
            txtA2.setEnabled(false);
            txtD.setEnabled(false);
            txtC.setEnabled(false);
            txtE.setEnabled(false);
            txtT1.setEnabled(false);
            txtT2.setEnabled(false);
            cbxN.setEnabled(false);
            cbxJ.setEnabled(false);
            cbxN.setSelected(false);
            cbxJ.setSelected(false);
            cbxC.setEnabled(false);
        }
        
    }
    
    public void Desencadenar(String datos){
        //funcion para separar cedula de la letra
        String tipo = "", cedula = "";
       int i=0, j=0;
       for (i=0;i<datos.length();i++){
           if (datos.charAt(i)=='-'){
               break;
           }else{
               tipo += datos.charAt(i) + "";
           }
       }
       for (j=i+1;j<datos.length();j++){
           if (datos.charAt(j)==' '){
               break;
           }else{
              cedula += datos.charAt(j) + "";
           }
       }
       txtC.setText(cedula);
       cbxC.setSelectedItem(tipo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        cbxC1 = new javax.swing.JComboBox<>();
        txtB = new javax.swing.JTextField();
        btnC = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnE = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxOpcion = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtE = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        txtT2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtT1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtN1 = new javax.swing.JTextField();
        txtA2 = new javax.swing.JTextField();
        txtC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtN2 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtA1 = new javax.swing.JTextField();
        cbxN = new javax.swing.JRadioButton();
        cbxJ = new javax.swing.JRadioButton();
        txtNe = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbxC = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(0, 153, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "P", "G", "J", "C" }));
        cbxC1.setEnabled(false);
        jPanel1.add(cbxC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 30, 50, 30));

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
        jPanel1.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 180, 30));

        btnC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar-10.png"))); // NOI18N
        btnC.setContentAreaFilled(false);
        btnC.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Consultar-14.png"))); // NOI18N
        btnC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });
        jPanel1.add(btnC, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 30, 112, 32));

        jScrollPane1.setEnabled(false);

        tbl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 0, 12))); // NOI18N
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8"
            }
        ));
        tbl.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1010, 130));

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar-10.png"))); // NOI18N
        btnE.setContentAreaFilled(false);
        btnE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar-14.png"))); // NOI18N
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });
        jPanel1.add(btnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 390, 112, 32));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-10.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-14.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 390, 112, 32));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, 112, 32));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 310, 60));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Clientes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 120, 40));

        cbxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Cedula/RIF", "Empresa" }));
        cbxOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionActionPerformed(evt);
            }
        });
        jPanel1.add(cbxOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 30, 120, 30));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos de Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Direccion");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Telefono Secundario");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, 20));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Correo Electronico");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 20));

        txtE.setEnabled(false);
        txtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEActionPerformed(evt);
            }
        });
        jPanel3.add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 190, -1));

        txtD.setEditable(false);
        txtD.setColumns(1);
        txtD.setRows(1);
        txtD.setEnabled(false);
        jScrollPane3.setViewportView(txtD);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 360, 40));

        txtT2.setEnabled(false);
        txtT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtT2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 100, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Telefono Principal");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        txtT1.setEnabled(false);
        jPanel3.add(txtT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 100, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("*");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 20, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("*");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 20, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 0, 0));
        jLabel17.setText("*");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 20, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("*Datos Obligatorios");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 120, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 490, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nombre Empresa:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 120, 20));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Segundo Apellido");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, -1, 20));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Cedula / RIF");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 20));

        txtN1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtN1.setEnabled(false);
        txtN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, -1));

        txtA2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtA2.setEnabled(false);
        txtA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 110, -1));

        txtC.setForeground(new java.awt.Color(0, 153, 51));
        txtC.setText("24035416");
        txtC.setEnabled(false);
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });
        jPanel2.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 70, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Segundo Nombre");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 120, 20));

        txtN2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtN2.setEnabled(false);
        txtN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 110, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Primer Apellido");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtA1.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtA1.setEnabled(false);
        txtA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        cbxN.setBackground(new java.awt.Color(255, 255, 255));
        cbxN.setSelected(true);
        cbxN.setText("NATURAL");
        cbxN.setEnabled(false);
        cbxN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNActionPerformed(evt);
            }
        });
        jPanel2.add(cbxN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        cbxJ.setBackground(new java.awt.Color(255, 255, 255));
        cbxJ.setText("JURIDICA");
        cbxJ.setEnabled(false);
        cbxJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJActionPerformed(evt);
            }
        });
        jPanel2.add(cbxJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 20));

        txtNe.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        txtNe.setEnabled(false);
        txtNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNeActionPerformed(evt);
            }
        });
        jPanel2.add(txtNe, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 110, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Primer Nombre");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        cbxC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "P", "G", "J", "C" }));
        cbxC.setEnabled(false);
        jPanel2.add(cbxC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 50, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 0, 0));
        jLabel12.setText("*");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 20, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("*");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 20, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 0, 0));
        jLabel14.setText("*");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 20, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*Datos Obligatorios");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 120, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("*");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 20, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 520, -1));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 0, 0));
        jLabel21.setText("Hacer doble click en la tabla para editar los datos.");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 330, -1));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNeActionPerformed

    private void cbxJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJActionPerformed
        if (cbxJ.isSelected()) {
            cbxN.setSelected(false);
            txtNe.setEnabled(true);
            txtN1.setEnabled(false);
            txtN2.setEnabled(false);
            txtA1.setEnabled(false);
            txtA2.setEnabled(false);
        } else {
        }
    }//GEN-LAST:event_cbxJActionPerformed

    private void cbxNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNActionPerformed
        if (cbxN.isSelected()) {
            cbxJ.setSelected(false);
            txtNe.setText(null);
            txtNe.setEnabled(false);
            txtN1.setEnabled(true);
            txtN2.setEnabled(true);
            txtA1.setEnabled(true);
            txtA2.setEnabled(true);
        } else {
        }
    }//GEN-LAST:event_cbxNActionPerformed

    private void txtA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA1ActionPerformed

    private void txtN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN2ActionPerformed

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCActionPerformed

    private void txtA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA2ActionPerformed

    private void txtN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR EL CLIENTE SELECCIONADO?");
        if(respuesta == JOptionPane.YES_OPTION){       
           try {
            int fila = this.tbl.getSelectedRow();
            String sql = "delete from clientes where cod_cliente=" + this.tbl.getValueAt(fila, 0);
            Statement st = operaciones.Eliminar(sql);
            int n = st.executeUpdate(sql);
            if (n > 0) {
                this.llenar();
                JOptionPane.showMessageDialog(null, " DATOS ELIMINADOS CORRECTAMENTE");
            }
            operaciones.conn.close();
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR Al ELIMINAR DATOS, COMPRUEBE QUE ESTE SELECCIONADO UN REGISTRO");
            }
        }else{
            this.llenar();
        }
        this.Borrar(3);                                                                                 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        int fila = this.tbl.getSelectedRow();
        if (this.tbl.getSelectedRow()==-1) {
            JOptionPane.showMessageDialog(null, "Seleccione el cliente que desea editar");
        } else {
                if (this.cbxN.isSelected()){
                    try {
                          String sql = "update clientes set cedula=?, primer_nombre=?, segundo_nombre=?, "
                                  + "primer_apellido=?, segundo_apellido=?, direccion=?, telefono1=?,"
                                  + " telefono2=?, email=? where cod_cliente="+this.codigo;
                    PreparedStatement ps = operaciones.Actualizar(sql);
                    ps.setString(1, cbxC.getSelectedItem()+"-"+this.txtC.getText().toLowerCase());    
                    ps.setString(2, this.txtN1.getText().toLowerCase());
                    ps.setString(3, this.txtN2.getText().toLowerCase());
                    ps.setString(4, this.txtA1.getText().toLowerCase());
                    ps.setString(5, this.txtA2.getText().toLowerCase());
                    ps.setString(6, this.txtD.getText().toLowerCase());
                    ps.setLong(7, Long.parseLong(this.txtT1.getText()));
                    if(this.txtT2.getText()!="")
                    ps.setLong(8, Long.parseLong(this.txtT2.getText()));
                    ps.setString(9, this.txtE.getText().toLowerCase());
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "DATOS DEL ClIENTE ACTUALIZADOS CORRECTAMENTE");
                        this.Borrar(3);
                        this.Deshabilitar(3);
                    }
                    operaciones.conn.close();
                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOS DATOS VERIFIQUE QUE SEAN CORRECTOS" + e.getMessage()); 
                    }
                      this.llenar();
                } else{
                try {
                          String sql = "update clientes set cedula=?, nombre_empresa=?, direccion=?, telefono1=?,"
                                  + " telefono2=?, email=? where cod_cliente="+this.codigo;
                    PreparedStatement ps = operaciones.Actualizar(sql);
                    ps.setString(1, cbxC.getSelectedItem()+"-"+this.txtC.getText().toLowerCase());    
                    ps.setString(2, this.txtNe.getText().toLowerCase());
                    ps.setString(3, this.txtD.getText().toLowerCase());
                    ps.setLong(4, Long.parseLong(this.txtT1.getText()));
                    if(this.txtT2.getText()!="")
                    ps.setLong(5, Long.parseLong(this.txtT2.getText()));
                    ps.setString(6, this.txtE.getText().toLowerCase());
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "DATOS DEL ClIENTE ACTUALIZADOS CORRECTAMENTE");
                        this.Borrar(3);
                        this.Deshabilitar(3);
                    }
                    operaciones.conn.close();
                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOS DATOS VERIFIQUE QUE SEAN CORRECTOS" + e.getMessage()); 
                    }
                      this.llenar();    
                } 
            }
    }//GEN-LAST:event_btnEActionPerformed

    private void tblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMousePressed
        int fila = this.tbl.getSelectedRow();
        this.cedula = this.tbl.getValueAt(fila, 6).toString();
        this.codigo = this.tbl.getValueAt(fila, 0).toString();
        try {
            String sql = "select * from clientes where cedula= '" + this.cedula + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while(rs.next()){
                if (rs.getString("nombre_empresa")!="")
                this.txtNe.setText(rs.getString("nombre_empresa"));
                
                if (rs.getString("cedula")!="")
                this.txtC.setText(rs.getString("cedula"));

                if (rs.getString("primer_nombre")!="")
                this.txtN1.setText(rs.getString("primer_nombre"));

                if (rs.getString("segundo_nombre")!="")
                this.txtN2.setText(rs.getString("segundo_nombre"));

                if (rs.getString("primer_apellido")!="")
                this.txtA1.setText(rs.getString("primer_apellido"));

                if (rs.getString("segundo_apellido")!="")
                this.txtA2.setText(rs.getString("segundo_apellido"));

                if (rs.getString("telefono1")!="")
                this.txtT1.setText(rs.getString("telefono1"));

                if (rs.getString("telefono2")!="")
                this.txtT2.setText(rs.getString("telefono2"));
                
                if (rs.getString("direccion")!="")
                this.txtD.setText(rs.getString("direccion"));
                
                if (rs.getString("email")!="")
                this.txtE.setText(rs.getString("email"));
                
                if (rs.getString("cedula")!="")
                this.Desencadenar(rs.getString("cedula"));
                
                if (rs.getString("tipo_persona")!=""){
                    if ("natural".equals(rs.getString("tipo_persona"))){
                        cbxN.setSelected(true);
                        this.Habilitar(1);
                        this.Deshabilitar(2);
                    }else{
                        cbxJ.setSelected(true);
                        this.Habilitar(2);
                        this.Deshabilitar(1);
                    }
                }
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datos incompletos\n"+e);
        }
    }//GEN-LAST:event_tblMousePressed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void txtEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEActionPerformed

    private void txtT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtT2ActionPerformed

    private void btnCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCActionPerformed
boolean resultado = false;
this.Borrar(3);
this.Deshabilitar(3);
if(cbxOpcion.getSelectedIndex()==1){
    cbxC1.setEnabled(true);
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql = "select * from clientes where cedula= '"+this.cbxC1.getSelectedItem()+"-"+this.txtB.getText()+ "'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
            while(rs.next()){
            fila[0]=rs.getString("cod_cliente");
            fila[1]=rs.getString("nombre_empresa");
            fila[2]=rs.getString("primer_nombre");
            fila[3]=rs.getString("segundo_nombre");
            fila[4]=rs.getString("primer_apellido");
            fila[5]=rs.getString("segundo_apellido"); 
            fila[6]=rs.getString("cedula");
            fila[7]=rs.getString("telefono1");
            fila[8]=rs.getString("telefono2");
            fila[9]=rs.getString("email");
            model.addRow(fila);  
            resultado = true;
            }
            if (resultado) {
                tbl.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda");
                this.llenar();
                resultado = false;
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }else if(cbxOpcion.getSelectedIndex()==0){
        cbxC1.setEnabled(false);
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql = "select * from clientes where primer_nombre= '" + this.txtB.getText() + "'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
                while(rs.next()){
                fila[0]=rs.getString("cod_cliente");
                fila[1]=rs.getString("nombre_empresa");
                fila[2]=rs.getString("primer_nombre");
                fila[3]=rs.getString("segundo_nombre");
                fila[4]=rs.getString("primer_apellido");
                fila[5]=rs.getString("segundo_apellido"); 
                fila[6]=rs.getString("cedula");
                fila[7]=rs.getString("telefono1");
                fila[8]=rs.getString("telefono2");
                fila[9]=rs.getString("email");
                model.addRow(fila);
                resultado = true;
            }
            if (resultado) {
                tbl.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda");
                this.llenar();
                resultado = false;
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }else if(cbxOpcion.getSelectedIndex()==2){
        cbxC1.setEnabled(false);
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql = "select * from clientes where nombre_empresa= '" + this.txtB.getText() + "'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
                while(rs.next()){
                fila[0]=rs.getString("cod_cliente");
                fila[1]=rs.getString("nombre_empresa");
                fila[2]=rs.getString("primer_nombre");
                fila[3]=rs.getString("segundo_nombre");
                fila[4]=rs.getString("primer_apellido");
                fila[5]=rs.getString("segundo_apellido"); 
                fila[6]=rs.getString("cedula");
                fila[7]=rs.getString("telefono1");
                fila[8]=rs.getString("telefono2");
                fila[9]=rs.getString("email");
                model.addRow(fila);
                resultado = true;
            }
            if (resultado) {
                tbl.setModel(model);
            } else {
                JOptionPane.showMessageDialog(null, "Sin Resultados en la Busqueda");
                this.llenar();
                resultado = false;
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    }//GEN-LAST:event_btnCActionPerformed

    private void cbxOpcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxOpcionActionPerformed
    if(cbxOpcion.getSelectedIndex()==1){
        cbxC1.setEnabled(true);
    }else{
        cbxC1.setEnabled(false);
    }
    }//GEN-LAST:event_cbxOpcionActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     
    this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
    if(cbxOpcion.getSelectedIndex()==1){
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql="select * from clientes where cedula like '"+this.cbxC1.getSelectedItem()+"-"+this.txtB.getText()+ "%'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
            while(rs.next()){
            fila[0]=rs.getString("cod_cliente");
            fila[1]=rs.getString("nombre_empresa");
            fila[2]=rs.getString("primer_nombre");
            fila[3]=rs.getString("segundo_nombre");
            fila[4]=rs.getString("primer_apellido");
            fila[5]=rs.getString("segundo_apellido"); 
            fila[6]=rs.getString("cedula");
            fila[7]=rs.getString("telefono1");
            fila[8]=rs.getString("telefono2");
            fila[9]=rs.getString("email");
            model.addRow(fila);  
            tbl.setModel(model);
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    if(cbxOpcion.getSelectedIndex()==0){
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql="select * from clientes where primer_nombre like '"+this.txtB.getText()+ "%'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
            while(rs.next()){
            fila[0]=rs.getString("cod_cliente");
            fila[1]=rs.getString("nombre_empresa");
            fila[2]=rs.getString("primer_nombre");
            fila[3]=rs.getString("segundo_nombre");
            fila[4]=rs.getString("primer_apellido");
            fila[5]=rs.getString("segundo_apellido"); 
            fila[6]=rs.getString("cedula");
            fila[7]=rs.getString("telefono1");
            fila[8]=rs.getString("telefono2");
            fila[9]=rs.getString("email");
            model.addRow(fila);  
            tbl.setModel(model);
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
        if(cbxOpcion.getSelectedIndex()==2){
        try {
            String[]titulos={"Codigo","Empresa","Primer Nombre","Segundo Nombre","Primer Apellido","Segundo Apellido","Cedula/RIF","Telefono Principal",
                "Telefono Secundario","Correo Electronico"};
            String sql="select * from clientes where nombre_empresa like '"+this.txtB.getText()+ "%'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[10];
            while(rs.next()){
            fila[0]=rs.getString("cod_cliente");
            fila[1]=rs.getString("nombre_empresa");
            fila[2]=rs.getString("primer_nombre");
            fila[3]=rs.getString("segundo_nombre");
            fila[4]=rs.getString("primer_apellido");
            fila[5]=rs.getString("segundo_apellido"); 
            fila[6]=rs.getString("cedula");
            fila[7]=rs.getString("telefono1");
            fila[8]=rs.getString("telefono2");
            fila[9]=rs.getString("email");
            model.addRow(fila);  
            tbl.setModel(model);
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    if ("".equals(txtB.getText())){
        this.llenar();
    }
    }//GEN-LAST:event_txtBKeyReleased

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
                new Frm_ClientesC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnC;
    private javax.swing.JButton btnE;
    public javax.swing.JComboBox<String> cbxC;
    private javax.swing.JComboBox<String> cbxC1;
    public javax.swing.JRadioButton cbxJ;
    public javax.swing.JRadioButton cbxN;
    private javax.swing.JComboBox<String> cbxOpcion;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JTable tbl;
    public javax.swing.JTextField txtA1;
    public javax.swing.JTextField txtA2;
    private javax.swing.JTextField txtB;
    public javax.swing.JTextField txtC;
    public javax.swing.JTextArea txtD;
    public javax.swing.JTextField txtE;
    public javax.swing.JTextField txtN1;
    public javax.swing.JTextField txtN2;
    public javax.swing.JTextField txtNe;
    public javax.swing.JTextField txtT1;
    public javax.swing.JTextField txtT2;
    // End of variables declaration//GEN-END:variables
}
