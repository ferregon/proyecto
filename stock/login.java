/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package stock;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Javier
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        
        initComponents();
     setTitle("LOGIN");
     setSize(720, 508);
     setResizable(false);
     setLocation(350,50);
    }
    void acceder(String usuario, String pass){
        String cap="";
        String sql="SELECT * FROM usuario WHERE nombre='"+usuario+"'AND contraseña='"+pass+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
        
            while(rs.next()){
               cap=rs.getString("tipo");
            }
            
            if(cap.equals("Administrador")){
            
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema "+ usuario);
            F_Menu_P ingreso=new F_Menu_P();
            ingreso.setVisible(true);
            ingreso.pack();
            //vistacliente.lblusu.setText(usuario);
            }
            
            if(cap.equals("Invitado")){
            
            this.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bienvenido al Sistema "+ usuario);
            F_Menu_invi ingresos=new F_Menu_invi();
            ingresos.setVisible(true);
            ingresos.pack();
            //Menu_Invitado.lblusuario.setText(usuario);
            }
            
             if((!cap.equals("Administrador"))&&(!cap.equals("Invitado"))){
            
                JOptionPane.showMessageDialog(this, "NO EXISTEN SUS DATOS");
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
        btningresar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnborrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnsalir1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USERname");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(270, 140, 210, 48);

        txtusuario.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel1.add(txtusuario);
        txtusuario.setBounds(210, 190, 320, 40);

        contraseña.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jPanel1.add(contraseña);
        contraseña.setBounds(210, 290, 320, 40);

        btningresar.setBackground(new java.awt.Color(255, 255, 255));
        btningresar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btningresar.setForeground(new java.awt.Color(0, 51, 255));
        btningresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arrow_right_178402.png"))); // NOI18N
        btningresar.setText("LOGIN");
        btningresar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btningresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btningresarActionPerformed(evt);
            }
        });
        jPanel1.add(btningresar);
        btningresar.setBounds(300, 340, 150, 50);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Algerian", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PASSWORD");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(270, 240, 200, 50);

        btnborrar.setBackground(new java.awt.Color(102, 153, 255));
        btnborrar.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnborrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/exit_delete_17888.png"))); // NOI18N
        btnborrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnborrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnborrar);
        btnborrar.setBounds(120, 390, 150, 80);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/login.png"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(300, 0, 140, 140);

        btnsalir1.setBackground(new java.awt.Color(102, 153, 255));
        btnsalir1.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        btnsalir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/salir.png"))); // NOI18N
        btnsalir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalir1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir1);
        btnsalir1.setBounds(480, 390, 150, 80);

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
        // TODO add your handling code here:
       /* String Usuario=txtusuario.getText();
        String Contraseña=contraseña.getText();
        
        if(Usuario.equals("jsaucedo")&&Contraseña.equals("Jsaucedo123")|| Usuario.equals("javier")&&Contraseña.equals("Jferreira")){
            JOptionPane.showMessageDialog(null,"Bienvenido al Sistema");
            Menu_Principal c=new Menu_Principal();
            c.setVisible(true);
            this.dispose();
        }else{
            JOptionPane.showMessageDialog(null,"Te equivocaste de usuario o de Contraseña \n"+"vuelva a intentarlo");
            txtusuario.setText("");
            contraseña.setText("");
        }*/
       String usu=txtusuario.getText();
        String pas=new String(contraseña.getPassword());
        acceder(usu,pas);
    }//GEN-LAST:event_btningresarActionPerformed

    private void btnborrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnborrarActionPerformed
     txtusuario.setText("");
     contraseña.setText("");     
    }//GEN-LAST:event_btnborrarActionPerformed

    private void btnsalir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalir1ActionPerformed
        // TODO add your handling code here:
        dispose();  
    }//GEN-LAST:event_btnsalir1ActionPerformed

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
    private javax.swing.JButton btnborrar;
    private javax.swing.JButton btningresar;
    private javax.swing.JButton btnsalir1;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
conectar cc=new conectar();
Connection cn=cc.conexion();
}
