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

/**
 *
 * @author Javier
 */
public class venta extends javax.swing.JFrame {
DefaultTableModel modelotabla;
    private DefaultComboBoxModel modeloCombo;
        
       conectar cc= new conectar();
        Connection cn= cc.conexion();
        Connection Conn;
        Statement sent;

    /**
     * Creates new form venta
     */
    public venta() {
        initComponents();
        // modelotabla = new DefaultTableModel (null, getColumnas());
        cargar("");
        t_stock.setVisible(false);
        txtresultado.setVisible(false);
        setTitle("VENTA");
     setSize(690,500);
     setResizable(false);
     //transparente();
     setLocation(290,30);
    }
void transaparente(){
btn_venta.setOpaque(false);
btn_venta.setContentAreaFilled(false);
btn_venta.setBorderPainted(false);
btn_calculo.setOpaque(false);
btn_calculo.setContentAreaFilled(false);
btn_calculo.setBorderPainted(false);
btn_salir.setOpaque(false);
btn_salir.setContentAreaFilled(false);
btn_salir.setBorderPainted(false);



}
void descontar (){
        int stock,cantidad,resultado;
        String nr1X,nr2X;
        String resultadoX;
        nr1X=t_stock.getText();
        nr2X=t_can.getText();
        stock=Integer.parseInt(nr1X);
        cantidad=Integer.parseInt(nr2X);
        resultado=stock-cantidad;
        resultadoX=String.valueOf(resultado);
        txtresultado.setText(resultadoX);
  try{
    conectar cc = new conectar();
    Connection cn = cc.conexion();
    String sql="UPDATE tproducto SET stock=? WHERE IDPROD=?";
    int fila=t_datos.getSelectedRow();
    String dao=(String)t_datos.getValueAt(fila,0);
    PreparedStatement ps=cn.prepareCall(sql);

            ps.setString(1,txtresultado.getText());
            ps.setString(2,dao);//la llamada sql se muestra en la tabla
            
    int n=ps.executeUpdate();
    if(n>0){
       
        cargar("");
        //JOptionPane.showMessageDialog(null, "Datos modificados");
        }
    }catch (Exception e){
    JOptionPane.showMessageDialog(null, "No seleccionaste nada que editar");
        }
}
private void transparente(){
    btn_salir.setOpaque(false);
    btn_calculo.setContentAreaFilled(false);
    btn_venta.setBorderPainted(false);
     
}
void cargar (String valor){
String[] titulos={"Codigo","Producto" ,"Precio","Stock"};
String [] registros=new String[4];
String sql="SELECT * FROM tproducto where  NOMPROD LIKE '%" + valor + "%'";

modelotabla= new DefaultTableModel(null,titulos);
conectar cc=new conectar ();
Connection cn= cc.conexion();
try {
Statement st=cn.createStatement();
ResultSet rs= st.executeQuery(sql);
while (rs.next()){
registros[0]=rs.getString("IDPROD");
registros[1]=rs.getString("NOMPROD");
registros[2]=rs.getString("Precio");
registros[3]=rs.getString("Stock");
modelotabla.addRow(registros);
         }
t_datos.setModel(modelotabla);
        } catch (SQLException ex) {
JOptionPane.showMessageDialog(null,ex);
        }
}
    
