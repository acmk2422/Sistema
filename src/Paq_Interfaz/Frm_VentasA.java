package Paq_Interfaz;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class Frm_VentasA extends javax.swing.JFrame {

    Paq_Base_Datos.Operaciones_BD operaciones = new Paq_Base_Datos.Operaciones_BD();
    Paq_Clases.Cla_Fecha fecha = new Paq_Clases.Cla_Fecha();
    private boolean update;
    private DefaultTableModel model;
    private DefaultTableModel modelo;
    private String[] fila1 = new String[5];
    private float iva;
    private boolean igual;
    private int acum = 0;
    private String res;

    public Frm_VentasA() {
        initComponents();
        setLocationRelativeTo(null);
        update = false;
        this.Llenar();
        lblNumeroRegistro.setText(String.valueOf(this.NumeroAleatorio()));
    }

    public int getCodigoCli(String cedula) {
        int cod = 0;
        try {
            String sql = "select * from clientes where cedula = '" + cedula + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                cod = rs.getInt("cod_cliente");
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return cod;
    }

    public void Ajustar(JLabel label, ImageIcon icon) {
        //esta funcion ajusta un icono(parametro) al tamaño del label (parametro)
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
        this.repaint();
    }

    private void Llenar() {
        lblFecha.setText(fecha.getFecha());
        try {
            String sql = "select * from clientes";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                if (rs.getString("primer_nombre") == null) {
                    cbxN.addItem(rs.getString("nombre_empresa"));
                } else {
                    cbxN.addItem(rs.getString("primer_nombre") + " " + rs.getString("primer_apellido"));
                }
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                "Cantidad"};
            String sql = "select * from inventario";
            model = new DefaultTableModel(null, titulos);
            ResultSet rs = operaciones.Consultar(sql);
            String[] fila = new String[5];
            while (rs.next()) {
                fila[0] = rs.getString("cod_producto");
                fila[1] = rs.getString("nombre_producto");
                fila[2] = rs.getString("descripcion");
                fila[3] = rs.getString("precio_venta");
                fila[4] = rs.getString("cantidad");
                model.addRow(fila);
            }
            tbl.setModel(model);
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        try {
            String sql1 = "select * from valores where id_valor = 1";
            ResultSet rs = operaciones.Consultar(sql1);
            while (rs.next()) {
                iva = Float.parseFloat(rs.getString("iva"));
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public String NumeroAleatorio() {
        long numero = 0;
        Random rd = new Random();
        numero = rd.nextInt(99999999) + 1;
        try {
            String sql = "select * from ventas where cod_venta= '" + numero + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                numero = Long.parseLong(this.NumeroAleatorio());
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return String.valueOf(numero);
    }

    public String CodigoNumeroAleatorio() {
        long numero = 0;
        Random rd = new Random();
        numero = rd.nextInt(99999999) + 1;
        try {
            String sql = "select * from descripcion where cod_descripcion= '" + numero + "'";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                numero = Long.parseLong(this.NumeroAleatorio());
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return String.valueOf(numero);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        lblNumeroRegistro = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cbxPago = new javax.swing.JComboBox<>();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl2 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        bntElimnar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbxDes = new javax.swing.JComboBox<>();
        txtDes = new javax.swing.JTextField();
        lblIva = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lblCan = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lblSubtotal = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        cbxN = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
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
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        lblResponsable = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jPanel1.setMinimumSize(new java.awt.Dimension(1090, 431));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNumeroRegistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(lblNumeroRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 110, 30));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel34.setText("Forma de Pago");
        jPanel7.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 100, 30));

        cbxPago.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cbxPago.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Efectivo", "Transferencia", "Debito", "Cheque", "Credito", "Otro" }));
        cbxPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPagoActionPerformed(evt);
            }
        });
        jPanel7.add(cbxPago, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 150, 30));

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel36.setText("Numero Registro");
        jPanel7.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 110, 30));

        jLabel40.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel40.setText("Fecha");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 80, 30));

        lblFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel7.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, 30));

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 420, 120));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Descripcion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl2.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        tbl2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Total"
            }
        ));
        tbl2.setSelectionBackground(new java.awt.Color(0, 153, 51));
        tbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 540, 130));

        bntElimnar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-10.png"))); // NOI18N
        bntElimnar.setContentAreaFilled(false);
        bntElimnar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar-14.png"))); // NOI18N
        bntElimnar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntElimnarActionPerformed(evt);
            }
        });
        jPanel2.add(bntElimnar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 112, 32));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 570, 190));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Descuento");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 10, 70, 30));

        cbxDes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "%", "Bsf" }));
        cbxDes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDesActionPerformed(evt);
            }
        });
        jPanel3.add(cbxDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 50, 30));

        txtDes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDesKeyReleased(evt);
            }
        });
        jPanel3.add(txtDes, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 80, 30));

        lblIva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 110, 30));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel11.setText("Bsf");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 40, 30));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel13.setText("Cantidad Productos");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 130, 30));

        lblCan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblCan, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 50, 30));

        jLabel20.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel20.setText("IVA");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 70, 30));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel27.setText("Total");
        jPanel3.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 60, 30));

        lblTotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 110, 30));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel29.setText("Bsf");
        jPanel3.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 30, 30));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel30.setText("Subtotal");
        jPanel3.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 60, 30));

        lblSubtotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.add(lblSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 110, 30));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel32.setText("Bsf");
        jPanel3.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 30, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 420, 130));

        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tornavica.png"))); // NOI18N
        jPanel1.add(lblIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 300, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Datos del Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Nombre/Empresa");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Cedula/RIF");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 30, -1, 30));

        txtC.setEditable(false);
        txtC.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        txtC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCMouseClicked(evt);
            }
        });
        jPanel5.add(txtC, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 90, 30));

        cbxN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxNActionPerformed(evt);
            }
        });
        jPanel5.add(cbxN, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 170, 30));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/update 16x16.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 30, 30));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/agregar 12x12.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 30, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 570, 80));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51), new java.awt.Color(0, 102, 51), new java.awt.Color(0, 153, 51)), "Inventario", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 14), new java.awt.Color(0, 153, 51))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel25.setText("FILTROS:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 60, 20));

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
        jPanel6.add(txtB, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 130, 20));

        jLabel26.setFont(new java.awt.Font("Verdana", 0, 10)); // NOI18N
        jLabel26.setText("BUSQUEDA");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 20));

        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Descripcion", "Codigo" }));
        cbxFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFiltroActionPerformed(evt);
            }
        });
        jPanel6.add(cbxFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 140, 20));

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

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 550, 110));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Button-10.png"))); // NOI18N
        jButton4.setContentAreaFilled(false);
        jButton4.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Button-14.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 112, 32));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 570, 170));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-10.png"))); // NOI18N
        jButton2.setContentAreaFilled(false);
        jButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Atras-14.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 490, 112, 32));

        btnProcesar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Procesar-10.png"))); // NOI18N
        btnProcesar.setContentAreaFilled(false);
        btnProcesar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Procesar-14.png"))); // NOI18N
        btnProcesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProcesarActionPerformed(evt);
            }
        });
        jPanel1.add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 490, 112, 32));

        lblResponsable.setText("jjnm");
        jPanel1.add(lblResponsable, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 390, 60, 20));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-10.png"))); // NOI18N
        jButton1.setContentAreaFilled(false);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Borrar-14.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 112, 32));

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 51));
        jLabel1.setText("Realizar Venta");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 210, -1));

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1040, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int y = modelo.getRowCount();
        //busco donde devolvere la cantidad que estoy eliminando
        for (int i = 0; i < y; i++) {
            int codigo = Integer.parseInt(modelo.getValueAt(i, 0).toString());
            int valor = Integer.parseInt(modelo.getValueAt(i, 2).toString());
            for (int j = 0; j < model.getRowCount(); j++) {
                if (model.getValueAt(j, 0).equals(String.valueOf(codigo))) {
                    model.setValueAt(Integer.parseInt(model.getValueAt(j, 4).toString()) + valor, j, 4);
                    tbl.setModel(model);
                }
            }
        }
        for (int i = 1; i <= y; i++) {
            modelo.removeRow(0);
        }
        lblCan.setText(null);
        lblSubtotal.setText(null);
        lblTotal.setText(null);
        txtDes.setText(null);
        lblIva.setText(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl2MouseClicked
        if (evt.getClickCount() == 2) {
            int fila = this.tbl2.getSelectedRow();
            if (Integer.parseInt(tbl2.getValueAt(this.tbl2.getSelectedRow(), 2).toString()) > 1) {
                //busco donde devolvere la cantidad que estoy eliminando
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    if (modelo.getValueAt(fila, 0).equals(model.getValueAt(i, 0))) {
                        model.setValueAt(Integer.parseInt(model.getValueAt(i, 4).toString()) + 1, i, 4);
                        tbl.setModel(model);
                    }
                }
                tbl2.setValueAt(String.valueOf(Integer.parseInt(tbl2.getValueAt(fila, 2).toString()) - 1), fila, 2);
                modelo.setValueAt(Float.parseFloat(modelo.getValueAt(fila, 2).toString()) * Float.parseFloat(modelo.getValueAt(fila, 3).toString()), fila, 4);
            } else {
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    if (modelo.getValueAt(fila, 0).equals(model.getValueAt(i, 0))) {
                        model.setValueAt(Integer.parseInt(model.getValueAt(i, 4).toString()) + 1, i, 4);
                        tbl.setModel(model);
                    }
                }
                modelo.removeRow(fila);
            }
            this.Calcular();
        }
    }//GEN-LAST:event_tbl2MouseClicked

    private void txtCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCMouseClicked

    }//GEN-LAST:event_txtCMouseClicked

    private void txtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBActionPerformed

    private void tblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMouseClicked
        int fila = this.tbl.getSelectedRow();
        boolean igual = false;
        modelo = (DefaultTableModel) tbl2.getModel();

        if (evt.getClickCount() == 2) {
            this.Añadir();
        }
    }//GEN-LAST:event_tblMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        if (cbxFiltro.getSelectedIndex() == 2) {
            try {
                String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                    "Cantidad"};
                String sql = "select * from inventario where cod_producto = '" + this.txtB.getText().toLowerCase() + "'";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = operaciones.Consultar(sql);
                String[] fila = new String[5];
                while (rs.next()) {
                    fila[0] = rs.getString("cod_producto");
                    fila[1] = rs.getString("nombre_producto");
                    fila[2] = rs.getString("descripcion");
                    fila[3] = rs.getString("precio_venta");
                    fila[4] = rs.getString("cantidad");
                    model.addRow(fila);
                }
                tbl.setModel(model);
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void bntElimnarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntElimnarActionPerformed
        int fila = this.tbl2.getSelectedRow();
        //busco donde devolvere la cantidad que estoy eliminando
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (modelo.getValueAt(fila, 0).equals(model.getValueAt(i, 0))) {
                model.setValueAt(Integer.parseInt(model.getValueAt(i, 4).toString()) + Integer.parseInt(modelo.getValueAt(fila, 2).toString()), i, 4);
                tbl.setModel(model);
            }
        }
        modelo.removeRow(fila);
        this.Calcular();
    }//GEN-LAST:event_bntElimnarActionPerformed

    private void cbxPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPagoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
