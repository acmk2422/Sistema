package Paq_Interfaz;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.webkit.event.WCKeyEvent;
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
public class Frm_VentasC extends javax.swing.JFrame {

    
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    private String cedula;
    private String codigo;
    DefaultTableModel model;
    
    public Frm_VentasC() {
        initComponents();
        setLocationRelativeTo(null);
        this.llenar();
        this.restringir();
    }
      public void restringir(){ 
        RestrictedTextField restricted3 = new RestrictedTextField(this.txtB1);
      
        restricted3.setLimit(10);
        }

    
    public void llenar(){
        try {
            String[]titulos={"Codigo","Fecha","Cliente","Cantidad","Total"};
            String sql="select * from ventas inner join clientes on clientes.cod_cliente = ventas.cod_cliente";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= operaciones.Consultar(sql);
            String[]fila=new String[5];
            while(rs.next()){
            fila[0]=rs.getString("cod_venta");
            fila[1]=rs.getString("fecha");
            if (rs.getString("tipo_persona").equals("juridica")) {
                        fila[2]=rs.getString("nombre_empresa");
                    }else {
                        fila[2]=rs.getString("primer_nombre")+" "+rs.getString("primer_apellido");
                    }
            fila[3]=rs.getString("cantidad");
            fila[4]=rs.getString("total");
                model.addRow(fila);      
            }
            tbl.setModel(model);
            operaciones.conn.close();
            } catch (SQLException e) {
               JOptionPane.showMessageDialog(null, e.getMessage());    
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

        jDialog2 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        txtB1 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };

        jDialog2.setModal(true);

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

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 112, 32));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, 60));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Ventas Realizadas");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, 250, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 60, 20));

        txtB1.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtB1ActionPerformed(evt);
            }
        });
        txtB1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtB1KeyReleased(evt);
            }
        });
        jPanel6.add(txtB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 160, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 80, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Codigo", "Cliente", "Fecha" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 150, 20));

        tbl.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51))));
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

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 710, 110));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 730, 180));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed

    }//GEN-LAST:event_tblKeyPressed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked

    }//GEN-LAST:event_tblMouseClicked

    private void cbxFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxFiltroActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_cbxFiltroActionPerformed

    private void txtB1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtB1KeyReleased
int c = evt.getKeyChar();
if(cbxFiltro.getSelectedIndex()==0){
    if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
         try {
                String[]titulos={"Codigo","Fecha","Cliente","Cantidad","Total"};
                String sql="select * from ventas inner join clientes on clientes.cod_cliente = ventas.cod_cliente " +
                "where cod_venta like '"+this.txtB1.getText().toLowerCase()+"%'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                fila[0]=rs.getString("cod_venta");
                fila[1]=rs.getString("fecha");
if (rs.getString("tipo_persona").equals("juridica")) {
                        fila[2]=rs.getString("nombre_empresa");
                    }else {
                        fila[2]=rs.getString("primer_nombre")+" "+rs.getString("primer_apellido");
                    }
                fila[3]=rs.getString("cantidad");
                fila[4]=rs.getString("total");
                model.addRow(fila); 
                }
                tbl.setModel(model);
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese Solo Numeros","ERROR",JOptionPane.ERROR_MESSAGE);
            this.txtB1.setText("");
        }
        }
        if(cbxFiltro.getSelectedIndex()==1){
             if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
            try {
                String[]titulos={"Codigo","Fecha","Cliente","Cantidad","Total"};
                String sql="select * from ventas inner join clientes on clientes.cod_cliente = ventas.cod_cliente " +
                "where clientes.primer_nombre like '"+this.txtB1.getText().toLowerCase()+"%' or clientes.nombre_empresa like '"+this.txtB1.getText().toLowerCase()+"%'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                    fila[0]=rs.getString("cod_venta");
                    fila[1]=rs.getString("fecha");
                    if (rs.getString("tipo_persona").equals("juridica")) {
                        fila[2]=rs.getString("nombre_empresa");
                    }else {
                        fila[2]=rs.getString("primer_nombre")+" "+rs.getString("primer_apellido");
                    }
                    fila[3]=rs.getString("cantidad");
                    fila[4]=rs.getString("total");
                model.addRow(fila); 
                }
                    tbl.setModel(model);
                    operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Ingrese Solo Letras","ERROR",JOptionPane.ERROR_MESSAGE);
            this.txtB1.setText("");
        }
        }
        if(cbxFiltro.getSelectedIndex()==2){
            try {
                String[]titulos={"Codigo","Fecha","Cliente","Cantidad","Total"};
                String sql="select * from ventas inner join clientes on clientes.cod_cliente = ventas.cod_cliente " +
                "where fecha like '"+this.txtB1.getText().toLowerCase()+"%'";
                model= new DefaultTableModel(null,titulos);
                ResultSet rs= operaciones.Consultar(sql);
                String[]fila=new String[5];
                while(rs.next()){
                fila[0]=rs.getString("cod_venta");
                fila[1]=rs.getString("fecha");
                if (rs.getString("tipo_persona").equals("juridica")) {
                        fila[2]=rs.getString("nombre_empresa");
                    }else {
                        fila[2]=rs.getString("primer_nombre")+" "+rs.getString("primer_apellido");
                    }
                fila[3]=rs.getString("cantidad");
                fila[4]=rs.getString("total");
                model.addRow(fila); 
                }
                tbl.setModel(model);
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if ("".equals(txtB1.getText())){
            this.llenar();
        }
    }//GEN-LAST:event_txtB1KeyReleased

    private void txtB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtB1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_VentasC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTable tbl;
    private javax.swing.JTextField txtB1;
    // End of variables declaration//GEN-END:variables
}
