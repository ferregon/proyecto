/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stock;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.SqlUsers;
import models.hash;
import models.users;

/**
 *
 * @author Javier
 */
public class login extends javax.swing.JFrame {
         DefaultTableModel modelotabla;
        private DefaultComboBoxModel modeloCombo;
        conectar cc= new conectar();
        Connection cn= cc.conexion();
        Connection Conn;
        Statement sent;
        //Variable publica
    public boolean mostrar = true;
     /* Creates new form login
     */
    public login() {
      modelotabla = new DefaultTableModel (null, getColumnas());
        modeloCombo = new DefaultComboBoxModel(new String [] {});
//        setFilas(); 
        initComponents();
                //Ocultamiento y muestreo de componentes
        txtPassOculto.setVisible(true);
        txtPassVisible.setVisible(false);
        limpiar();
        //bloquear(); 
        //cargar("");
        llenaComboBox();
     setTitle("LOGIN");
     setSize(720, 508);
     setResizable(false);
     setLocation(350,50);
    }
    private String [] getColumnas(){
            String columna[]= new String []{"id", "nombre", "contraseña,","tipo"};
        return columna;
    }
//    private void setFilas(){
//        try {
//            String sql ="select * from usuario ";
//            Statement st= cc.conexion().prepareStatement(sql);
//            ResultSet rs= st.executeQuery(sql);
//            
//            Object datos []=new Object [4];
//            while (rs.next()){
//             for(int i=0; i<4; i++)  {   
//                 datos [i]= rs.getObject(i+1) ;  
//             } 
//             modelotabla.addRow(datos);
//            }
//            rs.close();
//             } catch (SQLException ex) {
//            Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
//}
//    }
    private void limpiar() {
        txtPassOculto.setText("");
        txtPassVisible.setText("");
        txt_pass.setText("");
    }
    
    private void llenaComboBox(){
try { 
String sql = "SELECT * FROM usuario";  /* Realizamos la consulta a la base de datos*/
PreparedStatement verUsuarios = cc.conexion().prepareStatement(sql); /* Se prepara la consulta */
ResultSet ver = verUsuarios.executeQuery();/* Y se ejecuta en la siguiente línea */
while(ver.next()){ /* while recorremos el resultado generado por la consulta */
modeloCombo.addElement(ver.getString(2)); /* fijate como con nuestro modelo y 
su método addElement vamos a agregar cada resultado a nuestro ComboBox, en lo personal concatene el resultado */
 
     }
 } catch (SQLException ex) {Logger.getLogger(MantProductos_invi.class.getName()).log(Level.SEVERE, null, ex);
 
 }//acaba llenaComboBox//acaba llenaComboBox
 
}
//    void acceder(String usuario, String pass){
//        F_Menu_P menu = new F_Menu_P();
//        String cap="";
//        String sql="SELECT * FROM usuario WHERE nombre='"+usuario+"'AND contraseña='"+pass+"'";
//        try {
//            Statement st = cn.createStatement();
//            ResultSet rs = st.executeQuery(sql);
//        
//            while(rs.next()){
//               cap=rs.getString("tipo");
//            }
//            String tipo = cap;
//            
//            if(!"Administrador".equals(tipo)){
//                menu.btnagregar.setEnabled(false);
//            } 
//            menu.setVisible(true);
//            menu.pack();
//            menu.btnagregar.setEnabled(false);
//            menu.reporte.setEnabled(false);
//            this.dispose();
//            System.out.print(tipo);         
//             if((!cap.equals("Administrador"))&&(!cap.equals("Invitado"))){
//            
//                JOptionPane.showMessageDialog(this, "NO EXISTEN SUS DATOS");
//            
//            }
//            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPassOculto = new javax.swing.JPasswordField();
        txtPassVisible = new javax.swing.JTextField();
        btningresar = new javax.swing.JButton();
        txt_pass = new javax.swing.JLabel();
        btn_mostrar = new javax.swing.JButton();
        btnborrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        combouser = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERNAME");
        jLabel1.setToolTipText("");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(240, 140, 270, 43);

        txtPassOculto.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel1.add(txtPassOculto);
        txtPassOculto.setBounds(210, 290, 320, 40);
        jPanel1.add(txtPassVisible);
        txtPassVisible.setBounds(210, 290, 320, 40);

