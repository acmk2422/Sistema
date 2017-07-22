package Paq_Interfaz;

import Atxy2k.CustomTextField.RestrictedTextField;
import com.sun.webkit.event.WCKeyEvent;
import java.awt.Color;
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
public class Frm_ProveedoresC extends javax.swing.JFrame {

    
    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    private String cedula;
    private String codigo;
    DefaultTableModel model;
    
    public Frm_ProveedoresC() {
        initComponents();
        setLocationRelativeTo(null);
        this.llenar();
        this.Deshabilitar(1);
       
         
}     
     private boolean Verificacion2() {
            String email;
            boolean emailCorrecto=true;
            email=txtE.getText();
            emailCorrecto=email.matches("[-\\w.]+@\\w+\\.\\w+");  
            
         if (txtN.getText().equals("")|| txtC.getText().equals("") || txtT1.getText().equals("")|| txtD.getText().equals("")
                || txtE.getText().equals("") ||emailCorrecto){
          
            JOptionPane.showMessageDialog(null, "Verifique:\n"
                    + "1. Que los Campos no esten vacios\n"
                    + "2. Que los numeros telefonicos tenga 11 digitos y que el formato del correo sea correcto", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } else {
            return true;
        }
    }
   
    
    
   
   
    private void Borrar(int tipo) {
        //Elimina campos llenos en el formulario
        switch (tipo){
            case 3:
                txtN.setText(null);
                txtCo.setText(null);
                txtC.setText(null);
                txtD.setText(null);
                txtT1.setText(null);
                txtT2.setText(null);
                txtE.setText(null);
                break;
        }
    }
    
    public void llenar(){
        try {
            String[]titulos={"Codigo","Nombre","RIF","Pais","Telefono Principal",
                "Telefono Secundario","Correo Electronico","Descripcion","Estado"};
            String sql="select * from proveedores";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= operaciones.Consultar(sql);
            String[]fila=new String[9];
            while(rs.next()){
            fila[0]=rs.getString("cod_proveedor");
            fila[1]=rs.getString("nombre");
            fila[2]=rs.getString("rif");
            fila[3]=rs.getString("pais");
            fila[4]=rs.getString("telefono1");
            fila[5]=rs.getString("telefono2"); 
            fila[6]=rs.getString("email");
            fila[7]=rs.getString("descripcion");
            fila[8]=rs.getString("estado");
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
            txtN.setEnabled(true);
            txtD.setEnabled(true);
            txtCo.setEnabled(true);
            txtC.setEnabled(true);
            txtE.setEnabled(true);
            txtT1.setEnabled(true);
            txtT2.setEnabled(true);
            cbxC.setEnabled(true);
            cbxP.setEnabled(true);
            cbxE.setEnabled(true);
        }
        
    }
    
    public void Deshabilitar(int x){
        if (x==1) {
            txtN.setEnabled(false);
            txtD.setEnabled(false);
            txtCo.setEnabled(false);
            txtC.setEnabled(false);
            txtE.setEnabled(false);
            txtT1.setEnabled(false);
            txtT2.setEnabled(false);
            cbxC.setEnabled(false);
            cbxP.setEnabled(false);
            cbxE.setEnabled(false);
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

        jDialog2 = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        txtB = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        btnE = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtN = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCo = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        cbxP = new javax.swing.JComboBox<>();
        cbxC = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cbxE = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtT1 = new javax.swing.JTextField();
        txtE = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtD = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtT2 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cbxOpcion = new javax.swing.JComboBox<>();
        cbxC1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel1.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 180, 30));

        jScrollPane1.setEnabled(false);

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1040, 130));

