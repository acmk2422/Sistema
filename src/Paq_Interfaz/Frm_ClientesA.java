package Paq_Interfaz;

import Paq_Interfaz.Frm_Menu;
import Atxy2k.CustomTextField.RestrictedTextField;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACMK
 */
public class Frm_ClientesA extends javax.swing.JFrame {

    private ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente 128x128.png"));
    private ImageIcon icon2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"));
    Connection conn;
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    /**
     * Creates new form clientes_añadir
     */
        public Frm_ClientesA() {
        initComponents();
        this.restringir();
        setLocationRelativeTo(null);
        this.Ajustar(lblIcono, icon1);
        this.Ajustar(lblLogo, icon2);
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

        jPanel1 = new javax.swing.JPanel();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtE = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        txtT2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtT1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnAg = new javax.swing.JButton();
        btnA = new javax.swing.JButton();
        btnB = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

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
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        txtN1.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN1ActionPerformed(evt);
            }
        });
        txtN1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtN1KeyTyped(evt);
            }
        });
        jPanel2.add(txtN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, -1));

        txtA2.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 120, -1));

        txtC.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCActionPerformed(evt);
            }
        });
        jPanel2.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 110, 70, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Segundo Nombre");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 120, 20));

        txtN2.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtN2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtN2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 120, -1));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel9.setText("Primer Apellido");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txtA1.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtA1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        cbxN.setBackground(new java.awt.Color(255, 255, 255));
        cbxN.setSelected(true);
        cbxN.setText("NATURAL");
        cbxN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNActionPerformed(evt);
            }
        });
        jPanel2.add(cbxN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        cbxJ.setBackground(new java.awt.Color(255, 255, 255));
        cbxJ.setText("JURIDICA");
        cbxJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxJActionPerformed(evt);
            }
        });
        jPanel2.add(cbxJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, 20));

        txtNe.setEnabled(false);
        txtNe.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtNe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNeActionPerformed(evt);
            }
        });
        jPanel2.add(txtNe, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 120, -1));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Primer Nombre");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 20));

        cbxC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "P", "G", "J", "C" }));
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

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 550, 140));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos de Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Direccion");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 20));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Telefono Secundario");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, -1, 20));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Correo Electronico");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 120, 20));

        txtE.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEActionPerformed(evt);
            }
        });
        jPanel3.add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 190, -1));

        txtD.setColumns(1);
        txtD.setRows(1);
        txtD.setSelectionColor(new java.awt.Color(64, 96, 64));
        jScrollPane1.setViewportView(txtD);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 450, 40));

        txtT2.setSelectionColor(new java.awt.Color(64, 96, 64));
        txtT2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtT2ActionPerformed(evt);
            }
        });
        jPanel3.add(txtT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 130, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel10.setText("Telefono Principal");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, 20));

        txtT1.setSelectionColor(new java.awt.Color(64, 96, 64));
        jPanel3.add(txtT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 120, -1));

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
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 120, 20));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 550, 140));

        btnAg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-10.png"))); // NOI18N
        btnAg.setContentAreaFilled(false);
        btnAg.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-14.png"))); // NOI18N
        btnAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgActionPerformed(evt);
            }
        });
        jPanel1.add(btnAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 112, 32));

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        btnA.setContentAreaFilled(false);
        btnA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        jPanel1.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 112, 32));

        btnB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-10.png"))); // NOI18N
        btnB.setContentAreaFilled(false);
        btnB.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-14.png"))); // NOI18N
        btnB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBActionPerformed(evt);
            }
        });
        jPanel1.add(btnB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 112, 32));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 60));

        lblIcono.setFont(new java.awt.Font("Trebuchet MS", 0, 24)); // NOI18N
        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cliente 128x128.png"))); // NOI18N
        jPanel1.add(lblIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 70, 60));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Añadir Cliente");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 200, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgActionPerformed
if (this.verificacion()){ 
    if (cbxN.isSelected()) {
        try {
            String sql = "insert into clientes(primer_nombre, segundo_nombre,primer_apellido, segundo_apellido,"
                    + "cedula, direccion, telefono1, telefono2, email, tipo_persona)"
                + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = operaciones.Ingresar(sql);
            ps.setString(1, txtN1.getText().toLowerCase());
            ps.setString(2, txtN2.getText().toLowerCase());
            ps.setString(3, txtA1.getText().toLowerCase());
            ps.setString(4, txtA2.getText().toLowerCase());
            ps.setString(5, cbxC.getSelectedItem()+"-"+txtC.getText());
            ps.setString(6, txtD.getText().toLowerCase());
            ps.setLong(7, Long.parseLong(txtT1.getText()));
            if(!"".equals(txtT2.getText())){
              ps.setLong(8, Long.parseLong(txtT2.getText()));  
            }else{
              ps.setLong(8, 0); 
            }
            ps.setString(9, txtE.getText().toLowerCase());
            ps.setString(10, cbxN.getText().toLowerCase());    
            int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "CLIENTE INGRESADO CON EXITO");
                    this.Borrar(3);
                }
            operaciones.conn.close();   
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
    } else {
        try {
            String sql = "insert into clientes(nombre_empresa,cedula,direccion,telefono1,telefono2,email, tipo_persona)"
                + "values(?,?,?,?,?,?,?)";
            PreparedStatement ps = operaciones.Ingresar(sql);
            ps.setString(1, txtNe.getText().toLowerCase());
            ps.setString(2, cbxC.getSelectedItem()+"-"+txtC.getText().toLowerCase());
            ps.setString(3, txtD.getText().toLowerCase());
            ps.setLong(4, Long.parseLong(txtT1.getText()));
            if(!"".equals(txtT2.getText())){
              ps.setLong(5, Long.parseLong(txtT2.getText()));  
            }else{
              ps.setLong(5, 0); 
            }
            ps.setString(6, txtE.getText().toLowerCase());
            ps.setString(7, cbxJ.getText().toLowerCase()); 
            int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "CLIENTE INGRESADO CON EXITO");
                    this.Borrar(3);
                }
            operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
    }
}        
    }//GEN-LAST:event_btnAgActionPerformed

    private void txtN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN1ActionPerformed

    private void txtA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA2ActionPerformed

    private void txtN2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtN2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtN2ActionPerformed

    private void txtA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtA1ActionPerformed

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

    private void txtEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEActionPerformed

    private void cbxJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxJActionPerformed
    if (cbxJ.isSelected()) {
            cbxN.setSelected(false);
            txtNe.setEnabled(true);
            this.Borrar(1);
            txtN1.setEnabled(false);
            txtN2.setEnabled(false);
            txtA1.setEnabled(false);
            txtA2.setEnabled(false); 
        } else {
    }
    }//GEN-LAST:event_cbxJActionPerformed

    private void btnBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBActionPerformed
    this.Borrar(3);
    }//GEN-LAST:event_btnBActionPerformed

    private void txtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCActionPerformed

    private void txtNeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNeActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
     
    this.dispose();
    }//GEN-LAST:event_btnAActionPerformed

    private void txtT2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtT2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtT2ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
 this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void txtN1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtN1KeyTyped
    
    }//GEN-LAST:event_txtN1KeyTyped

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
                new Frm_ClientesA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnAg;
    private javax.swing.JButton btnB;
    private javax.swing.JComboBox<String> cbxC;
    private javax.swing.JRadioButton cbxJ;
    private javax.swing.JRadioButton cbxN;
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
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtA1;
    private javax.swing.JTextField txtA2;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextField txtN1;
    private javax.swing.JTextField txtN2;
    private javax.swing.JTextField txtNe;
    private javax.swing.JTextField txtT1;
    private javax.swing.JTextField txtT2;
    // End of variables declaration//GEN-END:variables

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
    
    private boolean verificacion(){
             String email;
            boolean emailCorrecto=true;
            email=txtE.getText();
            emailCorrecto=email.matches("[-\\w.]+@\\w+\\.\\w+");  
            
        if (cbxN.isSelected()) {
            if (!"".equals(txtN1.getText()) && !"".equals(txtA1.getText()) && !"".equals(txtC.getText()) && 
            !"".equals(txtT1.getText()) && !"".equals(txtD.getText()) && !"".equals(txtE.getText()) && emailCorrecto ) {
                return true; 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Compruebe los siguiente:\n1.El formato del correo y telefonos\n2.No existan campos vacios"
                        + "\n3.Los telefonos tengan 11 digitos");
                return false; 
            }
        } else {
            if (!"".equals(txtNe.getText()) && !"".equals(txtC.getText()) && !"".equals(txtT1.getText()) 
                && !"".equals(txtD.getText()) && !"".equals(txtE.getText())) {
                return true; 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Compruebe los siguiente:\n1.El formato del correo y telefonos\n2.No existan campos vacios"
                        + "\n3.Los telefonos tengan 11 digitos");
                return false; 
            }
        }
    } 

   
}
