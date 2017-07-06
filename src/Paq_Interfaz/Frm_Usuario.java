package Paq_Interfaz;

import java.awt.Component;
import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACMK
 */
public class Frm_Usuario extends javax.swing.JFrame {

    private ImageIcon icon1 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"));
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    Paq_Clases.Cla_Fecha fecha = new Paq_Clases.Cla_Fecha ();
    
    public Frm_Usuario() {
        initComponents();
        this.Ajustar(lblLogo, icon1);
        setLocationRelativeTo(null);
        
    }
    
     public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint(); 
    }
     
     public void Borrar(){
         txtN.setText(null);
         txtC1.setText(null);
         txtC2.setText(null);
         txtR.setText(null);
         txtNA.setText(null);
     }
     public String inputContraseña(Component th,String mensaje,String titulo)
        {
        String password = "";
        JPasswordField passwordField = new JPasswordField();
        Object[] obj = {mensaje+":\n\n", passwordField};
        Object stringArray[] = {"OK","Cancel"};
        if (JOptionPane.showOptionDialog(th, obj, titulo,
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
        null, stringArray, obj) == JOptionPane.YES_OPTION)
        {
        password = passwordField.getPassword().toString();
        }
        return password;
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
        btnA = new javax.swing.JButton();
        btnE = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtR = new javax.swing.JPasswordField();
        cbxP = new javax.swing.JComboBox<>();
        txtC2 = new javax.swing.JPasswordField();
        txtC1 = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtNA = new javax.swing.JTextField();
        btnE1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-10.png"))); // NOI18N
        btnA.setContentAreaFilled(false);
        btnA.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Añadir-14.png"))); // NOI18N
        btnA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAActionPerformed(evt);
            }
        });
        jPanel1.add(btnA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 112, 32));

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar-10.png"))); // NOI18N
        btnE.setContentAreaFilled(false);
        btnE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Editar-14.png"))); // NOI18N
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });
        jPanel1.add(btnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 112, 32));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        jButton3.setContentAreaFilled(false);
        jButton3.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 112, 32));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Usuarios");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 120, 40));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 300, 70));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)));
        jPanel2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtN.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(txtN, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 200, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel2.setText("Usuario");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel4.setText("Repita Contraseña");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 140, 30));

        jLabel6.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel6.setText("Pregunta de Seguridad");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 160, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel5.setText("Respuesta de Seguridad");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 170, 30));

        txtR.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtR.setToolTipText("");
        txtR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRActionPerformed(evt);
            }
        });
        jPanel2.add(txtR, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 260, 30));

        cbxP.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        cbxP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "¿Nombre de su primera Mascota?", "¿Marca de su primer Auto?", "¿Nombre de su mejor amigo de infancia?", "¿Numero de Acta de Nacimiento?", "¿Nombre de Cantante Favorito?", "¿Nombre de Grupo Musical Favorito?", "¿Lugar de Nacimiento?", "¿Nombre de bisabuela/o?", "¿Nombre de Color Favorito?" }));
        cbxP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPActionPerformed(evt);
            }
        });
        jPanel2.add(cbxP, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 280, 30));

        txtC2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtC2.setToolTipText("");
        txtC2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtC2ActionPerformed(evt);
            }
        });
        jPanel2.add(txtC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 200, 30));

        txtC1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        txtC1.setToolTipText("");
        jPanel2.add(txtC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 200, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel7.setText("Nombre y Apellido del trabajador");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 30));

        txtNA.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel2.add(txtNA, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 200, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 510, 250));

        btnE1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-10.png"))); // NOI18N
        btnE1.setContentAreaFilled(false);
        btnE1.setEnabled(false);
        btnE1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-14.png"))); // NOI18N
        btnE1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnE1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, 112, 32));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
    boolean resultado = false;
    String pregunta = "";
    String respuesta = "";
    String usuario="";
    try {
            String sql = "select * from usuario where nombre= '" + JOptionPane.showInputDialog(null, "Ingrese el nombre de usuario a editar", null, JOptionPane.INFORMATION_MESSAGE) + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while(rs.next()){
                usuario = rs.getString("nombre");
                pregunta = rs.getString("pregunta_seguridad");
                respuesta = rs.getString("respuesta");
                resultado = true;
            }
        if (resultado==false) {
            JOptionPane.showMessageDialog(null, "No Existe el Usuario", null, JOptionPane.ERROR_MESSAGE);
            resultado = false;
        }
        if (resultado) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel(pregunta+": ");
            JPasswordField pass = new JPasswordField(10);
            panel.add(label);
            panel.add(pass);
            String[] options = new String[]{"OK", "Cancelar"};
            int option = JOptionPane.showOptionDialog(null, panel, "Verificacion",
                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
                         null, options, options[1]);
            if(option == 0)
            {
                char[] password = pass.getPassword();
                if (new String(password).equals(respuesta)) {
                JOptionPane.showMessageDialog(null, "Identificado con exito ya puede modifcar sus datos", null, JOptionPane.INFORMATION_MESSAGE,new javax.swing.ImageIcon(getClass().getResource("/imagenes/bien 48x48.png")));
                btnA.setText("Modificar");
                btnE.setEnabled(true);
                btnE1.setEnabled(true);
                String sql1 = "select * from usuario where nombre= '" +usuario+ "'";
                ResultSet rs1 = operaciones.Consultar(sql1);
                while(rs1.next()){
                    txtN.setText(rs1.getString("nombre"));
                    txtNA.setText(rs1.getString("nombreT"));
                    txtN.setEnabled(false);
                    cbxP.setSelectedItem(pregunta);
                    resultado = true;
                } 
                }else{
                    JOptionPane.showMessageDialog(null, "Datos Incorrectos", null, JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datos incompletos\n"+e);
        }
    }//GEN-LAST:event_btnEActionPerformed

    private void cbxPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPActionPerformed

    private void txtRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRActionPerformed

    private void btnAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAActionPerformed
if ("Modificar".equals(btnA.getText())) {
    char[] arrayC1 = txtC1.getPassword(); 
    String c1 = new String(arrayC1);
    char[] arrayC2 = txtR.getPassword(); 
    String c2 = new String(arrayC2);
    char[] arrayC3 = txtC2.getPassword(); 
    String c3 = new String(arrayC3);
if (!c1.equals("") && !c3.equals("") && !c2.equals("")) {
     if (c1.equals(c3)) {
                try {
                String sql = "update usuario set clave=?, pregunta_seguridad=?, respuesta=?, fecha_modificacion=?, nombret=? where nombre='"+txtN.getText()+"'";
                PreparedStatement ps = operaciones.Actualizar(sql);
                ps.setString(1, c1);     
                ps.setString(2, cbxP.getSelectedItem().toString());
                ps.setString(3, c2);
                ps.setString(4, fecha.getFecha());
                ps.setString(5, txtNA.getText());
                int n = ps.executeUpdate();
                if (n > 0) {
                    JOptionPane.showMessageDialog(null, "DATOS DEL USUARIO ACTUALIZADOS CORRECTAMENTE");
                    btnA.setText("Agregar");
                    btnE.setEnabled(false);
                    btnE1.setEnabled(false);
                    txtN.setEnabled(true);
                    cbxP.setSelectedIndex(0);
                    this.Borrar();
                }
                operaciones.conn.close();
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOS DATOS VERIFIQUE QUE SEAN CORRECTOS\n" + e.getMessage()); 
        }
            } else {
                JOptionPane.showMessageDialog(null, "LAS CONTRASEÑA NO COINCIDEN",null,JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS",null,JOptionPane.ERROR_MESSAGE);
        }
} else {
    char[] arrayC1 = txtC1.getPassword(); 
    String c1 = new String(arrayC1);
    char[] arrayC2 = txtC2.getPassword(); 
    String c2 = new String(arrayC2);
    char[] arrayC3 = txtR.getPassword(); 
    String c3 = new String(arrayC3);
        if (!c1.equals("") && !c2.equals("") && !c3.equals("")) {
                   if (c1.equals(c2)) {
                       try {
                    String sql = "insert into usuario(nombre, clave, pregunta_seguridad, respuesta,"
                            + " fecha_creacion, fecha_modificacion, nombreT) values(?,?,?,?,?,?,?)";
                    PreparedStatement ps = operaciones.Ingresar(sql);
                    ps.setString(1, txtN.getText());
                    ps.setString(2, c1);
                    ps.setString(3, cbxP.getSelectedItem().toString().toLowerCase());
                    ps.setString(4, c3);
                    ps.setString(5, fecha.getFecha());
                    ps.setString(6, fecha.getFecha());
                    ps.setString(7, txtNA.getText());
                    int n = ps.executeUpdate();
                        if (n > 0) {
                            JOptionPane.showMessageDialog(null, "Usuario Creado CON EXITO",null,1, new javax.swing.ImageIcon(getClass().getResource("/imagenes/bien 48x48.png")));
                            this.Borrar();
                        }
                        operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"ERROR AL GUARDAR\ncodigo error:"+e.getMessage());
        }
            } else {
                JOptionPane.showMessageDialog(null, "LAS CONTRASEÑA NO COINCIDEN",null,JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "RELLENE TODOS LOS CAMPOS",null,JOptionPane.ERROR_MESSAGE);
        }           
} 
    }//GEN-LAST:event_btnAActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnE1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnE1ActionPerformed
if (btnA.getText().equals("Modificar")) {
int respuesta = JOptionPane.showConfirmDialog(null, "¿ESTA SEGURO QUE DESEA ELIMINAR A "+txtN.getText()+" del SISTEMA?");
        if(respuesta == JOptionPane.YES_OPTION && !txtN.getText().equals("")){       
           try {
            String sql = "delete from usuario where nombre= '"+txtN.getText()+"'";
            Statement st = operaciones.Eliminar(sql);
            int n = st.executeUpdate(sql);
            if (n > 0) {
                JOptionPane.showMessageDialog(null, "USUARIO ELIMINADO CORRECTAMENTE");
                this.Borrar();
                btnA.setText("Agregar");
                btnE1.setEnabled(false);
            }
            operaciones.conn.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR Al ELIMINAR DATOS \n"+e);
            }
        }   
}      
    }//GEN-LAST:event_btnE1ActionPerformed

    private void txtC2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtC2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtC2ActionPerformed

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
                new Frm_Usuario().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnE;
    private javax.swing.JButton btnE1;
    private javax.swing.JComboBox<String> cbxP;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtC1;
    private javax.swing.JPasswordField txtC2;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtNA;
    private javax.swing.JPasswordField txtR;
    // End of variables declaration//GEN-END:variables
}
