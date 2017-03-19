/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author LucianoRex
 */
//@teste
public class ConexaoMySQL {

    private static Connection connection;

    public static Connection getConnection() {

        try {          
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        String url = "jdbc:mysql://localhost/SISTEMASUPERMERCADO";        
        String usuario = "root";        
        String senha = "Tec2016!";
        try {
            connection = DriverManager.getConnection(url, usuario, senha);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel conectar" + ex.getMessage());
        }
        return connection;
    }
}
