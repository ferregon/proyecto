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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author javie
 */
public class CrearMarca extends javax.swing.JFrame {
        conectar cc= new conectar();
        Connection cn= cc.conexion();
        Connection Conn;
        Statement sent;

    /**
     * Creates new form CrearMarca
     */
    public CrearMarca() {
        initComponents();
        mostrardatos();
        limpiar();
        bloquear();
        setTitle("CREAR MARCA");
     setSize(660,400);
     setResizable(false);
     setLocation(450,150);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_cancelar = new javax.swing.JButton();
        btn_nuevo = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        t_nom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btn_eliminar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Cancelar/canc_norm.png"))); // NOI18N
        btn_cancelar.setToolTipText("Cancelar");
        btn_cancelar.setBorder(null);
        btn_cancelar.setBorderPainted(false);
        btn_cancelar.setContentAreaFilled(false);
        btn_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancelar.setFocusPainted(false);
        btn_cancelar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Cancelar/canc_press.png"))); // NOI18N
        btn_cancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Cancelar/canc_roll.png"))); // NOI18N
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancelar);
        btn_cancelar.setBounds(450, 170, 100, 50);

        btn_nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Nuevo/nuevo_norm.png"))); // NOI18N
        btn_nuevo.setToolTipText("Nuevo");
        btn_nuevo.setBorder(null);
        btn_nuevo.setBorderPainted(false);
        btn_nuevo.setContentAreaFilled(false);
        btn_nuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_nuevo.setFocusPainted(false);
        btn_nuevo.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Nuevo/nuevo_press.png"))); // NOI18N
        btn_nuevo.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Nuevo/nuevo_roll.png"))); // NOI18N
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        getContentPane().add(btn_nuevo);
        btn_nuevo.setBounds(30, 180, 110, 40);

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Guardar/save_norm.png"))); // NOI18N
        btn_guardar.setToolTipText("Guardar");
        btn_guardar.setBorder(null);
        btn_guardar.setBorderPainted(false);
        btn_guardar.setContentAreaFilled(false);
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.setFocusPainted(false);
        btn_guardar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Guardar/save_press.png"))); // NOI18N
        btn_guardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Guardar/save_roll.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_guardar);
        btn_guardar.setBounds(170, 180, 110, 35);

        t_nom.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        getContentPane().add(t_nom);
        t_nom.setBounds(200, 110, 240, 30);

        jLabel2.setFont(new java.awt.Font("Tekton Pro Ext", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE DE LA CATEGORIA");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 80, 280, 30);

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CREAR CATEGORIA");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(170, 10, 310, 40);

        t_datos.setFont(new java.awt.Font("Agency FB", 1, 14)); // NOI18N
        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        t_datos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                t_datosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(t_datos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(70, 240, 430, 120);

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Eliminar/eliminar_norm.png"))); // NOI18N
        btn_eliminar.setToolTipText("Eliminar");
        btn_eliminar.setBorder(null);
        btn_eliminar.setBorderPainted(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.setFocusPainted(false);
        btn_eliminar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Eliminar/eliminar_press.png"))); // NOI18N
        btn_eliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/botones_icon/Eliminar/eliminar_roll.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_eliminar);
        btn_eliminar.setBounds(300, 170, 110, 50);

        jButton1.setForeground(new java.awt.Color(255, 0, 0));
        jButton1.setText("X");
        jButton1.setToolTipText("Cerrar");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(590, 20, 40, 30);

        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arrow_left_17809.png"))); // NOI18N
        btn_salir.setToolTipText("Salir");
        btn_salir.setBorder(null);
        btn_salir.setBorderPainted(false);
        btn_salir.setContentAreaFilled(false);
        btn_salir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_salir.setFocusPainted(false);
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        getContentPane().add(btn_salir);
        btn_salir.setBounds(10, 300, 50, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/background-blue-grundgy-wallpapers-wallpaper-clean-miscellaneous-....jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 660, 460);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void mostrardatos(){
        DefaultTableModel modelo= new DefaultTableModel();
        modelo.addColumn("IDMARCAS");
        modelo.addColumn("NOMBRE");
        t_datos.setModel(modelo);
        String[]datos= new String[2];
         try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM marcas");
        while(rs.next()){
            datos[0]=rs.getString(1);
             datos[1]=rs.getString(2);
         
               
              modelo.addRow(datos);
        }
        t_datos.setModel(modelo);
        
         } catch (SQLException ex) {
            Logger.getLogger(Registrousuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    void desbloquear(){
t_nom.setEnabled(true);
btn_nuevo.setEnabled(false);
btn_guardar.setEnabled(true);
btn_cancelar.setEnabled(true);
btn_salir.setEnabled(true);
btn_eliminar.setEnabled(true);
t_nom.requestFocus();
}
    
    void bloquear(){
t_nom.setEnabled(false);
btn_nuevo.setEnabled(true);
btn_guardar.setEnabled(false);
btn_cancelar.setEnabled(false);
btn_salir.setEnabled(true);

}
        void limpiar(){
t_nom.setText("");

}

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        // TODO add your handling code here:
               bloquear();
               limpiar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
                desbloquear();
    }//GEN-LAST:event_btn_nuevoActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
String nombre;
        String sql=" ";

        nombre= t_nom.getText();
        sql="INSERT INTO marcas (NOMBRE) VALUE(?)";
        try{
            PreparedStatement pst= cn.prepareStatement(sql);
            pst.setString(1,nombre);
            

            int n=pst.executeUpdate();
            mostrardatos();
            if(n>0){
                JOptionPane.showMessageDialog(null,"REGISTRO GUARDADO CON EXITO");
                limpiar();
            }
        }catch(SQLException ex){

        }

    }//GEN-LAST:event_btn_guardarActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_t_datosMouseClicked

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
                    PreparedStatement pst = cn.prepareStatement("DELETE FROM marcas WHERE IDMARCAS='" + cod + "'");
                    int n = pst.executeUpdate();
                    if (n > 0) {
                        JOptionPane.showMessageDialog(null, "Borrado");
                        t_datos.setModel(new DefaultTableModel());
                        limpiar();
                        //bloquear();
                       mostrardatos();
                    } else {
                        JOptionPane.showMessageDialog(null, "no se borro");
                    }
                } catch (Exception e) {
                }
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
       
      
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        dispose();
   new F_Menu_P().setVisible(true);
    }//GEN-LAST:event_btn_salirActionPerformed

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
            java.util.logging.Logger.getLogger(CrearMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearMarca.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearMarca().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_nuevo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField t_nom;
    // End of variables declaration//GEN-END:variables
}