//se actualiza la BD con los datos de la tabla 1
        if (!txtC.getText().equals("")) {
            if (tbl2.getRowCount() > 0) {
                for (int i = 0; i < tbl.getRowCount(); i++) {
                    String codigo = this.tbl.getValueAt(i, 0).toString();
                    try {
                        String sql = "update inventario set cantidad=? where cod_producto=" + codigo;
                        PreparedStatement ps = operaciones.Actualizar(sql);
                        ps.setInt(1, Integer.parseInt(this.tbl.getValueAt(i, 4).toString()));
                        int n = ps.executeUpdate();
                        if (n > 0 && tbl.getRowCount() == (i + 1)) {
                            //JOptionPane.showMessageDialog(null, "VENDIDO CON EXITO");
                        }
                        operaciones.conn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR AL ACTUALIZAR LOS DATOS VERIFIQUE QUE SEAN CORRECTOS\n" + e.getMessage());
                    }
                }

                //añadir en descripcion
                String codigoDes = "";
                for (int i = 0; i < tbl2.getRowCount(); i++) {
                    float total = Float.parseFloat(res) * Float.parseFloat(tbl.getValueAt(i, 3).toString());
                    try {
                        String sql = "insert into descripcion(cod_descripcion, cod_producto, cantidad"
                                + ", precio, total, cod_venta, descuento)"
                                + "values(?,?,?,?,?,?,?)";
                        String acum = "";
                        int descuento = Integer.parseInt((txtDes.getText().equals("")) ? "0" : txtDes.getText());
                        codigoDes = CodigoNumeroAleatorio();
                        PreparedStatement ps = operaciones.Ingresar(sql);
                        ps.setString(1, codigoDes);
                        ps.setInt(2, Integer.parseInt(tbl.getValueAt(i, 0).toString()));
                        ps.setInt(3, Integer.parseInt(res));
                        ps.setFloat(4, Float.parseFloat(tbl.getValueAt(i, 3).toString()));
                        ps.setFloat(5, total);
                        ps.setInt(6, Integer.parseInt(lblNumeroRegistro.getText()));
                        ps.setInt(7, descuento);
                        int n = ps.executeUpdate();
                        operaciones.conn.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR\ncodigo error:" + e.getMessage());
                    }
                }

// se almacena la venta en la bd
                try {
                    String sql = "insert into ventas(cod_venta, cantidad, descripcion"
                            + ", total, fecha, tipo_de_pago, responsable, descuento, cod_cliente, id_valor)"
                            + "values(?,?,?,?,?,?,?,?,?,?)";
                    String acum = "";
                    PreparedStatement ps = operaciones.Ingresar(sql);
                    ps.setString(1, lblNumeroRegistro.getText());
                    ps.setInt(2, Integer.parseInt(lblCan.getText()));
                    ps.setString(3, codigoDes);
                    ps.setFloat(4, Float.parseFloat(lblTotal.getText()));
                    ps.setString(5, lblFecha.getText());
                    ps.setString(6, cbxPago.getSelectedItem().toString());
                    ps.setString(7, lblResponsable.getText());
                    if (txtDes.getText().equals("")) {
                        ps.setString(8, "0 " + cbxDes.getSelectedItem().toString());
                    } else {
                        ps.setString(8, txtDes.getText() + " " + cbxDes.getSelectedItem().toString());
                    }
                    ps.setInt(9, getCodigoCli(txtC.getText()));
                    ps.setInt(10, 1);
                    int n = ps.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Venta Exitosa");
                        int y = modelo.getRowCount();
                        for (int z = 1; z <= y; z++) {
                            modelo.removeRow(0);
                        }
                        lblCan.setText(null);
                        lblSubtotal.setText(null);
                        lblTotal.setText(null);
                        txtDes.setText(null);
                        lblIva.setText(null);
                        lblNumeroRegistro.setText(this.NumeroAleatorio());
                        this.Llenar();
                    }
                    operaciones.conn.close();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR AL GUARDAR\ncodigo error:" + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciones 1 o mas productos", "", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione un cliente, o añada uno nuevo");
        }


    }//GEN-LAST:event_btnProcesarActionPerformed

    private void cbxNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxNActionPerformed
        if (update == false) {
            //variable para determinar si consiguio algo en clientes
            boolean resultado = false;
            try {
                String sql = "select * from clientes where primer_nombre ='" + this.Desencadenar(cbxN.getSelectedItem().toString()) + "'";
                ResultSet rs = operaciones.Consultar(sql);
                while (rs.next()) {
                    txtC.setText(rs.getString("cedula"));
                    resultado = true;
                }
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            if (resultado == false) {
                try {
                    String sql = "select * from clientes where nombre_empresa ='" + cbxN.getSelectedItem() + "'";
                    ResultSet rs = operaciones.Consultar(sql);
                    while (rs.next()) {
                        txtC.setText(rs.getString("cedula"));
                        resultado = true;
                    }
                    operaciones.conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_cbxNActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        new Paq_Interfaz.Frm_ClientesA().setVisible(true);

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.txtC.setText(null);
        update = true;
        cbxN.removeAllItems();
        try {
            String sql = "select * from clientes";
            ResultSet rs = operaciones.Consultar(sql);
            while (rs.next()) {
                if (rs.getString("primer_nombre") == null) {
                    cbxN.addItem(rs.getString("nombre_empresa"));
                } else {
                    cbxN.addItem(rs.getString("primer_nombre") + " " + rs.getString("primer_apellido"));
                }
            }
            operaciones.conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        update = false;
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyPressed
        int fila = this.tbl.getSelectedRow();
        //VARIABLE PARA DETERMINAR SI ES IGUAL A UNA ANTERIOR SELECIONADA
        igual = false;    //ASIGNO LA FILA SELECCIONADA 

        //ASIGNAR VALORES DE LA TABLA 1 AL MODELO
        modelo = (DefaultTableModel) tbl2.getModel();
        //CAPTURAMOS SI SE PULSA ENTER
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.Añadir();
        }
    }//GEN-LAST:event_tblKeyPressed

    private void tblKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblKeyReleased

    }//GEN-LAST:event_tblKeyReleased

    private void txtBKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBKeyReleased
        if (cbxFiltro.getSelectedIndex() == 0) {
            try {
                String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                    "Cantidad"};
                String sql = "select * from inventario where nombre_producto like '" + this.txtB.getText().toLowerCase() + "%'";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = operaciones.Consultar(sql);
                String[] fila = new String[5];
                while (rs.next()) {
                    fila[0] = rs.getString("cod_producto");
                    fila[1] = rs.getString("nombre_producto");
                    fila[2] = rs.getString("descripcion");
                    fila[3] = rs.getString("precio_venta");
                    fila[4] = rs.getString("cantidad");
                    model.addRow(fila);
                    tbl.setModel(model);
                }
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if (cbxFiltro.getSelectedIndex() == 1) {
            try {
                String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                    "Cantidad"};
                String sql = "select * from inventario where descripcion like '" + this.txtB.getText().toLowerCase() + "%'";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = operaciones.Consultar(sql);
                String[] fila = new String[5];
                while (rs.next()) {
                    fila[0] = rs.getString("cod_producto");
                    fila[1] = rs.getString("nombre_producto");
                    fila[2] = rs.getString("descripcion");
                    fila[3] = rs.getString("precio_venta");
                    fila[4] = rs.getString("cantidad");
                    model.addRow(fila);
                    tbl.setModel(model);

                }
                operaciones.conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        if ("".equals(txtB.getText())) {
            try {
                String[] titulos = {"Codigo", "Nombre", "Descripcion", "Precio",
                    "Cantidad"};
                String sql = "select * from inventario";
                model = new DefaultTableModel(null, titulos);
                ResultSet rs = operaciones.Consultar(sql);
                String[] fila = new String[5];
                while (rs.next()) {
                    fila[0] = rs.getString("cod_producto");
                    fila[1] = rs.getString("nombre_producto");
                    fila[2] = rs.getString("descripcion");
                    fila[3] = rs.getString("precio_venta");
                    fila[4] = rs.getString("cantidad");
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

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus

    }//GEN-LAST:event_formWindowLostFocus

    private void txtDesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDesKeyReleased
        this.Calcular();
    }//GEN-LAST:event_txtDesKeyReleased

    private void cbxDesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDesActionPerformed
        this.Calcular();
    }//GEN-LAST:event_cbxDesActionPerformed

    public String Desencadenar(String datos) {
        //funcion para separar cedula de la letra
        String nombre = "";
        int i = 0, j = 0;
        for (i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == ' ') {

                break;
            } else {
                nombre += datos.charAt(i) + "";
            }
        }
        return nombre;
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
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_VentasA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntElimnar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> cbxDes;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JComboBox<String> cbxN;
    private javax.swing.JComboBox<String> cbxPago;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblCan;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblIva;
    private javax.swing.JLabel lblNumeroRegistro;
    public javax.swing.JLabel lblResponsable;
    private javax.swing.JLabel lblSubtotal;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tbl;
    private javax.swing.JTable tbl2;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtDes;
    // End of variables declaration//GEN-END:variables

    private void Calcular() {
        float subtotal = 0;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            subtotal += Float.parseFloat(modelo.getValueAt(i, 4).toString());
        }
        lblTotal.setText(String.valueOf(subtotal));
        lblIva.setText(String.valueOf(subtotal * (iva / 100)));
        if (txtDes.getText().equals("") || txtDes.getText().equals("0")) {
            lblSubtotal.setText(String.valueOf(Float.parseFloat(lblTotal.getText()) - Float.parseFloat(lblIva.getText())));
        } else {
            float descuento = Float.parseFloat(txtDes.getText());
            if (cbxDes.getSelectedIndex() == 0) {
                lblTotal.setText(String.valueOf(Float.parseFloat(lblTotal.getText()) - (Float.parseFloat(lblTotal.getText()) * (descuento / 100))));
            } else {
                lblTotal.setText(String.valueOf(Float.parseFloat(lblTotal.getText()) - descuento));
            }
        }

        for (int i = 0; i < modelo.getRowCount(); i++) {
            acum += Integer.parseInt(modelo.getValueAt(i, 2).toString());
        }
        lblCan.setText(String.valueOf(acum));
        acum = 0;
    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    private void Añadir() {
        res = JOptionPane.showInputDialog("Cantidad a vender del producto");
        if ("".equals(res)) {
            res = "1";
        }
        if (res != null) {
            if (Integer.parseInt(res) <= Integer.parseInt(this.tbl.getValueAt(tbl.getSelectedRow(), 4).toString())) {
                //cantidad menor a disponible en stock
                fila1[0] = tbl.getValueAt(this.tbl.getSelectedRow(), 0).toString();
                fila1[1] = tbl.getValueAt(this.tbl.getSelectedRow(), 1).toString();
                fila1[2] = (res.equals("")) ? "1" : res;
                fila1[3] = tbl.getValueAt(this.tbl.getSelectedRow(), 3).toString();
                if (tbl2.getRowCount() == 0) {
                    fila1[4] = String.valueOf(Float.parseFloat(fila1[2]) * Float.parseFloat(fila1[3]));
                    modelo.addRow(fila1);
                } else {
                    for (int i = 0; i < tbl2.getRowCount(); i++) {
                        if (tbl2.getValueAt(i, 0).toString().equals(tbl.getValueAt(this.tbl.getSelectedRow(), 0).toString())) {
                            tbl2.setValueAt(String.valueOf(Integer.parseInt(tbl2.getValueAt(i, 2).toString()) + Integer.parseInt(fila1[2])), i, 2);
                            tbl2.setValueAt(Float.parseFloat(tbl2.getValueAt(i, 2).toString()) * Float.parseFloat(tbl2.getValueAt(i, 3).toString()), i, 4);
                            igual = true;
                        }
                    }
                    if (igual == false) {
                        fila1[4] = String.valueOf(Float.parseFloat(fila1[2]) * Float.parseFloat(fila1[3]));
                        modelo.addRow(fila1);
                    }
                }
                igual = false;
                //hacemos la resta a la cantidad en la tabla 1
                int filatbl1 = tbl.getSelectedRow();
                int valor1 = Integer.parseInt(model.getValueAt(filatbl1, 4).toString());
                model.setValueAt(valor1 - Integer.parseInt(res), filatbl1, 4);
                tbl.setModel(model);
                this.Calcular();
            } else {
                JOptionPane.showMessageDialog(null, "Cantidad no disponible en inventario", null, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
