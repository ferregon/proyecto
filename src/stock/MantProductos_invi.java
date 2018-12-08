/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Javier
 */
public class MantProductos_invi extends javax.swing.JFrame {
        DefaultTableModel modelotabla;
        private DefaultComboBoxModel modeloCombo;
        conectar cc= new conectar();
        Connection cn= cc.conexion();
        Connection Conn;
        Statement sent;

    /**
     * Creates new form MantProductos
     */
    public MantProductos_invi() {
        modelotabla = new DefaultTableModel (null, getColumnas());
        modeloCombo = new DefaultComboBoxModel(new String [] {});
        setFilas(); 
        initComponents();
        limpiar();
        bloquear(); 
        cargar("");
        llenaComboBox();
     setTitle("MANTENIMIENTO DE PRODUCTOS");
     setSize(1100,560);
     setResizable(false);
     //transparente();
     setLocation(130,30);

    }
 private String [] getColumnas(){
            String columna[]= new String []{"Codigo", "Nombre", "Producto,","Precio","Direccion"};
        return columna;
    }
    private void setFilas(){
        try {
            String sql ="select * from tproducto ";
            Statement st= cc.conexion().prepareStatement(sql);
            ResultSet rs= st.executeQuery(sql);
            
            Object datos []=new Object [4];
            while (rs.next()){
             for(int i=0; i<4; i++)  {   
                 datos [i]= rs.getObject(i+1) ;  
             } 
             modelotabla.addRow(datos);
            }
            rs.close();
             } catch (SQLException ex) {
            Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
}
    }
   
    void cargar (String valor){
String[] titulos={"Codigo","Marca" ,"Nombre", "Precio,","Stock","Imagen","Direccion"};
String [] registros=new String[7];
String sql="SELECT * FROM tproducto where  IDMARCA LIKE '%" + valor + "%'";
modelotabla= new DefaultTableModel(null,titulos);
conectar cc=new conectar ();
Connection cn= cc.conexion();
try {
Statement st=cn.createStatement();
ResultSet rs= st.executeQuery(sql);
while (rs.next()){
registros[0]=rs.getString("IDPROD");
registros[1]=rs.getString("IDMARCA");
registros[2]=rs.getString("NOMPROD");
registros[3]=rs.getString("PRECIO");
registros[4]=rs.getString("STOCK");
registros[5]=rs.getString("IMAGEN");
registros[6]=rs.getString("DIRECCION");

modelotabla.addRow(registros);
         }
t_datos.setModel(modelotabla);
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null,ex);
        }
}    
   