        void desbloquear(){
btn_venta.setEnabled(true);

}
    
    
    void limpiar(){
t_total.setText("");
t_cod.setText("");
t_pre.setText("");
t_stock.setText("");
t_prod.setText("");
t_can.setText("");
aux.setText("");
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
        t_cod = new javax.swing.JTextField();
        t_prod = new javax.swing.JTextField();
        t_pre = new javax.swing.JTextField();
        t_can = new javax.swing.JTextField();
        t_total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_datos = new javax.swing.JTable();
        btn_venta = new javax.swing.JButton();
        btn_calculo = new javax.swing.JButton();
        btn_salir = new javax.swing.JButton();
        txtresultado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        t_stock = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        aux = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 102));
        jPanel1.setLayout(null);
        jPanel1.add(t_cod);
        t_cod.setBounds(530, 40, 114, 30);
        jPanel1.add(t_prod);
        t_prod.setBounds(10, 130, 139, 30);
        jPanel1.add(t_pre);
        t_pre.setBounds(170, 130, 124, 30);
        jPanel1.add(t_can);
        t_can.setBounds(320, 130, 103, 30);
        jPanel1.add(t_total);
        t_total.setBounds(530, 110, 114, 30);

        t_datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 215, 420, 250);

        btn_venta.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/carrito.png"))); // NOI18N
        btn_venta.setText("REALIZAR VENTA");
        btn_venta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ventaActionPerformed(evt);
            }
        });
        jPanel1.add(btn_venta);
        btn_venta.setBounds(440, 210, 240, 70);

        btn_calculo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_calculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/meter_calculator_11440 (1).png"))); // NOI18N
        btn_calculo.setText("REALIZAR CALCULO");
        btn_calculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_calculoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_calculo);
        btn_calculo.setBounds(440, 300, 240, 81);

        btn_salir.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        btn_salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/arrow_right_17840.png"))); // NOI18N
        btn_salir.setText("SALIR");
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir);
        btn_salir.setBounds(440, 390, 240, 70);
        jPanel1.add(txtresultado);
        txtresultado.setBounds(130, 30, 42, 37);

        jLabel1.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BUSCAR");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 170, 100, 29);

        jLabel2.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PRECIO");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(170, 100, 70, 29);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CANTIDAD");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(320, 100, 120, 29);

        jLabel4.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("TOTAL A PAGAR");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(530, 80, 96, 22);
        jPanel1.add(t_stock);
        t_stock.setBounds(30, 30, 43, 37);

        jLabel5.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FACTURA Nº");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(530, 20, 82, 17);

        jLabel6.setFont(new java.awt.Font("BadaBoom BB", 1, 48)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("VENTA");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(270, 10, 120, 48);

        aux.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                auxKeyReleased(evt);
            }
        });
        jPanel1.add(aux);
        aux.setBounds(80, 170, 210, 30);

        jLabel8.setFont(new java.awt.Font("Agency FB", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("PRODUCTO");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 100, 100, 29);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Fondos/blue.jpg"))); // NOI18N
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, -30, 690, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ventaActionPerformed
        // TODO add your handling code here:
        try {
            conectar cc=new conectar();
            Connection cn= cc.conexion();
            String cod,marca, pro, preci,cant,total;
            String sql="";
            cod=t_cod.getText();
            pro=t_prod.getText();
            preci=t_pre.getText();
            cant=t_can.getText();
            total=t_total.getText();
            sql="INSERT INTO tventa (IDVENTA,PRODUCTO,PRECIO,CANTIDAD,IMPORTE)VALUES(?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
             pst.setString(1,cod);
            pst.setString(2,pro);
            pst.setString(3,preci);
            pst.setString(4,cant);
            pst.setString(5,total);
            int n=pst.executeUpdate();
            if (n>0){
                JOptionPane.showMessageDialog(null,"Registrado");
                descontar();
                cargar("");
                limpiar();
            }
        } catch (SQLException ex) {
           Logger.getLogger(venta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btn_ventaActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new F_Menu_P().setVisible(true);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_calculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_calculoActionPerformed
        // TODO add your handling code here:
        int nr1,nr2,resultado;
        String nr1X,nr2X;
        String resultadoX;
        nr1X=t_can.getText();
        nr2X=t_pre.getText();
        nr1=Integer.parseInt(nr1X);
        nr2=Integer.parseInt(nr2X);
        resultado=nr1*nr2;
        resultadoX=String.valueOf(resultado);
        t_total.setText(resultadoX);

    }//GEN-LAST:event_btn_calculoActionPerformed

    private void t_datosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_t_datosMouseClicked
        // TODO add your handling code here:
        if(evt.getButton()==1){
   try{
        conectar cc = new conectar();
            Connection cn = cc.conexion();
      //desbloquear();
        int fila=t_datos.getSelectedRow();
        String sql="select * from tproducto where IDPROD="+t_datos.getValueAt(fila,0);
        sent=cn.createStatement();
        ResultSet rs=sent.executeQuery(sql);
        rs.next();
        
        t_prod.setText(rs.getString("NOMPROD"));
        t_pre.setText(rs.getString("PRECIO"));
        t_can.setText(rs.getString("STOCK"));
        t_stock.setText(rs.getString("STOCK"));

}catch(Exception e){
    e.printStackTrace();
}
    }   
    }//GEN-LAST:event_t_datosMouseClicked

    private void auxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_auxKeyReleased
        // TODO add your handling code here:
           cargar(aux.getText());
    }//GEN-LAST:event_auxKeyReleased

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
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aux;
    private javax.swing.JButton btn_calculo;
    private javax.swing.JButton btn_salir;
    private javax.swing.JButton btn_venta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField t_can;
    private javax.swing.JTextField t_cod;
    private javax.swing.JTable t_datos;
    private javax.swing.JTextField t_pre;
    private javax.swing.JTextField t_prod;
    private javax.swing.JTextField t_stock;
    private javax.swing.JTextField t_total;
    private javax.swing.JTextField txtresultado;
    // End of variables declaration//GEN-END:variables
}