        btnE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar-10.png"))); // NOI18N
        btnE.setContentAreaFilled(false);
        btnE.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Guardar-14.png"))); // NOI18N
        btnE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEActionPerformed(evt);
            }
        });
        jPanel1.add(btnE, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 112, 32));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        jButton6.setContentAreaFilled(false);
        jButton6.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 112, 32));

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 310, 60));

        jLabel8.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 51));
        jLabel8.setText("Proveedores");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 190, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Personales", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtN.setSelectionColor(new java.awt.Color(0, 102, 51));
        txtN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNActionPerformed(evt);
            }
        });
        txtN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNKeyTyped(evt);
            }
        });
        jPanel4.add(txtN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 180, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("RIF");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 60, 30));

        txtC.setSelectionColor(new java.awt.Color(0, 102, 51));
        txtC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCKeyTyped(evt);
            }
        });
        jPanel4.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 110, 30));

        jLabel21.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel21.setText("Estado:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 60, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Nombre");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 60, 30));

        txtCo.setColumns(1);
        txtCo.setRows(5);
        txtCo.setSelectionColor(new java.awt.Color(0, 102, 51));
        jScrollPane4.setViewportView(txtCo);

        jPanel4.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 210, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Pais");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 30));

        cbxP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "afganistán", "akrotiri", "albania", "alemania", "andorra", "angola", "anguila", "antártida", "antigua y barbuda", "antillas neerlandesas", "arabia saudí", "arctic ocean", "argelia", "argentina", "armenia", "aruba", "ashmore andcartier islands", "atlantic ocean", "australia", "austria", "azerbaiyán", "bahamas", "bahráin", "bangladesh", "barbados", "bélgica", "belice", "benín", "bermudas", "bielorrusia", "birmania myanmar", "bolivia", "bosnia y hercegovina", "botsuana", "brasil", "brunéi", "bulgaria", "burkina faso", "burundi", "bután", "cabo verde", "camboya", "camerún", "canadá", "chad", "chile", "china", "chipre", "clipperton island", "colombia", "comoras", "congo", "coral sea islands", "corea del norte", "corea del sur", "costa de marfil", "costa rica", "croacia", "cuba", "dhekelia", "dinamarca", "dominica", "ecuador", "egipto", "el salvador", "el vaticano", "emiratos árabes unidos", "eritrea", "eslovaquia", "eslovenia", "españa", "estados unidos", "estonia", "etiopía", "filipinas", "finlandia", "fiyi", "francia", "gabón", "gambia", "gaza strip", "georgia", "ghana", "gibraltar", "granada", "grecia", "groenlandia", "guam", "guatemala", "guernsey", "guinea", "guinea ecuatorial", "guinea-bissau", "guyana", "haití", "honduras", "hong kong", "hungría", "india", "indian ocean", "indonesia", "irán", "iraq", "irlanda", "isla bouvet", "isla christmas", "isla norfolk", "islandia", "islas caimán", "islas cocos", "islas cook", "islas feroe", "islas georgia del sur y sandwich del sur", "islas heard y mcdonald", "islas malvinas", "islas marianas del norte", "islasmarshall", "islas pitcairn", "islas salomón", "islas turcas y caicos", "islas vírgenes americanas", "islas vírgenes británicas", "israel", "italia", "jamaica", "jan mayen", "japón", "jersey", "jordania", "kazajistán", "kenia", "kirguizistán", "kiribati", "kuwait", "laos", "lesoto", "letonia", "líbano", "liberia", "libia", "liechtenstein", "lituania", "luxemburgo", "macao", "macedonia", "madagascar", "malasia", "malaui", "maldivas", "malí", "malta", "man, isle of", "marruecos", "mauricio", "mauritania", "mayotte", "méxico", "micronesia", "moldavia", "mónaco", "mongolia", "montserrat", "mozambique", "namibia", "nauru", "navassa island", "nepal", "nicaragua", "níger", "nigeria", "niue", "noruega", "nueva caledonia", "nueva zelanda", "omán", "pacific ocean", "países bajos", "pakistán", "palaos", "panamá", "papúa-nueva guinea", "paracel islands", "paraguay", "perú", "polinesia francesa", "polonia", "portugal", "puerto rico", "qatar", "reino unido", "república centroafricana", "república checa", "república democrática del congo", "república dominicana", "ruanda", "rumania", "rusia", "sáhara occidental", "samoa", "samoa americana", "san cristóbal y nieves", "san marino", "san pedro y miquelón", "san vicente y las granadinas", "santa helena", "santa lucía", "santo tomé y príncipe", "senegal", "seychelles", "sierra leona", "singapur", "siria", "somalia", "southern ocean", "spratly islands", "sri lanka", "suazilandia", "sudáfrica", "sudán", "suecia", "suiza", "surinam", "svalbard y jan mayen", "tailandia", "taiwán", "tanzania", "tayikistán", "territoriobritánicodel océano indico", "territorios australes franceses", "timor oriental", "togo", "tokelau", "tonga", "trinidad y tobago", "túnez", "turkmenistán", "turquía", "tuvalu", "ucrania", "uganda", "unión europea", "uruguay", "uzbekistán", "vanuatu", "venezuela", "vietnam", "wake island", "wallis y futuna", "west bank", "world", "yemen", "yibuti", "zambia", "zimbabue" }));
        cbxP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPActionPerformed(evt);
            }
        });
        jPanel4.add(cbxP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 180, 30));

        cbxC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "P", "G", "J", "C" }));
        jPanel4.add(cbxC, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 50, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("*");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 20, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("*");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 20, 20));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText("*");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 20, 20));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setText("Comentarios");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 90, 30));

        cbxE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "activo", "inactivo" }));
        cbxE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxEActionPerformed(evt);
            }
        });
        jPanel4.add(cbxE, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 150, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 510, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos Contacto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtT1.setSelectionColor(new java.awt.Color(0, 102, 51));
        txtT1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtT1KeyTyped(evt);
            }
        });
        jPanel2.add(txtT1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 130, 30));

        txtE.setSelectionColor(new java.awt.Color(0, 102, 51));
        jPanel2.add(txtE, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 130, 30));

        txtD.setColumns(1);
        txtD.setRows(5);
        txtD.setSelectionColor(new java.awt.Color(0, 102, 51));
        jScrollPane5.setViewportView(txtD);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 190, 70));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel12.setText("Telefono Principal");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 30));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel14.setText("Correo Electronico");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 30));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel15.setText("Telefono Secundario");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 130, 30));

        txtT2.setSelectionColor(new java.awt.Color(0, 102, 51));
        txtT2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtT2KeyTyped(evt);
            }
        });
        jPanel2.add(txtT2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 130, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Direccion");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 0, 0));
        jLabel20.setText("*");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 20, 20));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("*");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 20, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("*");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 20, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("*Datos Obligatorios");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 100, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 520, 150));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Filtro de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Cedula/RIF", "Pais" }));
        cbxOpcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxOpcionActionPerformed(evt);
            }
        });
        jPanel3.add(cbxOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 120, 30));

        cbxC1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "V", "E", "P", "G", "J", "C" }));
        cbxC1.setEnabled(false);
        cbxC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxC1ActionPerformed(evt);
            }
        });
        jPanel3.add(cbxC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 50, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, 200, 60));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Hacer doble click en la tabla para editar los datos.");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 330, -1));

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEActionPerformed
        int fila = this.tbl.getSelectedRow();
        if (Verificacion2()) {
          if (this.tbl.getSelectedRow()==-1) {
            JOptionPane.showMessageDialog(null, "Seleccione el proveedor que desea editar");
        } else {
                    try {
                          String sql = "update proveedores set rif=?, nombre=?,"
                                  + "direccion=?, telefono1=?, telefono2=?, email=?, descripcion=?, pais=?, estado=? where cod_proveedor="+this.codigo;
                    PreparedStatement ps = operaciones.Actualizar(sql);
                    ps.setString(1, cbxC.getSelectedItem()+"-"+this.txtC.getText().toLowerCase());    
                    ps.setString(2, this.txtN.getText().toLowerCase());
                    ps.setString(3, this.txtD.getText().toLowerCase());
                    ps.setLong(4, Long.parseLong(this.txtT1.getText()));
                    if(this.txtT2.getText()!="")
                    ps.setLong(5, Long.parseLong(this.txtT2.getText()));
                    ps.setString(6, this.txtE.getText().toLowerCase());
                    ps.setString(7, this.txtCo.getText().toLowerCase());
                    ps.setString(8, this.cbxP.getSelectedItem().toString().toLowerCase());
                    ps.setString(9, this.cbxE.getSelectedItem().toString().toLowerCase());
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "DATOS DEL PROVEEDOR ACTUALIZADOS CORRECTAMENTE");
                        this.Borrar(3);
                        this.Deshabilitar(1);
                    }
                    operaciones.conn.close();
                    } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOS DATOS VERIFIQUE QUE SEAN CORRECTOS\n" + e.getMessage()); 
                    }
                      this.llenar(); 
            }  
        } 
        
    }//GEN-LAST:event_btnEActionPerformed

    private void tblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMousePressed
        int fila = this.tbl.getSelectedRow();
        this.cedula = this.tbl.getValueAt(fila, 2).toString();
        this.codigo = this.tbl.getValueAt(fila, 0).toString();
        try {
            String sql = "select * from proveedores where rif= '" + this.cedula + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while(rs.next()){
                if (rs.getString("nombre")!="")
                this.txtN.setText(rs.getString("nombre"));
                
                if (rs.getString("rif")!="")
                this.txtC.setText(rs.getString("rif"));

                if (rs.getString("email")!="")
                this.txtE.setText(rs.getString("email"));

                if (rs.getString("direccion")!="")
                this.txtD.setText(rs.getString("direccion"));

                if (rs.getString("telefono1")!="")
                this.txtT1.setText(rs.getString("telefono1"));

                if (rs.getString("telefono2")!="")
                this.txtT2.setText(rs.getString("telefono2"));

                if (rs.getString("pais")!="")
                this.cbxP.setSelectedItem(rs.getString("pais"));

                if (rs.getString("descripcion")!="")
                this.txtCo.setText(rs.getString("descripcion"));
                
                if (rs.getString("rif")!="")
                this.Desencadenar(rs.getString("rif"));
                
                if (rs.getString("estado")!="")
                this.cbxE.setSelectedItem(rs.getString("estado"));
                
                this.Habilitar(1);
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Datos incompletos\n"+e);
        }
    }//GEN-LAST:event_tblMousePressed

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

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

    private void txtNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNActionPerformed

    private void cbxPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPActionPerformed

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
    this.requestFocus();
    }//GEN-LAST:event_formWindowLostFocus

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
//select * from EMPLEADOS where APELLIDOS like 'R%' 
    if(cbxOpcion.getSelectedIndex()==1){
        try {
            String[]titulos={"Codigo","Nombre","RIF","Pais","Telefono Principal",
                "Telefono Secundario","Correo Electronico","Descripcion","Estado"};
            String sql="select * from proveedores where rif like '"+this.cbxC1.getSelectedItem()+"-"+this.txtB.getText().toLowerCase()+"%'";
            model= new DefaultTableModel(null,titulos);
            ResultSet rs= operaciones.Consultar(sql);
            String[]fila=new String[9];
            while(rs.next()){
            fila[0]=rs.getString("cod_proveedor");
            fila[1]=rs.getString("nombre");
            fila[2]=rs.getString("rif");
            fila[3]=rs.getString("pais");
            fila[4]=rs.getString("telefono1");
            fila[5]=rs.getString("telefono2"); 
            fila[6]=rs.getString("email");
            fila[7]=rs.getString("descripcion");     
            fila[8]=rs.getString("estado");     
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
            String[]titulos={"Codigo","Nombre","RIF","Pais","Telefono Principal",
                "Telefono Secundario","Correo Electronico","Descripcion","Estado"};
            String sql="select * from proveedores where nombre like '"+this.txtB.getText().toLowerCase()+"%'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[9];
            while(rs.next()){
            fila[0]=rs.getString("cod_proveedor");
            fila[1]=rs.getString("nombre");
            fila[2]=rs.getString("rif");
            fila[3]=rs.getString("pais");
            fila[4]=rs.getString("telefono1");
            fila[5]=rs.getString("telefono2"); 
            fila[6]=rs.getString("email");
            fila[7]=rs.getString("descripcion");
            fila[8]=rs.getString("estado"); 
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
            String[]titulos={"Codigo","Nombre","RIF","Pais","Telefono Principal",
                "Telefono Secundario","Correo Electronico","Descripcion","Estado"};
            String sql="select * from proveedores where pais like '"+this.txtB.getText().toLowerCase()+"%'";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[]fila=new String[9];
            while(rs.next()){
            fila[0]=rs.getString("cod_proveedor");
            fila[1]=rs.getString("nombre");
            fila[2]=rs.getString("rif");
            fila[3]=rs.getString("pais");
            fila[4]=rs.getString("telefono1");
            fila[5]=rs.getString("telefono2"); 
            fila[6]=rs.getString("email");
            fila[7]=rs.getString("descripcion"); 
            fila[8]=rs.getString("estado"); 
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

    private void cbxC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxC1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxC1ActionPerformed

    private void cbxEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxEActionPerformed

    private void txtT1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtT1KeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        int lim = txtT1.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtT1KeyTyped

    private void txtT2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtT2KeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        int lim = txtT2.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 11)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtT2KeyTyped

    private void txtNKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNKeyTyped
        // TODO add your handling code here:
           char c = evt.getKeyChar();
        /*verifico que el caracter sea una letra mayuscula o minuscula o sea la tecla de borrar
         si no emito un sonido e ignoro lo que teclee*/
        if (c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 128 && c <= 165 || c == WCKeyEvent.VK_BACK) {
            //establesco limite
            int lim = txtN.getText().length();
            //cambie este numero que es el limite
            if (lim >= 10) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_txtNKeyTyped

    private void txtCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        int lim = txtC.getText().length();
        if (c >= 48 && c <= 57 || c == WCKeyEvent.VK_BACK) {
            if (this.EventoKeyType(lim, 8)) {
                evt.consume();
                getToolkit().beep();
            }
        } else {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtCKeyTyped

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
                new Frm_ProveedoresC().setVisible(true);
            }
        });
    }
    
    private boolean EventoKeyType(int valor, int limitacion){
            //pido el valor del text y pido el valor limitante
            if (valor >= limitacion) {
                return true;
            }else{
                return false;
            }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnE;
    private javax.swing.JComboBox<String> cbxC;
    private javax.swing.JComboBox<String> cbxC1;
    private javax.swing.JComboBox<String> cbxE;
    private javax.swing.JComboBox<String> cbxOpcion;
    private javax.swing.JComboBox<String> cbxP;
    private javax.swing.JButton jButton6;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblLogo;
    public javax.swing.JTable tbl;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextArea txtCo;
    private javax.swing.JTextArea txtD;
    private javax.swing.JTextField txtE;
    private javax.swing.JTextField txtN;
    private javax.swing.JTextField txtT1;
    private javax.swing.JTextField txtT2;
    // End of variables declaration//GEN-END:variables
}