private void llenaComboBox(){
try { 
String sql = "SELECT * FROM marcas";  /* Realizamos la consulta a la base de datos*/
PreparedStatement verUsuarios = cc.conexion().prepareStatement(sql); /* Se prepara la consulta */
ResultSet ver = verUsuarios.executeQuery();/* Y se ejecuta en la siguiente línea */
while(ver.next()){ /* while recorremos el resultado generado por la consulta */
modeloCombo.addElement(ver.getString(2)); /* fijate como con nuestro modelo y 
su método addElement vamos a agregar cada resultado a nuestro ComboBox, en lo personal concatene el resultado */
 
     }
 } catch (SQLException ex) {Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
 
 }//acaba llenaComboBox//acaba llenaComboBox
 
}

    
    void desbloquear(){
t_nom.setEnabled(true);
t_cod.setEnabled(true);
t_pre.setEnabled(true);
t_stock.setEnabled(true);
btn_nuevo.setEnabled(false);
//btn_eliminar.setEnabled(true);
btn_modificar.setEnabled(true);
btn_cancelar.setEnabled(true);
btn_grabar.setEnabled(true);
btn_salir.setEnabled(true);
jLabel8.setEnabled(true);
txtnomimagen.setEnabled(true);
}
    
    void bloquear(){
t_nom.setEnabled(false);
t_cod.setEnabled(false);
t_pre.setEnabled(false);
t_stock.setEnabled(false);
btn_nuevo.setEnabled(true);
btn_grabar.setEnabled(false);
btn_eliminar.setEnabled(false);
btn_modificar.setEnabled(false);
btn_cancelar.setEnabled(false);
btn_salir.setEnabled(true);
jLabel8.setEnabled(false);
txtnomimagen.setEnabled(false);
}
    
    void limpiar(){
t_nom.setText("");
t_cod.setText("");
t_pre.setText("");
t_stock.setText("");
jLabel8.setIcon(null);
txtnomimagen.setText("");
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        t_stock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        t_pre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_modificar = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        txtnomimagen = new javax.swing.JTextField();
        t_nom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        combomarcas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btn_nuevo = new javax.swing.JButton();
        btn_grabar = new javax.swing.JButton();
        t_cod = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        t_datos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 400, 1010, 120);

        t_stock.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPanel1.add(t_stock);
        t_stock.setBounds(110, 310, 246, 34);

        jLabel7.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BUSCAR");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(300, 362, 50, 30);

        t_pre.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPanel1.add(t_pre);
        t_pre.setBounds(110, 250, 246, 34);

        jLabel6.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRECIO:");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 260, 60, 22);

        btn_modificar.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/pencil_17925.png"))); // NOI18N
        btn_modificar.setToolTipText("Editar");
        btn_modificar.setBorder(null);
        btn_modificar.setBorderPainted(false);
        btn_modificar.setContentAreaFilled(false);
        btn_modificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_modificar.setFocusPainted(false);
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar);
        btn_modificar.setBounds(700, 290, 80, 70);

        btn_salir.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btn_salir.setToolTipText("Salir");
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        btn_salir.setFocusPainted(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir);
        btn_salir.setBounds(880, 290, 80, 80);

        txtnomimagen.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPanel1.add(txtnomimagen);
        txtnomimagen.setBounds(360, 310, 300, 34);

        t_nom.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        jPanel1.add(t_nom);
        t_nom.setBounds(110, 190, 246, 34);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NOMBRE:");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 200, 60, 22);

        combomarcas.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        combomarcas.setModel(modeloCombo);
        combomarcas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combomarcasActionPerformed(evt);
            }
        });
        jPanel1.add(combomarcas);
        combomarcas.setBounds(110, 130, 246, 34);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CATEGORIA");
        jLabel4.setToolTipText("Abrir");
        jLabel4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 132, 80, 30);

        btn_eliminar.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit_delete_17827.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.setBorder(null);
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar);
        btn_eliminar.setBounds(700, 180, 80, 70);

        btn_cancelar.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit_delete_17888.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setBorder(null);
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_cancelar);
        btn_cancelar.setBounds(880, 180, 80, 70);

        jLabel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8);
        jLabel8.setBounds(360, 70, 300, 225);

        btn_nuevo.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/add_insert_new_17850.png"))); // NOI18N
        btn_nuevo.setToolTipText("Nuevo");
        btn_nuevo.setBorder(null);
        btn_nuevo.setBorderPainted(false);
        btn_nuevo.setContentAreaFilled(false);
        btn_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevo.setFocusPainted(false);
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo);
        btn_nuevo.setBounds(710, 80, 70, 70);

        btn_grabar.setFont(new java.awt.Font("Agency FB", 1, 16)); // NOI18N
        btn_grabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/save_14706.png"))); // NOI18N
        btn_grabar.setToolTipText("Grabar");
        btn_grabar.setBorder(null);
        btn_grabar.setBorderPainted(false);
        btn_grabar.setContentAreaFilled(false);
        btn_grabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_grabar.setFocusPainted(false);
        btn_grabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grabarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_grabar);
        btn_grabar.setBounds(880, 80, 80, 70);

        t_cod.setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        t_cod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_codActionPerformed(evt);
            }
        });
        jPanel1.add(t_cod);
        t_cod.setBounds(110, 70, 246, 32);

        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CODIGO:");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 80, 70, 22);

        jLabel1.setFont(new java.awt.Font("BlowBrush", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("MANTENIMIENTO DE PRODUCTOS");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 10, 588, 48);

        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });
        jPanel1.add(aux);
        aux.setBounds(360, 360, 300, 30);

        jLabel10.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("STOCK:");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 320, 50, 22);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/background-blue-grundgy-wallpapers-wallpaper-clean-miscellaneous-....jpg"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(-10, 0, 1120, 540);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1109, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
        desbloquear();
        t_cod.requestFocus();
        t_nom.setText("");
        t_pre.setText("");
        t_stock.setText("");
        

    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_grabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grabarActionPerformed
        // TODO add your handling code here:
        try {
            conectar cc=new conectar();
            Connection cn= cc.conexion();
            FileInputStream archivofoto;
            String cod,marca, nom, preci, stock,direccion;
            String sql="";
            cod=t_cod.getText();
            marca=combomarcas.getSelectedItem().toString();
             nom=t_nom.getText();
            preci=t_pre.getText();
            stock=t_stock.getText();
            direccion=txtnomimagen.getText();
            sql="INSERT INTO tproducto (IDPROD,IDMARCA, NOMPROD, PRECIO, STOCK, IMAGEN,DIRECCION)VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1,cod);
            pst.setString (2,marca);
            pst.setString(3,nom);
            pst.setString(4,preci);
            pst.setString(5,stock);
            pst.setString(6,txtnomimagen.getText());
            archivofoto= new FileInputStream(txtnomimagen.getText());
            pst.setBinaryStream(6, archivofoto);
            pst.setString(7,direccion);
            int n=pst.executeUpdate();
            if (n>0){
                cargar("");
                JOptionPane.showMessageDialog(null,"Registro");
                bloquear();
            }
        } catch (SQLException ex) {
           Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
        }
        t_nom.setText("");
        t_cod.setText("");
        //t_cod.setText("");
        t_pre.setText("");
        t_stock.setText("");
    }//GEN-LAST:event_btn_grabarActionPerformed

    private void t_codActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_codActionPerformed
        // TODO add your handling code here:
        t_cod.transferFocus();
    }//GEN-LAST:event_t_codActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        String ruta,nombre;
        final JFileChooser elegirImagen = new JFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if(o == JFileChooser.APPROVE_OPTION){
            ruta = elegirImagen.getSelectedFile().getAbsolutePath();
            nombre = elegirImagen.getSelectedFile().getName();
            txtnomimagen.setText(ruta);
            Image preview = Toolkit.getDefaultToolkit().getImage(ruta);
            if(preview != null){
                jLabel8.setText("");
                ImageIcon icon = new ImageIcon(preview.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_DEFAULT));
                jLabel8.setIcon(icon);
            }
        }

    }//GEN-LAST:event_jLabel8MouseClicked

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
               bloquear();
               limpiar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        conectar cc = new conectar();
        Connection cn = cc.conexion();
        int eliminar;
        eliminar = t_datos.getSelectedRow();
        if (eliminar == -1) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna fila");
        } else {
            int valor = JOptionPane.showConfirmDialog(null, "Seguro desea eliminar?", "Advertencia", JOptionPane.YES_NO_OPTION);
            if (valor == JOptionPane.YES_OPTION) {
                int fila = t_datos.getSelectedRow();
                String cod = "";
                cod = t_datos.getValueAt(fila, 0).toString();
                try {
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM tproducto WHERE IDPROD='" + cod + "'");
                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Borrado");
                        t_datos.setModel(new DefaultTableModel());
                        limpiar();
                        bloquear();
                        cargar("");
                    } else {
                        JOptionPane.showMessageDialog(null, "no se borro");
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        dispose();
        new CrearMarcaInvi().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        bloquear();
        limpiar();
        this.dispose();
        new F_Menu_invi().setVisible(true);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        try{
            conectar cc = new conectar();
            Connection cn = cc.conexion();
            String sql="UPDATE tproducto SET IDPROD=?,IDMARCA=?, NOMPROD=?, STOCK=?, PRECIO=?, DIRECCION=?,IMAGEN=?"
            +"WHERE IDPROD=?";
            int fila=t_datos.getSelectedRow();
            FileInputStream archivofoto;
            String dao=(String)t_datos.getValueAt(fila,0);
            PreparedStatement ps=cn.prepareCall(sql);
            ps.setString(1,t_cod.getText());
            ps.setString(2, combomarcas.getSelectedItem().toString());
            ps.setString(3,t_nom.getText());
            ps.setString(4,t_stock.getText());
            ps.setString(5,t_pre.getText());
            ps.setString(6,txtnomimagen.getText());
            archivofoto= new FileInputStream(txtnomimagen.getText());
            ps.setBinaryStream(7, archivofoto);//valor de campos de texto a pasar a
            ps.setString(8,dao);//la llamada sql se muestra en la tabla
            /*Image i=null;
            Blob blob=rs.getBlob("IMAGEN");
            i=javax.imageio.ImageIO.read(blob.getBinaryStream());
            ImageIcon image=new ImageIcon(i.getScaledInstance(jLabel7.getWidth(), jLabel7.getHeight(), Image.SCALE_REPLICATE));
            jLabel7.setIcon(image);*/
            int n=ps.executeUpdate();
            if(n>0){
                limpiar();
                cargar("");
                JOptionPane.showMessageDialog(null, "Datos modificados");
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No seleccionaste nada que editar");
        }
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==1){
            try{
                conectar cc = new conectar();
                Connection cn = cc.conexion();
                desbloquear();
                InputStream is;
                int fila=t_datos.getSelectedRow();
                String sql="select * from tproducto where IDPROD="+t_datos.getValueAt(fila,0);
                sent=cn.createStatement();
                ResultSet rs=sent.executeQuery(sql);
                rs.next();
                t_cod.setText(rs.getString("IDPROD"));
                combomarcas.getSelectedItem().toString();
                t_nom.setText(rs.getString("NOMPROD"));
                t_pre.setText(rs.getString("PRECIO"));
                t_stock.setText(rs.getString("STOCK"));
                txtnomimagen.setText(rs.getString("DIRECCION"));
                Image i=null;
                Blob blob=rs.getBlob("IMAGEN");
                i=javax.imageio.ImageIO.read(blob.getBinaryStream());
                ImageIcon image=new ImageIcon(i.getScaledInstance(jLabel8.getWidth(), jLabel8.getHeight(), Image.SCALE_REPLICATE));
                jLabel8.setIcon(image);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_t_datosMouseClicked

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
        // TODO add your handling code here:
        cargar(aux.getText());
    }//GEN-LAST:event_auxKeyReleased

    private void combomarcasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combomarcasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combomarcasActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MantProductos_invi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantProductos_invi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantProductos_invi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantProductos_invi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantProductos_invi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aux;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_grabar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JComboBox<String> combomarcas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_cod;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField t_nom;
    private javax.swing.JTextField t_pre;
    private javax.swing.JTextField t_stock;
    private javax.swing.JTextField txtnomimagen;
    // End of variables declaration//GEN-END:variables
}
