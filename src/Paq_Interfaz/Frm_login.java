/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Paq_Interfaz;

import java.awt.Image;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Navarro
 */
public class Frm_login extends javax.swing.JFrame {

    private ImageIcon icon2 = new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"));
    Paq_Base_Datos.Operaciones_BD operaciones= new Paq_Base_Datos.Operaciones_BD();
    Paq_Clases.Cla_Fecha fecha = new Paq_Clases.Cla_Fecha();
    
    /**
     * Creates new form Frm_login
     */
    public Frm_login() {
        this.look();
        initComponents();
        this.setLocationRelativeTo(null);
        this.Ajustar(lblLogo, icon2);
    }
    
    public void look(){
        //este metodo establece el look and feels de la aplicacion
        try{
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
          e.printStackTrace();
        } 
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
        txtUs = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        btnE = new javax.swing.JButton();
        txtCo = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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

        txtUs.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        txtUs.setName("TxtUsuario"); // NOI18N
        txtUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsActionPerformed(evt);
            }
        });
        jPanel1.add(txtUs, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 190, 30));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir-10.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir-14.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 112, 32));

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 190, 30));

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 51));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 190, 30));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 300, 70));

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Entrar-10.png"))); // NOI18N
        btnE.setContentAreaFilled(false);
        btnE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Entrar-14.png"))); // NOI18N
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });
        jPanel1.add(btnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 112, 32));

        txtCo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        jPanel1.add(txtCo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 190, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1498178095_application-pkcs7-mime.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 30, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1498178060_preferences-desktop-user-password.png"))); // NOI18N
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsActionPerformed
        
    }//GEN-LAST:event_txtUsActionPerformed

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
    
    char[] arrayC1 = txtCo.getPassword(); 
    String c1 = new String(arrayC1);
    if (txtUs.getText().equals("")||(c1.equals(""))) {
        JOptionPane.showMessageDialog(null, " Existen campos vacios ","", JOptionPane.ERROR_MESSAGE);
    } else {
        boolean nombre=false;
        try {
            String sql = "select * from usuario where nombre= '" +txtUs.getText()+ "'";
            ResultSet rs = operaciones.Consultar(sql);
            while(rs.next()){
                nombre=true;
                String usuario=rs.getString("nombre");
            if( c1.equals(rs.getString("clave"))){
                JOptionPane.showMessageDialog(null, "Bienvenido al sistema "+ usuario );
                try {
                    String sql1 = "update usuario set ultimo_acceso=? where nombre= '"+usuario+"'";
                    PreparedStatement ps = operaciones.Actualizar(sql1);
                    ps.setString(1, fecha.getFecha());    
                    int n = ps.executeUpdate();
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR ULTIMO ACCESO" + e.getMessage()); 
                }
                Paq_Interfaz.Frm_Menu menu = new Paq_Interfaz.Frm_Menu();
                menu.lblUsuario.setText(usuario);
                menu.setVisible(true);    
                this.dispose();
            }else{
                   JOptionPane.showMessageDialog(null, "Datos incorrectos","", JOptionPane.ERROR_MESSAGE);
            }
            }
            if(nombre==false){
                   JOptionPane.showMessageDialog(null, "Usuario no encontrado" );
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Problemas con la base de datos\n"+e);
        }     
    }
    }//GEN-LAST:event_btnEActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    public void Ajustar(JLabel label, ImageIcon icon){
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint(); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_login().setVisible(true);
            }
        });
    }
    
        private void UltimoAcceso(){
    
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnE;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPasswordField txtCo;
    private javax.swing.JTextField txtUs;
    // End of variables declaration//GEN-END:variables
}
