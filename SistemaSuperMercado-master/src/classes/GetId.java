/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.ConexaoMySQL;

/**
 *
 * @author LucianoRex
 */
//@teste
public class GetId {
  
    public String getId(String tabela, String campo) {
        
        Connection con = ConexaoMySQL.getConnection();
        //Connection con = ConexaoFireBird.getConnection();
        String sql = "SELECT MAX(" + tabela + "." + campo + ")AS COD FROM " + tabela;
//          String sql = "SELECT FIRST 1(" + tabela + "." + campo + ")AS COD FROM " +tabela+" "
//                  + " ORDER BY "+ tabela + "." + campo +" DESC";
       String id = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                //String linha[] = {rs.getString("COD"), rs.getString("UNIDADE")};
                //String id = rs.getString("COD");
                id = rs.getString("COD");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "" + ex.getMessage());
        }
        return id;
    }

}