        btningresar.setBackground(new java.awt.Color(255, 255, 255));
        btningresar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 0, 153));
        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Aceptar/acep_norm.png"))); // NOI18N
        btningresar.setToolTipText("INGRESAR");
        btningresar.setBorder(null);
        btningresar.setBorderPainted(false);
        btningresar.setContentAreaFilled(false);
        btningresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btningresar.setDisabledIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arrow_right_178402.png"))); // NOI18N
        btningresar.setFocusPainted(false);
        btningresar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Aceptar/acep_press.png"))); // NOI18N
        btningresar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Aceptar/acep_roll.png"))); // NOI18N
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel1.add(btningresar);
        btningresar.setBounds(310, 350, 120, 40);

        txt_pass.setBackground(new java.awt.Color(255, 255, 255));
        txt_pass.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        txt_pass.setForeground(new java.awt.Color(255, 255, 255));
        txt_pass.setText("PASSWORD");
        jPanel1.add(txt_pass);
        txt_pass.setBounds(240, 240, 260, 50);

        btn_mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Contraseña/ver_contra_norm.png"))); // NOI18N
        btn_mostrar.setBorder(null);
        btn_mostrar.setBorderPainted(false);
        btn_mostrar.setContentAreaFilled(false);
        btn_mostrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_mostrar.setFocusPainted(false);
        btn_mostrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Contraseña/ver_contra_press.png"))); // NOI18N
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mostrar);
        btn_mostrar.setBounds(540, 290, 40, 40);

        btnborrar.setBackground(new java.awt.Color(102, 153, 255));
        btnborrar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnborrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Limpiar/limpiar_norm.png"))); // NOI18N
        btnborrar.setToolTipText("Borrar");
        btnborrar.setBorder(null);
        btnborrar.setContentAreaFilled(false);
        btnborrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnborrar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Limpiar/limpiar_press.png"))); // NOI18N
        btnborrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Limpiar/limpiar_roll.png"))); // NOI18N
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnborrar);
        btnborrar.setBounds(150, 420, 230, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 0, 140, 140);

        btnsalir1.setBackground(new java.awt.Color(102, 153, 255));
        btnsalir1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Salir/salir_norm.png"))); // NOI18N
        btnsalir1.setToolTipText("Salir");
        btnsalir1.setBorder(null);
        btnsalir1.setBorderPainted(false);
        btnsalir1.setContentAreaFilled(false);
        btnsalir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnsalir1.setFocusPainted(false);
        btnsalir1.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Salir/salir_press.png"))); // NOI18N
        btnsalir1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Salir/salir_roll.png"))); // NOI18N
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir1);
        btnsalir1.setBounds(490, 420, 110, 50);

        combouser.setFont(new java.awt.Font("Agency FB", 0, 18)); // NOI18N
        combouser.setModel(modeloCombo);
        combouser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combouserActionPerformed(evt);
            }
        });
        jPanel1.add(combouser);
        combouser.setBounds(210, 190, 320, 40);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/fondo-azul-1024x683.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 730, 490);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
    private void btningresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btningresarActionPerformed
        String usu =combouser.getSelectedItem().toString();
        String pass=new String(txtPassOculto.getPassword());
        SqlUsers modSql = new SqlUsers();
        users mod = new users();
        
      
        
        if (!usu.equals("") && !pass.equals("")) {
            
            String nuevoPass = hash.md5(pass);
            mod.setUser(usu);
            mod.setPassword(nuevoPass);
            
            if (modSql.login(mod)) {
                F_Menu_P p = new F_Menu_P();
                JOptionPane.showMessageDialog(null, "Bienvenido " + usu);
                   p.setVisible(true);
                   p.pack();
                   p.lbluser.setText(usu.toUpperCase());
                   p.lbltype.setText(mod.getType_user().toUpperCase());
                   String typeuser = mod.getType_user().toString();
                   if(!"Administrador".equals(typeuser)){
                       p.btnagregar.setEnabled(false);
                   }
                   this.setVisible(false);
                
               
                
            } else {
                JOptionPane.showMessageDialog(null, "Datos incorrectos");
                limpiar();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos");
        }    
    }//GEN-LAST:event_btningresarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
     combouser.getSelectedItem().toString();
     txtPassOculto.setText(""); 
     txtPassVisible.setText("");
    }//GEN-LAST:event_btnborrarActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        // TODO add your handling code here:
        dispose(); 
        new MENU().setVisible(true);
    }//GEN-LAST:event_btnsalir1ActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        // TODO add your handling code here:
         //Proceso condicional para mostrar e ocultar la contraseña
        if (mostrar)
         {
            //Ocultamiento y muestreo de componentes
            txtPassVisible.setVisible(true);
            txtPassOculto.setVisible(false);
            
            //Consultamos el valor existente de Pass Oculto 
            //lo añadimos como nuevo valor para Pass Visible.
            txtPassVisible.setText(txtPassOculto.getText());
            
            //Le decimos al sistema que en el proximo click que de el 
            //usuario debe de mostrarse la contrseña en modo Oculto.
            mostrar = false;
         }else{
                //Ocultamiento y muestreo de componentes
                txtPassVisible.setVisible(false);
                txtPassOculto.setVisible(true);
                
                //Consultamos el valor existente de Pass Visible
                //lo añadimos como nuevo valor para Pass Oculto.
                txtPassOculto.setText(txtPassVisible.getText());
                
                //Le decimos al sistema que en el proximo click que de el 
                //usuario debe de mostrarse la contrseña en modo visible.
                mostrar = true;
              }
        
    }//GEN-LAST:event_btn_mostrarActionPerformed

    private void combouserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combouserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combouserActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mostrar;
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JComboBox<String> combouser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtPassOculto;
    private javax.swing.JTextField txtPassVisible;
    private javax.swing.JLabel txt_pass;
    // End of variables declaration//GEN-END:variables

}
