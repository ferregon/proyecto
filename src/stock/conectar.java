/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class conectar {
    Connection conect = null;
 Connection conexion;
    Statement st;
public Connection conexion()
    {
try {

           //Cargamos el Driver MySQL
Class.forName("org.gjt.mm.mysql.Driver");
conect = DriverManager.getConnection("jdbc:mysql://localhost/stock","root","admin");
           //Cargamos el Driver Access
//JOptionPane.showMessageDialog(null,"conectado");
           //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
           //Conectar en red base 
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=//servidor/bd_cw/cw.mdb";
           //ConectarLocalmente
           //String strConect = "jdbc:odbc:Driver=Microsoft Access Driver (*.mdb);DBQ=D:/cwnetbeans/cw.mdb";
          //conect = DriverManager.getConnection(strConect,"",""); 
        } catch (Exception e) {
JOptionPane.showMessageDialog(null,"Error "+e);
}
return conect;


    }
}
